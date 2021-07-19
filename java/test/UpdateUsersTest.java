package test;

import java.time.LocalTime;

import model.users.UpdateUsersLogic;
import model.users.Users;

public class UpdateUsersTest {

	public static void main(String[] args) {
		testExecute1();
		testExecute2();

	}
	public static void testExecute1() {
		LocalTime now = LocalTime.now();
		Users users = new Users(1,"idatt1122@gmail.com", "11221118");
		UpdateUsersLogic bo = new UpdateUsersLogic();
		int result = bo.execute(users);
		
		if(result == 1) {
			System.out.println("test1成功");
		} else {
			System.out.println("test1失敗");
		}
	}
	public static void testExecute2() {
		LocalTime now = LocalTime.now();
		Users users = new Users(3,"idatt1122@gmail.com", "11221117");
		UpdateUsersLogic bo = new UpdateUsersLogic();
		int result = bo.execute(users);
		if( result == 1) {
			System.out.println("test2成功");
		} else {
			System.out.println("test2失敗");
		}
	}

}