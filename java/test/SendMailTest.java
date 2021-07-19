package test;

import java.sql.Timestamp;

import model.remind.Remind;
import model.remind.SendMailLogic;

public class SendMailTest {

	public static void main(String[] args) {
		Timestamp time = new Timestamp(System.currentTimeMillis() + 1000L);
		
		Remind remind = new Remind(1,"idatt1122@gmail.com", "Delay3分毎に届くか"
				+ "", time);
		SendMailLogic bo = new SendMailLogic(remind);
		bo.execute();
		SendMailLogic.map.get(1).cancel(true);
		SendMailLogic.map2.get(1).shutdown();
		System.out.println(SendMailLogic.map2.get(1).isShutdown());
	}

}
