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
import java.util.Scanner;

import com.mannchuoy.dao.AirportDao;
import com.mannchuoy.dao.DBConnection;
import com.mannchuoy.dao.FlightDao;
import com.mannchuoy.dao.RouteDao;
import com.mannchuoy.entity.Airport;
import com.mannchuoy.entity.Flight;
import com.mannchuoy.entity.FlightSeat;
import com.mannchuoy.entity.Route;
import com.mannchuoy.input.FlightSeatUserInput;
import com.mannchuoy.service.AirportService;
import com.mannchuoy.service.FlightSeatService;
import com.mannchuoy.service.FlightService;
import com.mannchuoy.service.RouteService;

/**
 * @author Mannchuoy Yam
 *
 */
public class FlightSeatMenu extends BaseMenu {

	FlightSeatService flightSeatService;
	FlightSeatUserInput flightSeatUserInput;

	String[] crudMenu = { "Add a new seat", "Update the detail of the seat", "Delete a flight seat",
			"View more details about a flight seat", "Go to previous" };

	public FlightSeatMenu(Scanner scanner) {
		super(scanner);
		flightSeatService = new FlightSeatService();
		flightSeatUserInput = new FlightSeatUserInput(scanner);
	}

	public void showFlightSeatMenu() {
		int option = 0;
		do {
			println("Utopia Flight Seat Management System");

			try {
				option = validateAndGetOption(crudMenu);

				switch (option) {
				case ADD:
					addFlightSeatMenu();
					break;
				case UPDATE:
					updateFlightSeatMenu();
					break;
				case DELETE:
					deleteFlightSeatMenu();
					break;
				case READ:
					findFlightSeatMenu();
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

	private void addFlightSeatMenu() throws SQLException {
		// show flight to choose from
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

			int numberOfFirstClass = flightSeatUserInput.getSeatNumberForClass("First");
			int numberOfBusinessClass = flightSeatUserInput.getSeatNumberForClass("Business");
			int numberOfEconomyClass = flightSeatUserInput.getSeatNumberForClass("Economy");

			FlightSeat flightSeat = new FlightSeat(flight.getId(), numberOfFirstClass, numberOfBusinessClass,
					numberOfEconomyClass);

			flightSeatService.add(flightSeat);
		}
	}

	private void updateFlightSeatMenu() {
		// show flight to choose from
		FlightService flightService = new FlightService();

		try {
			List<Flight> flights = flightService.findAll();
			if (flights != null && flights.size() > 0) {
				Flight flight = getSelecteFlight(flights);

				FlightSeat flightSeat = flightSeatService.findById(flight.getId());

				if (flightSeat != null) {
					int numberOfFirstClass = flightSeatUserInput.getSeatNumberForClassToBeUpdated("First",
							flightSeat.getNumberOfFirstClass());
					int numberOfBusinessClass = flightSeatUserInput.getSeatNumberForClassToBeUpdated("Business",
							flightSeat.getNumberOfBusinessClass());
					int numberOfEconomyClass = flightSeatUserInput.getSeatNumberForClassToBeUpdated("Economy",
							flightSeat.getNumberOfEconomyClass());

					FlightSeat newFlightSeat = new FlightSeat(flight.getId(), numberOfFirstClass, numberOfBusinessClass,
							numberOfEconomyClass);

					flightSeatService.update(newFlightSeat);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void deleteFlightSeatMenu() {
		// show flight to choose from
		FlightService flightService = new FlightService();

		try {
			List<Flight> flights = flightService.findAll();
			if (flights != null && flights.size() > 0) {
				Flight flight = getSelecteFlight(flights);
				FlightSeat flightSeat = flightSeatService.findById(flight.getId());

				if (flightSeat != null) {
					flightSeatService.delete(flightSeat);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void findFlightSeatMenu() {
		// show flight to choose from
		FlightService flightService = new FlightService();

		try {
			List<Flight> flights = flightService.findAll();
			if (flights != null && flights.size() > 0) {
				Flight flight = getSelecteFlight(flights);
				
				FlightSeat flightSeat = flightSeatService.findById(flight.getId());

				if (flightSeat != null) {
					System.out.println("\n" + flightSeat + "\n");
				}else {
					System.out.println("\nThere is no Flight Seat related to flight Id: " + flight.getId() + "\n");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private Flight getSelecteFlight(List<Flight> flights) throws SQLException {
		List<Airport> origins = new ArrayList<>();
		List<Airport> destinations = new ArrayList<>();

		RouteService routeService = new RouteService();
		AirportService airportService = new AirportService();

		for (Flight flight : flights) {
			int routeId = flight.getRouteId();
			Route route = routeService.findById(routeId);
			Airport origin = airportService.findById(route.getOriginId());
			Airport destination = airportService.findById(route.getDestinationId());

			origins.add(origin);
			destinations.add(destination);
		}

		for (int i = 0; i < origins.size(); ++i) {
			println((i + 1) + ")" + origins.get(i) + " --> " + destinations.get(i));
		}

		// user pick one to update
		int optionStartAt = 1;
		int option = userInput.getFlightUpdateOption(optionStartAt, flights.size());

		// adjust to 0 base index
		int selectedIndex = option - 1;

		return flights.get(selectedIndex);
	}
}
