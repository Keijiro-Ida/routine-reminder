package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import model.Goal;
import model.PostGoal;
import model.users.Users;

public class GoalDAO {
	ResourceBundle bundle = ResourceBundle.getBundle("properties.database");
	//データベースの情報を取得

	public Goal goalCreate(PostGoal postGoal) {
		Goal goal = null;

		try (Connection conn = DriverManager.getConnection(
				bundle.getString("JDBC_URL_MYSQL"),
				bundle.getString("DB_USER2"),
				bundle.getString("DB_PASS2"))) {

			String sql = "INSERT INTO GOAL(USRID,TEXT,GOALTIME,REMINDTIME) VALUES(?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, postGoal.getUsrId());
			pstmt.setString(2, postGoal.getText());
			pstmt.setTimestamp(3, postGoal.getGoalTime());
			pstmt.setTimestamp(4, postGoal.getRemindTime());

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int goalId = rs.getInt(1);

				goal = new Goal(postGoal.getUsrId(), goalId, postGoal.getText(), postGoal.getGoalTime(),
						postGoal.getRemindTime());
				return goal;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return goal;
	}

	public List<Goal> findAll() { //全てのGoalを取得
		List<Goal> goalList = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(
				bundle.getString("JDBC_URL_MYSQL"),
				bundle.getString("DB_USER2"),
				bundle.getString("DB_PASS2"))) {

			String sql = "SELECT * FROM GOAL";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int usrId = rs.getInt("USRID");
				int goalId = rs.getInt("GOALID");
				String text = rs.getString("TEXT");
				Timestamp goalTime = rs.getTimestamp("GOALTIME");
				Timestamp remindTime = rs.getTimestamp("REMINDTIME");

				Goal goal = new Goal(usrId, goalId, text, goalTime, remindTime);
				goalList.add(goal);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return goalList;
	}

	public List<Goal> findAll(Users users) {
		List<Goal> goalList = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(
				bundle.getString("JDBC_URL_MYSQL"),
				bundle.getString("DB_USER2"),
				bundle.getString("DB_PASS2"))) {

			String sql = "SELECT * FROM GOAL WHERE USRID=? ORDER BY GOALTIME DESC";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, users.getUsrId());
			ResultSet rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				int usrId = rs.getInt("USRID");
				int goalId = rs.getInt("GOALID");
				String text = rs.getString("TEXT");
				Timestamp goalTime = rs.getTimestamp("GOALTIME");
				Timestamp remindTime = rs.getTimestamp("REMINDTIME");

				Goal goal = new Goal(usrId, goalId, text, goalTime, remindTime);
				goalList.add(goal);
				i++;
				if (i == 15)
					break; //目標は15個まで保持

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return goalList;
	}

	public int deleteGoal(Goal goal) {
		int result = 0;
		try (Connection conn = DriverManager.getConnection(
				bundle.getString("JDBC_URL_MYSQL"),
				bundle.getString("DB_USER2"),
				bundle.getString("DB_PASS2"))) {

			String sql = "DELETE FROM GOAL WHERE GOALID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goal.getGoalId());
			result = pstmt.executeUpdate();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int updateGoal(Goal goal) {
		int result = 0;
		try (Connection conn = DriverManager.getConnection(
				bundle.getString("JDBC_URL_MYSQL"),
				bundle.getString("DB_USER2"),
				bundle.getString("DB_PASS2"))) {

			String sql = "UPDATE GOAL SET TEXT = ?, REMINDTIME = ? WHERE GOALID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goal.getText());
			pstmt.setTimestamp(2, goal.getRemindTime());
			pstmt.setInt(3, goal.getGoalId());

			result = pstmt.executeUpdate();
			return result; //1が登録成功、0が失敗

		} catch (SQLException e) {
			e.printStackTrace();
			return -1; //-1でデータベースのエラー
		}
	}
}
