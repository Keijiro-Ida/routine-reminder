package test;

import java.time.LocalTime;
import java.util.List;

import DAO.GoalDAO;
import model.Goal;
import model.users.Users;

public class GoalDAOTest2 {

	public static void main(String[] args) {
		testFindAll();

	}
	public static void testFindAll() {
		GoalDAO dao = new GoalDAO();
		LocalTime now = LocalTime.now();
		Users users = new Users(1, "idatt1122@gmail.com", "11221118");
		List<Goal> goalList = dao.findAll(users);
		goalList.forEach(goal -> System.out.println(goal.getText()));
	}

}
