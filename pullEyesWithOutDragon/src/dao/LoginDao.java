package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

	private DaoInfo dao;
	private String JDBC;
	private String userDB;
	private String passDB;
	private String sql;

	public LoginDao() {
		dao = new DaoInfo();
		JDBC = dao.getJDBC();
		userDB = dao.getUser();
		passDB = dao.getPass();
		sql = "";
	}

	public boolean excute(String user , String pass) {
		try {
			sql = "select name from account where name=? and pass=?";

			Connection con = DriverManager.getConnection(JDBC , userDB , passDB);
			PreparedStatement ps=  con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
