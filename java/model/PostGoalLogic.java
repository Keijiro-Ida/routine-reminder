package model;
import DAO.GoalDAO;
public class PostGoalLogic {
	public  Goal execute(PostGoal postGoal) { //目標入力からGoal IDを生成し、Goalインスタンスを作成
		GoalDAO dao = new GoalDAO();
		Goal goal =  dao.goalCreate(postGoal);
		if(goal != null) { //データベース登録成功時
			
			return goal;
		}else { //登録失敗時
			return null;
		}
	}

}
