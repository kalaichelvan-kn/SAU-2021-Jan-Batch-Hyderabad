package com.accolite.au.datetime;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateTimeExample {

	public static void main(String[] args) {
		DateTimeExample dateTimeExample = new DateTimeExample();
//		dateTimeExample.dateTime();
//		dateTimeExample.parsingDates();
		dateTimeExample.utilities();
	}

	void dateTime() {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("Now: " + ldt);
		
		LocalDateTime ldt2 = LocalDateTime.of(2021, 1, 12, 21, 30);
		System.out.println("LocalDateTime of(2021, 1, 12, 21, 30): " + ldt2);
		
		// ZonedDateTime
		ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of("America/Los_Angeles"));
		System.out.println("Los Angeles time: " + zdt);
		
		// older Date API to new one
		Date date = new Date();
		LocalDateTime ldt3 = LocalDateTime.ofInstant(date.toInstant(), ZoneId.of("Asia/Kolkata"));
		System.out.println("Old Date to LocalDateTime: " + ldt3);
	}
	
	void parsingDates() {
		LocalDate ld = LocalDate.parse("01/18/2021", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		System.out.println(ld);
	}
	

	private void utilities() {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("now + 2 days: " + ldt.plus(Period.ofDays(2)));
		
		LocalDateTime ldt2 = LocalDateTime.of(2021, 1, 10, 21, 30);
		System.out.println("is date after: 2021, 1, 10, 21, 30: " + ldt.isAfter(ldt2));
		
		LocalDate ld = LocalDate.parse("01/18/2020", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		System.out.println("Is leap year: " + ld.isLeapYear());
		
		LocalDate ld2 = LocalDate.now();
		
		// diff between dates
		System.out.println(Period.between(ld, ld2).getDays());
		System.out.println(ChronoUnit.MONTHS.between(ld, ld2));
		System.out.println(Duration.between(ldt, ldt2).getSeconds());

	}
}
