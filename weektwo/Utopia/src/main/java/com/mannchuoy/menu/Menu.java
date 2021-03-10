/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.menu;

import java.util.Scanner;

/**
 * @author Mannchuoy Yam
 *
 */
public class Menu extends BaseMenu {
	FlightMenu flightMenu;
	AirportMenu airportMenu;
	FlightSeatMenu flightSeatMenu;
	
	public Menu(Scanner scanner) {
		super(scanner);
		flightMenu = new FlightMenu(scanner);
		airportMenu = new AirportMenu(scanner);
		flightSeatMenu = new FlightSeatMenu(scanner);
	}

	public Boolean showMainMenu() {
		println("Welcome to the Utopia Airline Management System. Which category of a user are you?");
		String[] menus = { "Employee", "Administrator", "Traveler", "Exit" };

		Boolean appExit = Boolean.FALSE;
		int option = 0;
	
		option = validateAndGetOption(menus);
		
		switch (option) {
		case EMPLOYEE_MENU:
			showEmployeeMenu();
			break;
		case ADMIN_MENU:
			showAdmininstratorMainMenu();
			break;
		case TRAVELER_MENU:
			showTravelerMenu();
			break;
		case EXIT_APP:
			println("Have a nice day!");
			appExit = Boolean.TRUE;
			break;
		default:
			break;
		}

		return appExit;
	}

	// TODO: need to implement this function
	private void showEmployeeMenu() {
		println("Employee menu not implement yet");
	}
	
	private void showAdmininstratorMainMenu() {
		String[] adminMainMenus = { "Flights", "Seats", "Tickets and Passengers", "Airports", "Travelers", "Employees",
				"Over-ride Trip Cancellation for a ticket", "Quit to previous" };

		int option = 0;

		do {
			println("Welcome to Administrator Menu");

			option = validateAndGetOption(adminMainMenus);
			
			switch (option) {
			case 1:
				flightMenu.showFlightMenu();
				break;
			case 2:
				flightSeatMenu.showFlightSeatMenu();
				break;
			case 3:
				println("Tickets and Passenger menu not implement yet");
				break;
			case 4:
				airportMenu.showAirportMenus();
				break;
			case 5:
				println("Traveler menu not implement yet");
				break;
			case 6:
				println("Employee menu not implement yet");
				break;
			case 7:
				println("Cancel Ticket menu not implement yet");
				break;
			case 8:
				println("");
				break;
			default:
				break;
			}

		} while (option != 8);
	}

	// TODO: need to implement this function
	private void showTravelerMenu() {
		println("Traveler menu not implement yet");
	}
}
