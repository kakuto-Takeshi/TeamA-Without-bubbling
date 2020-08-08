package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Account;
import model.BabaLogic;
import model.Information;

@WebServlet("/Baba")
public class Baba extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("acc");

		if (acc == null) {
			response.sendRedirect("/pullEyesWithOutDragon/Start");
		} else {
			String path = "/baba.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String in = request.getParameter("index");
		HttpSession session = request.getSession();
		BabaLogic logic;
		Information info;

		if(in == null) {
			info = new Information();
			logic = new BabaLogic();
			logic.initGame(info);
		} else {
			info = (Information) session.getAttribute("info");
			logic = (BabaLogic) session.getAttribute("logic");
			int index = Integer.parseInt(in);
			info.setIndex(index);
			try {
				logic.start(info);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		session.setAttribute("info", info);
		session.setAttribute("logic", logic);

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(info);

		PrintWriter pw = response.getWriter();
		pw.print(json);
		pw.close();

	}

}