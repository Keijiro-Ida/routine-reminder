package servlet;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DeleteGoalLogic;
import model.Goal;
import model.remind.SendMailLogic;

/**
 * Servlet implementation class DeleteGoalServlet
 */
@WebServlet("/DeleteGoalServlet")
public class DeleteGoalServlet extends HttpServlet { //設定した目標の削除
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Goal goal = (Goal) session.getAttribute("goal");
		DeleteGoalLogic bo = new DeleteGoalLogic();
		int result = bo.execute(goal);
		if (result == 1) { //削除成功

			if (SendMailLogic.map.get(goal.getGoalId()) != null) { //リマインド通知のキャンセル
				SendMailLogic.map.get(goal.getGoalId()).cancel(true);
				SendMailLogic.map.remove(goal.getGoalId());
				SendMailLogic.map2.get(goal.getGoalId()).shutdown();
				try {
					SendMailLogic.map2.get(goal.getGoalId()).awaitTermination(1, TimeUnit.NANOSECONDS);
					SendMailLogic.map2.remove(goal.getGoalId());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			response.sendRedirect("/GetGoalListServlet");
		} else if (result == 0) { //削除失敗
			request.setAttribute("errorMsg", "更新に失敗しました。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		} else { //データベースエラー
			request.setAttribute("errorMsg", "システムエラーです。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}
}
