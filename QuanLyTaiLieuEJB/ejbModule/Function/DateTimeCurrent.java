package Function;

import java.text.SimpleDateFormat;

public class DateTimeCurrent {
	java.util.Date date = new java.util.Date();
	long t = date.getTime();
	
	public String getDay() {
		java.sql.Date sqlDate = new java.sql.Date(t);
		SimpleDateFormat fmt_date = new SimpleDateFormat("dd-MM-yyyy");
		String ngay = fmt_date.format(sqlDate);
		return ngay;
	}
	
	public String getTime() {
		java.sql.Time sqlTime = new java.sql.Time(t);
		String time = sqlTime.toString();
		return time;
	}
}
