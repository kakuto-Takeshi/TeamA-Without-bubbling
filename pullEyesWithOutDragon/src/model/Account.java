package model;

public class Account {

	private String id;
	private String name;
	private String pass;
	private String sex;
	private String mail;
	private String phone;
	private String age;
	private String msg;

	public Account() {}
	public Account(String name , String pass) {
		this.name = name;
		this.pass = pass;
		this.msg = "failed..!";
		this.msg = "※入力に誤りがあります※";
	}
	public Account(String name , String pass , String sex , String mail , String phone , String age) {
		this.name = name;
		this.pass = pass;
		this.sex = sex;
		this.mail = mail;
		this.phone = phone;
		this.age = age;
		this.msg = "入力内容が正しくありません";
	}

	public String getId() { return id; }
	public String getName() { return name; }
	public String getPass() { return pass; }
	public String getSex() { return sex; }
	public String getMail() { return mail; }
	public String getPhone() { return phone; }
	public String getAge() { return age; }
	public String getMsg() { return msg; }

	public void setId(String id) {this.id = id;}
	public void setName(String name) {this.name = name;}
	public void setPass(String pass) {this.pass = pass;}
	public void setSex(String sex) {this.sex = sex;}
	public void setMail(String mail) {this.mail = mail;}
	public void setPhone(String phone) {this.phone = phone;}
	public void setAge(String age) {this.age = age;}
	public void setMsg(String msg) { this.msg = msg; }

}
