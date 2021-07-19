package model.users;
import java.io.Serializable;

public class Users implements Serializable{ //ユーザー情報
	private int usrId; //ユーザーID 
	private String mail;  //メールアドレス
	private String pass;  //パスワード
	
	public Users() {}
	public Users(int usrId, String mail, String pass) {
		this.usrId = usrId;
		this.mail = mail;
		this.pass = pass;
	}
	public int getUsrId() {
		return usrId;
	}
	public String getMail() {
		return mail;
	}
	public String getPass() {
		return pass;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

}
