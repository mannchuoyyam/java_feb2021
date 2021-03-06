/**
 * 
 */
package com.mannchuoy.menu;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.mannchuoy.dao.AirportDao;
import com.mannchuoy.entity.Airport;

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
		println("What would you like to do with flights?");
		String[] crudMenu = { "Add", "Update", "Delete", "Read", "Go to previous" };

		int option = validateAndGetOption(crudMenu);

		switch (option) {
		case 1:
			break;
		case 2:

			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			showAdmininstratorMainMenu();
			break;

		default:
			break;
		}
	}

	private void showAirportMenus() {
		String[] crudMenu = { "Add", "Update", "Delete", "Read", "Go to previous" };

		int option = 0;
		do {
			println("What would you like to do with Airports?");
			option = validateAndGetOption(crudMenu);

			Airport airport = new Airport();
			airport.setId("sna");
			airport.setCity("Santa Ana");

			AirportDao airportDao = new AirportDao();

			switch (option) {
			case 1:
				try {
					airportDao.addAirport(airport);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:

				break;
			case 3:
				break;
			case 4:
				try {
					List<Airport> airports = airportDao.listAirport();
					airports.stream().forEach(e -> System.out.println("id: " + e.getId() + " City: " + e.getCity()));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				break;

			default:
				break;
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
