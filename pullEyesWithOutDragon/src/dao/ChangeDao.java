package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;

public class ChangeDao {
	private DaoInfo dao;
	private String JDBC;
	private String userDB;
	private String passDB;
	private String sql;

	public ChangeDao() {
		dao = new DaoInfo();
		JDBC = dao.getJDBC();
		userDB = dao.getUser();
		passDB = dao.getPass();
		sql = "";
	}

	public String excute(Account acc) {
		String msg = null;

		try {
			Connection con = DriverManager.getConnection(JDBC, userDB, passDB);
			PreparedStatement ps;

			sql = "select name,pass,sex,mail,phone,age from account where name=? and pass=? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, acc.getName());
			ps.setString(2, acc.getPass());

			ResultSet rset = ps.executeQuery();
			if (rset.next()) {
				//						String x = rset.getString("name");
				//						acc.setName(x);
				acc.setName(rset.getString("name"));
				acc.setPass(rset.getString("pass"));
				acc.setSex(rset.getString("sex"));
				acc.setMail(rset.getString("mail"));
				acc.setPhone(rset.getString("phone"));
				acc.setAge(rset.getString("age"));

			} else {

			}
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "入力内容が間違っています";
		}
		return msg;

	}

	public String excute1(String name, String pass,String sex, String mail,String phone, String age,String name1, String pass1) {

		String msg;

		try {
			Connection con = DriverManager.getConnection(JDBC, userDB, passDB);
			PreparedStatement ps;



				sql = "update account set  sex =? , mail=? , phone =? , age=? ,name=?,pass=? where name=? and pass=?";
				ps = con.prepareStatement(sql);
				//					ps.setString(1, acc.getName());
				//					ps.setString(2, acc.getPass());
				ps.setString(1, sex);
				ps.setString(2, mail);
				ps.setString(3, phone);
				ps.setString(4, age);
				ps.setString(5, name1);
				ps.setString(6, pass1);
				ps.setString(7, name);
				ps.setString(8, pass);
				ps.executeUpdate();
				msg = "ok";

		} catch (SQLException e) {
			e.printStackTrace();
			msg = "入力内容が間違っています";
		}
		return msg;
	}
}
