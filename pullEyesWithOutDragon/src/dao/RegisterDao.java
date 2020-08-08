package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;

public class RegisterDao {
	private DaoInfo dao;
	private String JDBC;
	private String userDB;
	private String passDB;
	private String sql;

	public RegisterDao() {
		dao = new DaoInfo();
		JDBC = dao.getJDBC();
		userDB = dao.getUser();
		passDB = dao.getPass();
		sql = "";
	}

	public String excute(Account acc) {

		String msg;
		int accAge;
		boolean isAll =
				dao.isString(acc.getName()) &&
				dao.isString(acc.getPass()) &&
				dao.isString(acc.getSex()) &&
				dao.isString(acc.getMail()) &&
				dao.isString(acc.getPhone()) &&
				dao.isString(acc.getAge());

		if(!isAll) {
			msg = "全ての項目を入力してください";
		} else {
			if(!dao.isNum(acc.getAge())) {
				msg = "数字を入力してください";
			} else {
				accAge = Integer.parseInt(acc.getAge());
				try {
					Connection con = DriverManager.getConnection(JDBC , userDB , passDB);
					PreparedStatement ps;

					sql = "select name from account where name=? and pass=?";
					ps =  con.prepareStatement(sql);
					ps.setString(1, acc.getName());
					ps.setString(2, acc.getPass());
		        	ResultSet rset = ps.executeQuery();

		        	if(rset.next()){
		        		msg ="入力されたユーザーネームとパスワードは使用されています";
		        	} else {
						sql = "insert into account (name,pass,sex,mail,phone,age) values (? , ? , ? , ? , ? , ?)";
						ps=  con.prepareStatement(sql);
						ps.setString(1, acc.getName());
						ps.setString(2, acc.getPass());
						ps.setString(3, acc.getSex());
						ps.setString(4, acc.getMail());
						ps.setString(5, acc.getPhone());
						ps.setInt(6, accAge);

						ps.executeUpdate();
						msg = "ok";
		        	}
				} catch (SQLException e) {
					e.printStackTrace();
					msg = "入力内容がaaaaa";
				}
			}
		}
		return msg;
	}
}
