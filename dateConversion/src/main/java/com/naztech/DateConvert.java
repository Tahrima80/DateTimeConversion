package com.naztech;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateConvert {

///******Date to Local Date******//
	///*******1*******//
	public static LocalDate fromDateToLocalDate(Date date) {
		
		LocalDate localDate = LocalDate.of(date.getYear()+1900, date.getMonth() + 1,
				date.getDate());
		return localDate;

	}

	///******Date to Local Time******//
	///*******2*******//
	public static LocalTime fromDateToLocalTime(Date date) {
		
		LocalTime localTime = LocalTime.of(date.getHours(), date.getMinutes(),
				date.getSeconds());

		return localTime;
	}
	///******Local Date to Date******//	
	///*******3*******//
	public static Date fromLocalDateToDate(LocalDate localDate) {
		
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		return date;
		
	}
	
	///******Calendar to LocalDate******//
	///*******4*******//
	
public static LocalDate fromCalendarToLocalDate(Calendar calendar) { 
		
		Instant instant = calendar.getTime().toInstant();
		LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate;

	}
	
	///******Date to ZonedDateTime******//
		///*******5*******//
	
	public static ZonedDateTime fromDateToZonedDateTime(Date date) {
		
		Calendar cal = Calendar.getInstance();

		cal.setTime(date);
		
		String zone = cal.getTimeZone().getID();

        ZoneId zoneId = ZoneId.of(zone);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND), cal.get(Calendar.MILLISECOND), zoneId);
       
        return zonedDateTime;
        
       	
	}
	
	///******Date to Month Day******//
		///*******6*******//
	
	public static MonthDay fromDateToMonthDay(Date date) {
	
        MonthDay monthDay = MonthDay.of(date.getMonth()+1, date.getDate());
        
        return monthDay;
		
	}
	
	///******Date to LocalDateTime******//
			///*******7*******//
	public static LocalDateTime fromDatetoLocalDateTime(Date date) {
		
		LocalDateTime localDateTime = LocalDateTime.of(date.getYear()+1900, date.getMonth()+1, date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds());
		return localDateTime;
		
	}
	///******Date to LocalDateTime******//
	          ///*******8*******//
	
	public static  ZoneOffset fromDateToZoneOffset(Date date) {
		
        
        ZoneOffset zonedOffset = ZoneOffset.ofHoursMinutesSeconds(date.getHours()-12, date.getMinutes(), date.getSeconds());

		return zonedOffset;
	}
	
	///******Date to OffsetDateTime******//
          ///*******9*******//
	
	public static OffsetDateTime fromDateToOffsetDateTime(Date date) {
		Calendar cal = Calendar.getInstance();

		cal.setTime(date);
		
		String zone = cal.getTimeZone().getID();

        ZoneId zoneId = ZoneId.of(zone);
        
        ZonedDateTime zonedDateTime = ZonedDateTime.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND), cal.get(Calendar.MILLISECOND), zoneId);
        
        ZoneOffset offset = zonedDateTime.getOffset();
         
        OffsetDateTime offsetDateTime= OffsetDateTime.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND), cal.get(Calendar.MILLISECOND), offset);

        return offsetDateTime;
		
	}
	
   

}
