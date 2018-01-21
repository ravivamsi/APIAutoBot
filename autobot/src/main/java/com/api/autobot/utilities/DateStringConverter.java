/**
 * 
 */
package com.api.autobot.utilities;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author vamsiravi
 *
 */
public class DateStringConverter {

	public static String dateStringConverter(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		 LocalDateTime now = LocalDateTime.now();
		 System.out.println(dtf.format(now).toString());
		 return dtf.format(now).toString();
	}
	
	public static String getTimeStamp(){
		DateFormat DF=DateFormat.getDateTimeInstance();
		Date dte=new Date();
		String DateValue=DF.format(dte);
		DateValue=DateValue.replaceAll(":", "_");
		DateValue=DateValue.replaceAll(",", "");
		return DateValue;
	}
	


}
