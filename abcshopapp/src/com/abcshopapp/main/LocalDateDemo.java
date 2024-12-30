package com.abcshopapp.main;

import java.time.LocalDate;
import java.time.Period;
import java.sql.Date;

public class LocalDateDemo {

	public static void main(String[] args) {

		LocalDate dob = LocalDate.of(2001, 3, 13);

		LocalDate today = LocalDate.now();

		System.out.println("Today's date : "+today);

		System.out.println("DOB : "+dob);

		String s = "2022-10-03";
		Date date = Date.valueOf(s);
		LocalDate date1 = date.toLocalDate();

		System.out.println("Before Conversion : "+date);
		System.out.println("Date : "+date1);

		//date manipulation
		LocalDate afterDays = today.plusDays(35);

		System.out.println("\nAfter 35 days, date is : "+afterDays);
		
		System.out.println("\nAfter 4 years : "+today.plusYears(4));
		
		System.out.println("\nAfter 25 weeks : "+today.plusWeeks(25));
		
		System.out.println("\nAfter 9 months : "+today.plusMonths(9));
		
		System.out.println("\nDay of month : "+today.getDayOfMonth());
		
		System.out.println("\nDay of year : "+today.getDayOfYear());
		
		System.out.println("\nValue of Month : "+today.getMonthValue());
		
		System.out.println("\nYear : "+today.getYear());
		
		System.out.println("\nDay of week : "+today.getDayOfWeek());
		
		System.out.println("\nLength of month : "+today.lengthOfMonth());
		
		System.out.println("\nLength of year : "+today.lengthOfYear());
		
		LocalDate myDob = LocalDate.of(2001, 03, 13);
		System.out.println("\nMy age : "+Period.between(myDob,LocalDate.now()).getYears());
		
	}

}
