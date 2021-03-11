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
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
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
					deleteFlightMenu();
					break;
				case READ:
					findFlightMenu();
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
		
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
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
				Airport origin = airportDao.findAirportById(route.getOriginId());
				Airport destination = airportDao.findAirportById(route.getDestinationId());
				origins.add(origin);
				destinations.add(destination);
			}

			for (int i = 0; i < origins.size(); ++i) {
				println((i + 1) + ")" + origins.get(i) + " --> " + destinations.get(i));
			}

			// user pick one to update
			int optionStartAt = 1;
			int option = userInput.getFlightUpdateOption(optionStartAt, flights.size());
			
			int selectedIndex = option - 1;
			Flight flight = flights.get(selectedIndex);
			Airport origin = origins.get(selectedIndex);
			Airport destination = destinations.get(selectedIndex);
			
			// update
			if(userInput.updateFlight(origin, destination, flight)) {
				adminService.updateFlight(origin, destination, flight);
			}else {
				println("No update has been made");
			}		
		}
	}
	
	private void deleteFlightMenu() throws SQLException {
		Flight flight = userInput.getFlightById();
		adminService.deleteFlight(flight);
	}
	
	private void findFlightMenu() throws SQLException {
		Flight flight = userInput.getFlightById();
		int id = flight.getId();
		flight = adminService.getFlightById(flight.getId());
		if(flight != null) {
			Connection connection = DBConnection.getConnection(Boolean.TRUE);
			RouteDao routeDao = new RouteDao(connection);
			AirportDao airportDao = new AirportDao(connection);
			int routeId = flight.getRouteId();
			Route route = routeDao.getRouteById(routeId);
			Airport origin = airportDao.findAirportById(route.getOriginId());
			Airport destination = airportDao.findAirportById(route.getDestinationId());
			
			println("\nFlight id: " + id +":");
			println("Origin: " + origin + " Destination: " + destination);
			println("Departure time: " + flight.getDepartureTime().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)) + "\n");
			connection.close();
		}else {
			println("There is no flight with Id: " + id);
		}
	}
}
