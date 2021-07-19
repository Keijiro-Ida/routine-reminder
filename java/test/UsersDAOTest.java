package test;
import DAO.UsersDAO;
import model.users.Login;
import model.users.Users;

public class UsersDAOTest {
	public static void main(String[] args) {
		testFindByLogin1();
		testFindByLogin2();
	}
	
	public static void testFindByLogin1() {
		Login login = new Login("idatt1122@gmail.com", "11181117");
		UsersDAO dao = new UsersDAO();
		Users result = dao.findByLogin(login);
		if(result != null &&
				result.getUsrId() == 1 &&
				result.getMail().equals("idatt1122@gmail.com") &&
				result.getPass().equals("11181117")) {
			System.out.println("testFindByLogin1:成功しました");

		}else {
			System.out.println("testFindByLogin1:失敗しました");
		}
	}
	public static void testFindByLogin2() {
		Login login = new Login("idatt1122@gmail.com", "idatt343");
		UsersDAO dao = new UsersDAO();
		Users result = dao.findByLogin(login);
		if(result == null) {
			System.out.println("testFindByLogin2:成功しました");
		} else {
			System.out.println("testFindByLogin2:失敗しました");
		}
	}
}
