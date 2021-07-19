package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.users.Login;
import model.users.LoginLogic;
import model.users.Users;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet { //ログインの遷移
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mail = request.getParameter("mail"); //入力メールアドレスの獲得
		String pass = request.getParameter("pass"); //入力パスワードの獲得
		Login login = new Login(mail, pass);
		LoginLogic bo = new LoginLogic();
		Users users = bo.execute(login);
		
		if(users != null) { //ユーザー情報確認OK時はセッションスコープに格納
			HttpSession session = request.getSession();
			session.setAttribute("users", users);
		} 
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
		dispatcher.forward(request, response);
	}

}
