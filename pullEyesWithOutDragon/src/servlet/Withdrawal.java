package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.WithdrawalDao;
import model.Account;

@WebServlet("/Withdrawal")
public class Withdrawal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("acc");

		if (acc == null) {
			response.sendRedirect("/pullEyesWithOutDragon/Start");
		} else {
			String path = "/withdrawal.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("acc");

		String name = acc.getName();
		String pass = request.getParameter("pass");
		WithdrawalDao with = new WithdrawalDao();
		String msg = with.excute(name,pass);
		if (msg.equals("ok")) {
			session.invalidate();
			String path = "/result.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else {
			acc.setMsg(msg);
			request.setAttribute("acc", acc);
			String path = "/withdrawal.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}
	}
}
