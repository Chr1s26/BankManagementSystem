package Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateConverter {
	
private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
	
	private static DateTimeFormatter formatterWithoutFraction = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	private static DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
	
	public static LocalDateTime toDateTimeObj(String dateString) {
		dateString = dateString.split("\\.")[0];
		try {
			LocalDateTime dateObj = LocalDateTime.parse(dateString,isoFormatter);
			  return dateObj;
		} catch (DateTimeParseException e1) {
			try {
			LocalDateTime dateObj = LocalDateTime.parse(dateString,formatterWithoutFraction);
			  return dateObj;}
			catch (DateTimeParseException e2) {
				try {
					 LocalDateTime dateObj = LocalDateTime.parse(dateString,formatter);
					 return dateObj;
				} catch (DateTimeParseException e3) {
					e3.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public static java.sql.Date toSqlDate(LocalDateTime dateObj){
		return java.sql.Date.valueOf(dateObj.toLocalDate());
	}
}
