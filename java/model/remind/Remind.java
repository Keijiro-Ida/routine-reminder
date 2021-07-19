package model.remind;

import java.sql.Timestamp;

public class Remind { //リマインド通知の情報
	private int goalId; //目標ID
	private String text; //リマインドするテキスト
	private String mail; //メールアドレス
	private Timestamp remindTime; //リマインド時刻設定
	
	public Remind() {}
	public Remind(int goalId, String mail, String text, Timestamp remindTime) {
		this.goalId = goalId;
		this.mail = mail;
		this.text = text;
		this.remindTime = remindTime;
	}
	public int getGoalId() {
		return goalId;
	}
	public String getText() {
		return text;
	}
	public String getMail() {
		return mail;
	}
	public Timestamp getRemindTime() {
		return remindTime;
	}
}
