package model.users;
import java.io.Serializable;

public class SignUp implements Serializable{ //新規登録情報
	private String mail; //新規登録メールアドレス
	private String pass; //パスワード
	
	public SignUp() {}
	public SignUp(String mail, String pass) {
		this.mail = mail;
		this.pass = pass;
	}
	
	public String getMail() {
		return mail;
	}
	public String getPass() {
		return pass;
	}

}
