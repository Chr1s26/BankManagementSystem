package Util;

import java.util.Date;

import javax.swing.JSpinner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.jdatepicker.impl.JDatePanelImpl;

public class DateUtil {
	
	public static LocalDateTime getSelectedDate(JDatePanelImpl datePanel, JSpinner timeSpinner) {
	    Date selectedDate = (Date) datePanel.getModel().getValue();
	    Date selectedTime = (Date) timeSpinner.getValue();

	    if (selectedDate == null || selectedTime == null) {
	        return null;
	    }

	    LocalDate localDate = ((java.sql.Date) selectedDate).toLocalDate();
	    LocalDateTime localDateTime = LocalDateTime.of(localDate, 
	            LocalDateTime.ofInstant(selectedTime.toInstant(), ZoneId.systemDefault()).toLocalTime());
	    
	    return localDateTime;
	}
}
