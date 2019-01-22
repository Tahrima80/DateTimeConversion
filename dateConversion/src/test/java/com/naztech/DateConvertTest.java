package com.naztech;

import java.awt.Label;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

public class DateConvertTest extends TestCase {


	public void testFromDatetoLocalDate() {
		Date date = new Date();
		
		assertEquals(LocalDate.now(), DateConvert.fromDateToLocalDate(date));
		
	}
	
	
	public void testFromTimetoLocalTime() {
		Date input = new Date();
		input.setHours(15);
		input.setMinutes(17);
		input.setSeconds(41);
		assertEquals(LocalTime.of(15, 17, 41), DateConvert.fromDateToLocalTime(input));
	}
	
	public void testFromLocalDateToDate() {
		
		Date input = new Date();
		input.setDate(16);
		input.setYear(119);
		input.setMonth(0);
		input.setHours(00);
		input.setMinutes(00);
		input.setSeconds(00);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		
		
	     assertEquals(dateFormat.format(input), dateFormat.format(DateConvert.fromLocalDateToDate(LocalDate.of(2019, Month.JANUARY, 16))));
	}
	
	public void testFromCalendarToLocalDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2019, 0, 16, 06, 19, 44);
		
		LocalDate localDate = LocalDate.of(2019, 1, 16);
		//LocalDate localDate = dt.calender_to_localdate(c);
		//String formattedString5 = lt3.format(formatter);
		//LocalDate lt4 = LocalDate.of(2019, Month.JANUARY, 17);
		//String formattedString6 = lt4.format(formatter);
		
		assertEquals(localDate, DateConvert.fromCalendarToLocalDate(calendar));
	}
	
	public void testFromDateToMonthDay() {
		Date input = new Date(2019, 0, 16);
		MonthDay monthDay = MonthDay.of(01, 16);
		
		assertEquals(monthDay, DateConvert.fromDateToMonthDay(input));
	}
	
	public void testFromDatetoLocalDateTime() {
		Date input = new Date(119, 0, 16, 6,19,44);
		LocalDateTime localDateTime = LocalDateTime.of(2019,1,16, 6,19,44);
		
		assertEquals(localDateTime, DateConvert.fromDatetoLocalDateTime(input));
		
	}
	
	public void testFromDateToZonedDateTime() {
		Date input = new Date(119, 0, 16, 6, 19, 44);
		String zone = "Asia/Dhaka";

        ZoneId zoneId = ZoneId.of(zone);
        
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2019, 1, 16, 6, 19, 44, 00, zoneId);
        assertEquals(zonedDateTime, DateConvert.fromDateToZonedDateTime(input));
        
	}
	
	public void testFromDateToZoneOffset() {
		
		Date input = new Date(119, 0, 16, 18,19,44);
		ZoneOffset zonedOffset = ZoneOffset.ofHoursMinutesSeconds(18-12, 19,44);
		assertEquals(zonedOffset,DateConvert.fromDateToZoneOffset(input));
		
	}
	
	public void testFromDateToOffsetDateTime() {
		Date input = new Date(119, 0, 16, 6, 19, 44);
		String zone = "Asia/Dhaka";

        ZoneId zoneId = ZoneId.of(zone);
        
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2019, 1, 16, 6, 19, 44, 00, zoneId);
        
        ZoneOffset offset = zonedDateTime.getOffset();
        
        OffsetDateTime offsetDateTime= OffsetDateTime.of(2019, 1, 16, 6, 19, 44, 00, offset);

        assertEquals(offsetDateTime,DateConvert.fromDateToOffsetDateTime(input));
	}

	
}
