/**
 * 
 */
package com.mannchuoy.menu;

import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.mannchuoy.entity.Airport;
import com.mannchuoy.entity.Flight;
import com.mannchuoy.service.AdminService;

/**
 * @author Mannchuoy Yam
 *
 */
public class Menu {

	Scanner scanner = new Scanner(System.in);

	private void println(String message) {
		System.out.println(message);
	}

	private void print(String message) {
		System.out.print(message);
	}

	private void printMenu(String[] menus) {
		for (int i = 0; i < menus.length; ++i) {
			println((i + 1) + ")" + menus[i]);
		}
	}

	public Boolean showMainMenu() {
		println("Welcome to the Utopia Airline Management System. Which category of a user are you?");
		String[] menus = { "Enployee", "Administrator", "Traveler", "Exit" };

		Boolean appExit = Boolean.FALSE;

		int option = validateAndGetOption(menus);

		switch (option) {
		case 1:
			break;
		case 2:
			showAdmininstratorMainMenu();
			break;
		case 3:
			break;
		case 4:
			println("Have a nice day!");
			appExit = Boolean.TRUE;
			break;
		default:
			break;
		}

		return appExit;
	}

	private void showAdmininstratorMainMenu() {
		String[] adminMainMenus = { "Flights", "Seats", "Tickets and Passengers", "Airports", "Travelers", "Employees",
				"Over-ride Trip Cancellation for a ticket", "Quit to previous" };

		int option = 0;

		do {
			option = validateAndGetOption(adminMainMenus);

			switch (option) {
			case 1:
				showFlightMenus();
				break;
			case 2:
				break;
			case 3:

				break;
			case 4:
				showAirportMenus();
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			default:
				break;
			}

		} while (option != 8);
	}

	private void showFlightMenus() {
		String[] crudMenu = { "Add", "Update", "Delete", "Read", "Go to previous" };

		int option = 0;
		AdminService adminService = new AdminService();

		Flight flight = new Flight();
		Airport origin = new Airport();
		Airport destination = new Airport();

		origin.setId("LBG");
		origin.setCity("Long Beach");
		
		destination.setId("JFK");
		destination.setCity("New York");
		
		flight.setId(100);
		flight.setPlaneId(1);
		flight.setDepartureTime(LocalDateTime.of(2021, 03, 1, 10, 30, 0));
		flight.setReservedSeats(50);
		flight.setSeatPrice(100.0f);
		
		do {
			println("What would you like to do with flights?");
			option = validateAndGetOption(crudMenu);
			try {
				switch (option) {
				case 1:
					adminService.addFlight(origin, destination, flight);
					break;
				case 2:

					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;

				default:
					break;
				}
			} catch (SQLException e) {

			}
		} while (option != 5);
	}

	private void showAirportMenus() {
		String[] crudMenu = { "Add", "Update", "Delete", "Read", "Go to previous" };

		int option = 0;
		Airport airport = new Airport();
		airport.setId("sna");
		airport.setCity("Santa Ana");

		AdminService adminService = new AdminService();

		do {
			println("What would you like to do with Airports?");
			option = validateAndGetOption(crudMenu);

			try {
				switch (option) {
				case 1:
					adminService.addAirport(airport);
					break;
				case 2:
					adminService.updateAirport(airport);
					break;
				case 3:
					adminService.deleteAirport(airport);
					break;
				case 4:
					List<Airport> airports = adminService.listAirports();
					airports.stream().forEach(e -> {
						println("Code: " + e.getId() + " City: " + e.getCity());
					});
					break;
				case 5:
					break;
				default:
					break;
				}
			} catch (SQLException e) {

			}
		} while (option != 5);
	}

	private Integer validateAndGetOption(String[] menus) {

		printMenu(menus);

		String prompt = "Please choose one of the options (1 - " + menus.length + "): ";

		int option = 0;

		while (option <= 0 || option > menus.length) {
			print(prompt);
			try {
				option = scanner.nextInt();
			} catch (NoSuchElementException e) {
				if (scanner.hasNext()) {
					scanner.nextLine();
				}
				println("Your input is incorrect. Please try again!");
			}
			println("");
		}

		return option;
	}
}
