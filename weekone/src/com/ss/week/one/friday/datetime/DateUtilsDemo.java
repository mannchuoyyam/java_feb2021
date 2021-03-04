/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Date Utilities Demo
 *  Date: 2/26/21
 *  
 */
package com.ss.week.one.friday.datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author Mannchuoy Yam
 *
 */
public class DateUtilsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DateUtils dateUtils = new DateUtils();
		
		LocalDate date = LocalDate.now();
		ZonedDateTime dateTime = ZonedDateTime.now();
		
		// get previous Thursday from current date
		LocalDate previousThursday = dateUtils.getPreviousThursday(date);
		System.out.println("Current date " + date);
		System.out.printf("Previous Thursday: %s\n\n", previousThursday);
		
		// convert Instant to ZonedDateTime using atZone function
		Instant instantDate = Instant.from(dateTime);
		ZonedDateTime zonedDateTime = instantDate.atZone(ZoneId.of("Asia/Tokyo"));

		// convert ZonedDateTime to Instant using from function
		instantDate = Instant.from(zonedDateTime);
		
		System.out.println("Instant: " + instantDate);
		System.out.printf("ZonedDateTime: %s\n\n", zonedDateTime);
		

		dateUtils.displayLengthOfEachMonthIn(2021);
		
		dateUtils.listAllMondaysIn(2);
		
		LocalDate isFriday13 = LocalDate.of(2015, 4, 13);
		if(dateUtils.testFridayTheThirdteen(LocalDate.of(2015, 4, 13))) {
			System.out.println(isFriday13 + " is Friday the 13th");
		}else {
			System.out.println(isFriday13 + " is not Friday the 13th.");
		}
	}
}
