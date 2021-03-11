/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.input;

import java.sql.Date;
import java.util.Scanner;

import com.mannchuoy.entity.Passenger;

/**
 * @author Mannchuoy Yam
 *
 */
public class PassengerUserInput extends BaseUserInput{
	
	public PassengerUserInput(Scanner scanner) {
		super(scanner);
	}
	
	public Passenger getPassenger() {
		
		if(scanner.hasNextLine()) {
			skipNewLine();
		}
		
		Passenger passenger = new Passenger();
		
		print("Enter passenger first name: ");
		String firstName = scanner.nextLine();
		print("Enter passenger last name: ");
		String lastName = scanner.nextLine();
		print("Enter passenger gender: ");
		String gender = scanner.nextLine();
		print("Enter passenger address: ");
		String address = scanner.nextLine();
		String input = null;
		while(input == null) {
			print("Enter passenger date of birth: ");
			input = scanner.nextLine();
			try {
				Date date = Date.valueOf(input);
				passenger.setDateOfBirth(date);
			}catch(IllegalArgumentException e) {
				input = null;
			}
		}
		
		passenger.setGivenName(firstName);
		passenger.setFamilyName(lastName);
		passenger.setGender(gender);
		passenger.setAddress(address);
		
		return passenger;
	}
	
	public Passenger getPassenger(Passenger passenger) {
		
		if(scanner.hasNextLine()) {
			skipNewLine();
		}
		
		Passenger newPassenger = new Passenger();
		if(!updatePassengerName(passenger, newPassenger)) {
			return null;
		}
		
		if(!updatePassengerBirthDay(passenger, newPassenger)) {
			return null;
		}
		
		if(!updatePassengerGender(passenger, newPassenger)) {
			return null;
		}
		
		if(!updatePassengerAddress(passenger, newPassenger)) {
			return null;
		}
		
		newPassenger.setId(passenger.getId());
		newPassenger.setBookingId(passenger.getBookingId());
		
		return newPassenger;
	}
	
	private boolean updatePassengerAddress(Passenger passenger, Passenger newPassenger) {
		String input = null;
		while (input == null) {
			print("Enter passenger address or N/A for no change: ");
			input = scanner.nextLine();
			if (input.toLowerCase().equals("quit")) {
				return false;
			} else if (input.toLowerCase().equals("n/a")) {
				newPassenger.setAddress(passenger.getAddress());
			}else {
				newPassenger.setAddress(input);
			}
		}
		
		return true;
	}
	
	private boolean updatePassengerGender(Passenger passenger, Passenger newPassenger) {
		
		String input = null;
		while (input == null) {
			print("Enter passenger gender or N/A for no change: ");
			input = scanner.nextLine();
			if (input.toLowerCase().equals("quit")) {
				return false;
			} else if (input.toLowerCase().equals("n/a")) {
				newPassenger.setGender(passenger.getGender());
			}else if(input.toLowerCase().equals("male") || input.toLowerCase().equals("female")){
				newPassenger.setGender(input);
			}else {
				println("input should be male/female");
				input = null;
			}
		}
		
		return true;
	}
	
	public boolean updatePassengerBirthDay(Passenger passenger, Passenger newPassenger) {
		
		String input = null;
		while (input == null) {
			print("Enter passenger date of birth or N/A for no change: ");
			input = scanner.nextLine();
			if (input.toLowerCase().equals("quit")) {
				return false;
			} else if (input.toLowerCase().equals("n/a")) {
				newPassenger.setDateOfBirth(passenger.getDateOfBirth());
			}else {
				try {
					Date date = Date.valueOf(input);
					newPassenger.setDateOfBirth(date);
				}catch(IllegalArgumentException e) {
					println("Date should be in the form of (yyyy-[m]m-[d]d)");
					input = null;
				}
			}
		}
		
		return true;
	}
	
	public boolean updatePassengerName(Passenger passenger, Passenger newPassenger) {
		print("Enter passenger first name or N/A for no change: ");
		String firstName = scanner.nextLine();
		
		if (firstName.toLowerCase().equals("quit")) {
			return false;
		} else if (firstName.toLowerCase().equals("n/a")) {
			newPassenger.setGivenName(passenger.getGivenName());
		}else {
			newPassenger.setGivenName(firstName);
		}
		
		print("Enter passenger last name or N/A for no change: ");
		String lastName = scanner.nextLine();
		
		if (lastName.toLowerCase().equals("quit")) {
			return false;
		} else if (lastName.toLowerCase().equals("n/a")) {
			newPassenger.setFamilyName(passenger.getFamilyName());
		}else {
			newPassenger.setGivenName(lastName);
		}
		
		return true;
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
