package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ChangeDao;
import model.Account;

@WebServlet("/Change")
public class Change extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		Account acc = (Account) session.getAttribute("acc");

		if (acc == null) {
			response.sendRedirect("/pullEyesWithOutDragon/Start");
		} else {

			ChangeDao cha = new ChangeDao();

			cha.excute(acc);

			String path = "/change.jsp";
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
		String pass = acc.getPass();
		String sex = request.getParameter("sex");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String age = request.getParameter("age");
		String name1 = request.getParameter("name");
		String pass1 = request.getParameter("pass");


		ChangeDao cha = new ChangeDao();

		String msg = cha.excute1(name, pass, sex, mail, phone, age, name1, pass1);

		if (msg.equals("ok")) {

			acc.setName(name1);
			acc.setPass(pass1);
			acc.setSex(sex);
			acc.setMail(mail);
			acc.setPhone(phone);
			acc.setAge(age);
			String path = "index.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else {

			acc.setMsg(msg);
			request.setAttribute("acc", acc);
			String path = "change.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}
	}

}