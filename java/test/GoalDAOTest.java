package test;
import java.sql.Timestamp;

import DAO.GoalDAO;
import model.Goal;
import model.PostGoal;

public class GoalDAOTest {
	public static void main(String[] args) {
		testGoalCreate1();
		testGoalCreate2();
	}
	public static void testGoalCreate1() {
		Timestamp current = new Timestamp(System.currentTimeMillis());
		PostGoal postGoal = new PostGoal(1, "aaa", current ,current);
		GoalDAO dao = new GoalDAO();
		Goal result = dao.goalCreate(postGoal);
		
		if(result != null) {
			System.out.println(result.getGoalId());
		} else {
			System.out.println("testGoalCreate1失敗");
		}
		
	}
	public static void testGoalCreate2() {
		Timestamp current = new Timestamp(System.currentTimeMillis());
		PostGoal postGoal = new PostGoal(100, "",current , current);
		GoalDAO dao = new GoalDAO();
		Goal result = dao.goalCreate(postGoal);
		
		if(result == null) {
			System.out.println("testGoalCreat2成功");
		} else {
			System.out.println("testGoalCreate2失敗");
		}
		
	}
}
