package test;
import DAO.UsersDAO;
import model.users.SignUp;;

public class UsersDAOTest2 {
	public static void main(String[] args) {
		testSignUpUsers1();
		testSignUpUsers2();
	}
	
	public static void testSignUpUsers1() {
		SignUp signUp = new SignUp("idatt1122@yahoo.co.jp", "11221118");
		UsersDAO dao = new UsersDAO();
		int result = dao.createUsers(signUp);
		if(result == 1) {
			System.out.println("testSignIn1:成功");
		}else {
			System.out.println("testSignIn2:失敗");
		}
	}
	
	public static void testSignUpUsers2() {

		SignUp signIn = new SignUp("idatt1122@gmail.com", "11221118");
		UsersDAO dao = new UsersDAO();
		int result = dao.createUsers(signIn);
		if(result != 1) {
			System.out.println("testSignIn1:成功");
		}else {
			System.out.println("testSignIn2:失敗");
		}
	}
}
