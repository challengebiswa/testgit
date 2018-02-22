import java.util.Calendar;
import java.util.Date;


public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Date date= new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		System.out.println(month);
	}

}
