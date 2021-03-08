/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.mannchuoy.dao.AirportDao;
import com.mannchuoy.dao.DBConnection;
import com.mannchuoy.dao.FlightDao;
import com.mannchuoy.dao.RouteDao;
import com.mannchuoy.entity.Airport;
import com.mannchuoy.entity.Flight;
import com.mannchuoy.entity.Route;
import com.mannchuoy.service.AdminService;

/**
 * @author Mannchuoy Yam
 *
 */
public class FlightMenu extends BaseMenu {

	AdminService adminService;

	String[] crudMenu = { "Add a new flight", "Update the detail of the flight", "Delete a flight",
			"View more details about a flight ", "Go to previous" };

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
		// show all flights
		Connection connection = DBConnection.getConnection(Boolean.TRUE);

		FlightDao flightDao = new FlightDao(connection);
		RouteDao routeDao = new RouteDao(connection);
		AirportDao airportDao = new AirportDao(connection);

		List<Flight> flights = flightDao.listFlight();
		if (flights.size() > 0) {
			List<Airport> origins = new ArrayList<>();
			List<Airport> destinations = new ArrayList<>();
			for (Flight flight : flights) {
				int routeId = flight.getRouteId();
				Route route = routeDao.getRouteById(routeId);
				Airport origin = airportDao.findById(route.getOriginId());
				Airport destination = airportDao.findById(route.getDestinationId());
				origins.add(origin);
				destinations.add(destination);
			}

			for (int i = 0; i < origins.size(); ++i) {
				println((i + 1) + ")" + origins.get(i) + " --> " + destinations.get(i));
			}

			// user pick one to update
			int option = 0;
			int optionStartAt = 1;
			int optionEndAt = flights.size();
			while(option == 0) {
				print("Select a flight to update (" + optionStartAt + " - " + optionEndAt + "): ");
				try {
					option = scanner.nextInt();
					if(option < optionStartAt || option > optionEndAt) {
						option = 0;
						println("Please choose the from the options above");
					}
				}catch(NoSuchElementException e) {
					String s = scanner.nextLine();
					println(s + " is a bad input");
				}
			}
			// update
			Flight flight = flights.get(option);
			Airport origin = origins.get(option);
			Airport destination = destinations.get(option);
			adminService.updateFlight(origin, destination, flight);
		}
	}
}
