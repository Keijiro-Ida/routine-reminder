package model;
import java.io.Serializable;
import java.sql.Timestamp;

public class Goal implements Serializable { //目標
	private int usrId; //ユーザーID
	private int goalId; //目標ID
	private String text; //テキスト
	private Timestamp goalTime; //登録時刻
	private Timestamp remindTime; //リマインド時刻設定
	
	public Goal() {}
	public Goal(int usrId, int goalId, String text, 
						Timestamp goalTime, Timestamp remindTime) {
		this.usrId = usrId;
		this.goalId = goalId;
		this.text = text;
		this.goalTime = goalTime;
		this.remindTime = remindTime;
	}
	
	public int getUsrId() {
		return usrId;
	}
	public int getGoalId() {
		return goalId;
	}
	public String getText() {
		return text;
	}
	public Timestamp getGoalTime() {
		return goalTime;
	}
	public Timestamp getRemindTime() {
		return remindTime;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	public void setRemindTime(Timestamp remindTime) {
		this.remindTime = remindTime;
	}
}
