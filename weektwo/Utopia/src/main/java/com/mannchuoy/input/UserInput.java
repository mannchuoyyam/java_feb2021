/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.input;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.mannchuoy.dao.AirplaneDao;
import com.mannchuoy.dao.DBConnection;
import com.mannchuoy.entity.Airplane;
import com.mannchuoy.entity.Airport;
import com.mannchuoy.entity.Flight;

/**
 * @author Mannchuoy Yam
 *
 */
public class UserInput {

	Scanner scanner;

	public UserInput(Scanner scanner) {
		this.scanner = scanner;
	}

	public Flight getFlight() throws SQLException {
		int flightId = getFlightId();
		int planeId = getPlaneId();
		LocalDate date = getDate();
		LocalTime time = getTime();
		int reservedSeat = getReservedSeat();
		float seatPrice = getSeatPrice();
		LocalDateTime departureDateTime = LocalDateTime.of(date, time);

		return new Flight(flightId, planeId, departureDateTime, reservedSeat, seatPrice);
	}

	public int getFlightUpdateOption(int optionStartAt, int optionEndAt) {
		int option = 0;
		while (option == 0) {
			print("Select a flight to update (" + optionStartAt + " - " + optionEndAt + "): ");
			try {
				option = scanner.nextInt();
				if (option < optionStartAt || option > optionEndAt) {
					option = 0;
					println("Please choose the from the options above");
				}
			} catch (NoSuchElementException e) {
				String s = scanner.nextLine();
				println(s + " is a bad input");
			}
		}
		return option;
	}

	public boolean updateFlight(Airport origin, Airport destination, Flight flight) {
		boolean isUpdated = true;

		println("\nYou have chosen to update the Flight with Flight Id: " + flight.getId() + " and Flight Origin: "
				+ origin + " and Flight Destination: " + destination);
		println("Enter 'quit' at any prompt to cancel operation");

		if (!updateAirport(origin, "Origin")) {
			return false;
		}

		if (!updateAirport(destination, "Destination")) {
			return false;
		}

		if (!updateFlightDateTime(flight)) {
			return false;
		}

		return isUpdated;
	}

	private boolean updateFlightDateTime(Flight flight) {
		print("\nPlease enter new Departure Date or enter N/A for no change: ");

		LocalDate date = null;
		LocalTime time = null;

		String input = scanner.nextLine();
		if (input.equals("quit")) {
			return false;
		} else if (!input.toLowerCase().equals("n/a")) {
			while (date == null) {
				try {
					date = LocalDate.parse(input);
				} catch (DateTimeParseException e) {
					print("Please enter new Departure time (yyyy-mm-dd): ");
					input = scanner.nextLine();
				}
			}
		} else {
			date = flight.getDepartureTime().toLocalDate();
		}

		print("\nPlease enter new Departure time or enter N/A for no change: ");

		input = scanner.nextLine();
		if (input.equals("quit")) {
			return false;
		} else if (!input.toLowerCase().equals("n/a")) {
			while (date == null) {
				try {
					date = LocalDate.parse(input);
				} catch (DateTimeParseException e) {
					print("Please enter new Departure time (hh-mm-ss): ");
					input = scanner.nextLine();
				}
			}
		} else {
			time = flight.getDepartureTime().toLocalTime();
		}

		if (date != null && time != null) {
			flight.setDepartureTime(LocalDateTime.of(date, time));
		}
		return true;
	}

	private boolean updateAirport(Airport origin, String location) {
		print("\nPlease enter new " + location + " Airport and City or enter N/A for no change: ");

		skipNewLine();
		String input = scanner.nextLine();
		if (input.toLowerCase().equals("quit")) {
			return false;
		} else if (!input.toLowerCase().equals("n/a")) {
			int codeLength = 3;
			String code = input.substring(0, codeLength);
			String city = input.substring(codeLength);
			origin.setId(code);
			origin.setCity(city);
		}
		return true;
	}

	private float getSeatPrice() {
		float seatPrice = 0;
		boolean isCorrectInput = false;
		while (!isCorrectInput) {
			print("\nEnter seat price: ");
			try {
				seatPrice = scanner.nextFloat();
				isCorrectInput = true;
			} catch (NoSuchElementException e) {
				flushBadInput();
			}
		}
		return seatPrice;
	}

	private int getReservedSeat() {
		int reservedSeat = 0;
		boolean isCorrectInput = false;
		while (!isCorrectInput) {
			print("\nEnter reserved seats: ");
			try {
				reservedSeat = scanner.nextInt();
				isCorrectInput = true;
			} catch (NoSuchElementException e) {
				flushBadInput();
			}
		}
		return reservedSeat;
	}

	private int getFlightId() {
		int id = -1;

		while (id == -1) {
			print("Enter flight id: ");
			try {
				id = scanner.nextInt();
			} catch (NoSuchElementException e) {
				flushBadInput();
			}
		}
		return id;
	}

