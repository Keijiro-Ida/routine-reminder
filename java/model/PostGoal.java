package model;
import java.sql.Timestamp;

public class PostGoal { //目標の入力情報
	private int usrId; //ユーザーID
	private String text;  //入力テキスト
	private Timestamp goalTime; //登録時刻
	private Timestamp remindTime; //リマインド時刻設定
	
	public PostGoal(int usrId, String text, Timestamp goalTime, Timestamp remindTime) {
		this.usrId = usrId;
		this.text = text;
		this.goalTime = goalTime;
		this.remindTime = remindTime;
	}
	
	public int getUsrId() {
		return usrId;
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

}
