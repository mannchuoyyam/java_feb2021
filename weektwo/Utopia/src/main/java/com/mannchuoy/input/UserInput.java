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

	// TODO: need input validation
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

	private float getSeatPrice() {
		float seatPrice = 0;
		boolean isCorrectInput = false;
		while (!isCorrectInput) {
			print("\nEnter seat price: ");
			try {
				seatPrice = scanner.nextFloat();
			}catch(NumberFormatException e) {
				String s = scanner.nextLine();
				print(s + " is not a number.");
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
			} catch (NumberFormatException e) {
				String s = scanner.nextLine();
				print(s + " is not a number.");
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
			} catch (NumberFormatException e) {
				String s = scanner.nextLine();
				print(s + " is not a number.");
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

		print("Enter plane id: ");
		int planeId = scanner.nextInt();

		return planeId;
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
				} catch (NumberFormatException ex) {
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

	// TODO: need input validation
	public Airport getAirport(String info) {
		String promptCode = info.isEmpty() ? "\nEnter airport code: " : "\nEnter " + info + " airport code: ";
		String promptCity = info.isEmpty() ? "\nEnter city: " : "\nEnter " + info + " city: ";

		print(promptCode);
		String code = scanner.next();

		skipNewLine();

		print(promptCity);
		String city = scanner.nextLine();

		return new Airport(code, city);
	}

	public Flight getFlightToBeDeleted() {
		Flight flight = new Flight();

		print("Enter flight number to be deleted: ");
		int flightId = scanner.nextInt();

		flight.setId(flightId);
		return flight;
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
}