	private int getPlaneId() throws SQLException {
		println("\nChoose one of the plane id below:");

		List<Airplane> airplanes = getAirplanes();
		int index = 1;
		for (Airplane airplane : airplanes) {
			println(index + ") Plane Id: " + airplane.getId());
			index++;
		}
		
		int selectedNumber = 0;
		boolean isCorrectInput = false;
		
		while(!isCorrectInput) {
			print("Select number to choose a plane id: ");
			try {
				selectedNumber = scanner.nextInt();
				isCorrectInput = true;
			}catch(NoSuchElementException e){
				flushBadInput();
			}
		}
		int selectedIndex = selectedNumber - 1;
		
		return airplanes.get(selectedIndex).getId();
	}

	public List<Airplane> getAirplanes() throws SQLException {
		Connection connection = DBConnection.getConnection(Boolean.TRUE);
		AirplaneDao airplaneDao = new AirplaneDao(connection);

		return airplaneDao.listAirplane();
	}

	private LocalDate getDate() {
		LocalDate date = null;
		println("\nList of Departure Dates");
		LocalDate currentDate = LocalDate.now();
		int nextTenDays = 10;
		for (int i = 1; i <= nextTenDays; ++i) {
			println(i + ") " + currentDate.plusDays(i).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		}

		skipNewLine();

		do {
			print("Select one or enter a new date (yyyy-mm-dd): ");
			String input = scanner.nextLine();

			// check if a user enter a new date or choose from the list
			try {
				date = LocalDate.parse(input);
			} catch (DateTimeParseException e) {
				try {
					int days = Integer.parseInt(input);
					if (0 < days && days <= nextTenDays) {
						date = currentDate.plusDays(days);
					}
				} catch (NoSuchElementException ex) {
					println("Choose or enter the correct date format");
				}
			}
		} while (date == null);

		println("Your selected date is : " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));

		return date;
	}

	private LocalTime getTime() {
		LocalTime time = null;
		println("\nList of Departure Time");
		LocalTime currentTime = LocalTime.of(12, 0, 0);
		int nextTenHours = 10;
		for (int i = 1; i <= nextTenHours; ++i) {
			println(i + ") " + currentTime.plusHours(i).format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
		}

		do {
			print("Select one or enter a new time (hh-mm-ss): ");
			String input = scanner.nextLine();

			// check if a user enter a new date or choose from the list
			try {
				time = LocalTime.parse(input);
			} catch (DateTimeParseException e) {
				try {
					int hours = Integer.parseInt(input);
					if (0 < hours && hours <= nextTenHours) {
						time = currentTime.plusHours(hours);
					}
				} catch (NumberFormatException ex) {
					println("Choose or enter the correct time format");
				}
			}
		} while (time == null);

		println("Your selected time is : " + time.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));

		return time;
	}

	public Airport getAirport(String info) {
		String promptCode = info.isEmpty() ? "Enter airport code: " : "\nEnter " + info + " airport code: ";
		String promptCity = info.isEmpty() ? "Enter city: " : "\nEnter " + info + " city: ";
		
		String code;
		int codeLengthRestriction = 3;
		
		while(true) {
			print(promptCode);
			code = scanner.nextLine();
			if(code.length() != codeLengthRestriction) {
				print("Enter a code string with length of 3.");
			}else {
				break;
			}
		}
		
		print(promptCity);
		String city = scanner.nextLine();

		return new Airport(code, city);
	}

	public String getAirportCity(String prompt) {
		skipNewLine();
		String city = "";
		while(city.isBlank()) {
			print(prompt);
			city = scanner.nextLine();
		}
		
		return city;
	}
	
	public Flight getFlightById() {
		Flight flight = new Flight();
		int flightId = 0;
		boolean isCorrectInput = false;
		while (!isCorrectInput) {
			try {
				print("Enter flight id: ");
				flightId = scanner.nextInt();
				isCorrectInput = true;
			} catch (NoSuchElementException e) {
				flushBadInput();
			}
		}
		flight.setId(flightId);
		return flight;
	}

	
	public int getAirportUpdateOption(int optionStartAt, int optionEndAt) {
		String prompt = "Select a flight to update (" + optionStartAt + " - " + optionEndAt + "): ";
		return getUpdateOption(optionStartAt, optionEndAt, prompt);
	}
	
	private int getUpdateOption(int optionStartAt, int optionEndAt, String prompt) {
		int option = 0;
		while (option == 0) {
			print(prompt);
			try {
				option = scanner.nextInt();
				if (option < optionStartAt || option > optionEndAt) {
					option = 0;
					println("Please choose the from the options above");
				}
			} catch (NoSuchElementException e) {
				flushBadInput();
			}
		}
		return option;
	}
	private void skipNewLine() {
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	}

	private void println(String message) {
		System.out.println(message);
	}

	private void print(String message) {
		System.out.print(message);
	}
	
	private void flushBadInput() {
		String s = scanner.nextLine();
		print(s + " is not a good input.");
	}
}
