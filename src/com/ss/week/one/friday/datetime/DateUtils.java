/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Date Utilities
 *  Date: 2/26/21
 *  
 */
package com.ss.week.one.friday.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Mannchuoy Yam
 *
 */
public class DateUtils {
	
	public LocalDate getPreviousThursday(LocalDate date) {
		return date.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));
	}
	
	public void displayLengthOfEachMonthIn(Integer year) {
		System.out.println("In year " + String.valueOf(year) + ":");
		
		for(Month m : Month.values()) {
			System.out.println(m.getDisplayName(TextStyle.FULL, Locale.US) + " has " + YearMonth.of(year, m).lengthOfMonth() + " days.");
		}
		
		System.out.println();
	}
	
	public void listAllMondaysIn(Integer month) {
		List<LocalDate> mondays = new ArrayList<>();
		
		// get current date and set to the given month
		LocalDate currentDate = LocalDate.now();
		LocalDate givenMonth = currentDate.withMonth(month);
		
		LocalDate firstMonday = givenMonth.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
		mondays.add(firstMonday);
		
		while(true) {
			firstMonday = firstMonday.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
			if(firstMonday.getMonthValue() == month) {
				mondays.add(firstMonday);
			}else {
				break;
			}
		}
		
		System.out.println("All Mondays in " + givenMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.US)+ ":");
		
		mondays.stream()
				.forEach(System.out::println);
		
		System.out.println();
	}
	
	public Boolean testFridayTheThirdteen(LocalDate date) {
		return date.getDayOfWeek().equals(DayOfWeek.FRIDAY) && date.getDayOfMonth() == 13;	
	}
}
