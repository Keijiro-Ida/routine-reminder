package test;

import model.users.Login;
import model.users.LoginLogic;
import model.users.Users;

public class LoginLogicTest {
	public static void main(String[] args) {
		testExecute1();
		testExecute2();
	}
	public static void testExecute1() {
		Login login = new Login("keijiro", "11223344");
		LoginLogic bo = new LoginLogic();
		Users users = bo.execute(login);
		
		if(users != null &&
				users.getUsrId() == 6 &&
				users.getMail().equals("keijiro") &&
				users.getPass().equals("11223344")) {
			System.out.println("testExecute1:成功");
		} else {
			System.out.println("testExecute1:失敗");
		}
	}
	public static void testExecute2() {
		Login login = new Login("kkeijiro","11223344");
		LoginLogic bo = new LoginLogic();
		Users users = bo.execute(login);
		
		if(users == null) {
			System.out.println("testExecute2:成功");
		} else {
			System.out.println("testExecute2:失敗");
		}
	}

}
