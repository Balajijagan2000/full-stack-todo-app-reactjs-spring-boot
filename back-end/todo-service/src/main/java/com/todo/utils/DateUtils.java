package com.todo.utils;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	public static String convertToDateString(String date) {
		
		//Setting up format for date
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		//Converting date string to Date Object
		LocalDate curDate = LocalDate.parse(date); 
		//Changing format of date using formatter
		String newDate = dateFormat.format(curDate);
		return newDate;
		
	}
}
