package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WithdrawalDao {
	private DaoInfo dao;
	private String JDBC;
	private String userDB;
	private String passDB;
	private String sql;

	public WithdrawalDao() {
		dao = new DaoInfo();
		JDBC = dao.getJDBC();
		userDB = dao.getUser();
		passDB = dao.getPass();
		sql = "";
	}

	public String excute(String name, String pass) {
		String msg;
		try {
			Connection con = DriverManager.getConnection(JDBC, userDB, passDB);
			PreparedStatement ps;

			sql = "select name from account where name=? and pass=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rset = ps.executeQuery();

			if (!rset.next()) {
				msg = "パスワードが間違っています";
			} else {

				sql = "delete from account where name =? and pass=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, pass);

				ps.executeUpdate();
				msg = "ok";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "入力内容が間違っています";
		}
		return msg;

	}

}