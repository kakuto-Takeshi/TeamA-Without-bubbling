package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDao;
import model.Account;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String path = "/register.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String sex = request.getParameter("sex");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String age = request.getParameter("age");
		System.out.println(name);
		System.out.println(pass);
		System.out.println(sex);
		System.out.println(mail);
		System.out.println(phone);
		System.out.println(age);
		Account acc = new Account(name, pass, sex, mail, phone, age);
		RegisterDao reg = new RegisterDao();
		String msg = reg.excute(acc);
		System.out.println(msg);

		if (msg.equals("ok")) {
			acc.setMsg(msg);
			HttpSession session = request.getSession();
			session.setAttribute("acc", acc);
			response.sendRedirect("/pullEyesWithOutDragon/Start");
		} else {
			acc.setMsg(msg);
			request.setAttribute("acc", acc);
			String path = "register.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}
	}

}
