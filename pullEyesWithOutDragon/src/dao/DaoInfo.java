package dao;

public class DaoInfo {

	private String JDBC;
	private String user;
	private String pass;

	public DaoInfo() {
		this.JDBC = "jdbc:mysql://localhost:3306/pewd?characterEncoding=utf-8&serverTimezone=JST";
		this.user = "root";
		this.pass = "root";
	}

	public String getJDBC() { return JDBC; }
	public String getUser() { return user; }
	public String getPass() { return pass; }

	public boolean isString(String string) {
		if(string==null || string.length()<1) return false;
		else return true;
	}

	public boolean isNum(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
