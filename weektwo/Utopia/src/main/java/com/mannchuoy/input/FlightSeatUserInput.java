/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.input;

import java.util.Scanner;

/**
 * @author Mannchuoy Yam
 *
 */
public class FlightSeatUserInput extends BaseUserInput{
	
	public FlightSeatUserInput(Scanner scanner) {
		super(scanner);
	}
	
	public int getSeatNumberForClass(String seatClass) {		
		String prompt = "Enter number of " + seatClass + " class seats: ";
		
		return validateAndGetInteger(prompt);
	}
	
	public int getSeatNumberForClassToBeUpdated(String seatClass, int currentNumberOfSeats) {
		String prompt = "Enter number of " + seatClass + " class seats: ";
		println("Existing number of " + seatClass + " class seats: " + currentNumberOfSeats);
				
		return validateAndGetInteger(prompt);
	}
}
