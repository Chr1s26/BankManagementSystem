package Util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date getSelectedDate(String dateString) {
		java.sql.Date sqlDate = null;
		try {
			java.util.Date utilDate= sdf.parse(dateString);
			sqlDate = new java.sql.Date(utilDate.getTime());
		}catch(ParseException e) {
			e.printStackTrace();
		}
		return sqlDate;
	}
}
