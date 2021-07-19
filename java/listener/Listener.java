package listener;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import DAO.GoalDAO;
import DAO.UsersDAO;
import model.Goal;
import model.remind.Remind;
import model.remind.SendMailLogic;
import model.users.Users;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
@WebListener
public class Listener implements ServletContextListener {

	/**
	 * Default constructor. 
	 */
	public Listener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//データベースに入っている全てのGoalを停止
		GoalDAO dao = new GoalDAO();
		List<Goal> list = dao.findAll();
		for (Goal goal : list) {
			if (SendMailLogic.map.get(goal.getGoalId()) != null) { //リマインド通知のキャンセル
				SendMailLogic.map.get(goal.getGoalId()).cancel(true);
				System.out.println(goal.getGoalId() + "スレッド削除");
				SendMailLogic.map.remove(goal.getGoalId());
				SendMailLogic.map2.get(goal.getGoalId()).shutdown();
				try {
					SendMailLogic.map2.get(goal.getGoalId()).awaitTermination(1, TimeUnit.NANOSECONDS);
					SendMailLogic.map2.remove(goal.getGoalId());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//データベースの全てのGoalのスレッドを始動
		GoalDAO dao = new GoalDAO();
		List<Goal> list = dao.findAll();
		for (Goal goal : list) {
			UsersDAO dao2 = new UsersDAO();
			Users users = dao2.findByUsrId(goal.getUsrId());
			Remind remind = new Remind(goal.getGoalId(), users.getMail(), goal.getText(), goal.getRemindTime());
			System.out.println(remind.getGoalId() + "スレッド開始");
			SendMailLogic dao3 = new SendMailLogic(remind);
			dao3.execute();
		}
	}
}
