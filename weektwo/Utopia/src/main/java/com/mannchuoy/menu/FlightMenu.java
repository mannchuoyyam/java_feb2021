/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.mannchuoy.entity.Airport;
import com.mannchuoy.entity.Flight;
import com.mannchuoy.service.AdminService;

/**
 * @author Mannchuoy Yam
 *
 */
public class FlightMenu extends BaseMenu{
	
	AdminService adminService;
	
	String[] crudMenu = { "Add a new flight", "Update the detail of the flight", "Delete a flight", "View more details about a flight ", "Go to previous" };
	
	public FlightMenu(Scanner scanner) {
		super(scanner);
		adminService = new AdminService();
	}
	
	public void showFlightMenu() {
		int option = 0;
		Flight flight = null;
		do {
			println("Utopia Flight Management System");

			try {
				option = validateAndGetOption(crudMenu);
				
				switch (option) {
				case ADD:
					addFlightMenu();
					break;
				case UPDATE:
					updateFlightMenu();
					break;
				case DELETE:
					flight = userInput.getFlightToBeDeleted();
					adminService.deleteFlight(flight);
					break;
				case READ:
					adminService.listFlights();
					break;
				case GO_TO_PREVIOUS:
					println("");
					break;

				default:
					break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} while (option != GO_TO_PREVIOUS);
	}
	
	private void addFlightMenu() throws SQLException {
		println("Adding a new flight");
		
		Flight flight = userInput.getFlight();
		Airport origin = userInput.getAirport("departure");
		Airport destination = userInput.getAirport("destination");

		adminService.addFlight(origin, destination, flight);
	}
	
	private void updateFlightMenu() throws SQLException {
		Flight flight = userInput.getFlight();
		Airport origin = userInput.getAirport("departure");
		Airport destination = userInput.getAirport("destination");
		adminService.updateFlight(origin, destination, flight);
	}
}
