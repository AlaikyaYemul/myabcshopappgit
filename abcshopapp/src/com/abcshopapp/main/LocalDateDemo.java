package com.abcshopapp.main;

import java.time.LocalDate;
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
		

	}

}
