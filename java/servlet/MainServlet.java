
package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Goal;
import model.PostGoal;
import model.PostGoalLogic;
import model.remind.Remind;
import model.remind.SendMailLogic;
import model.users.Users;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet { //メイン画面
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text"); //入力テキストを獲得
		String time = request.getParameter("remindTime"); //リマインド時刻の獲得
		
		PostGoal postGoal = null;
		if(text.equals("") || time.equals("")) { //テキスト入力がない場合
			request.setAttribute("errorMsg", "テキストが入力されていません。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		} else { //テキスト入力ある場合
			LocalDate today = LocalDate.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			String datetime = dtf.format(today) + " " + time;
			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
			LocalDateTime remindLocalTime = LocalDateTime.parse(datetime,dtf2);
			Timestamp remindTime = Timestamp.valueOf(remindLocalTime);
			Timestamp goalTime = new Timestamp(System.currentTimeMillis());
			
			HttpSession session = request.getSession();
			Users users = (Users)session.getAttribute("users");
		
			postGoal = new PostGoal(users.getUsrId(), text, goalTime, remindTime);
			PostGoalLogic bo = new PostGoalLogic();
			Goal goal = bo.execute(postGoal);
				
			if(goal != null) { //目標の登録成功時
				//リマインド通知の設定
				Remind remind = new Remind(goal.getGoalId(), users.getMail(), text, remindTime); 
				SendMailLogic bo2 = new SendMailLogic(remind);
				bo2.execute();
					
				
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mainResult.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("errorMsg", "登録に失敗しました。"); //エラー時の画面
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
