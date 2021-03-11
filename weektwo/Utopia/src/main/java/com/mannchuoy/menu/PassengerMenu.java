/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mannchuoy.entity.Airport;
import com.mannchuoy.entity.Flight;
import com.mannchuoy.entity.Passenger;
import com.mannchuoy.entity.Route;
import com.mannchuoy.input.PassengerUserInput;
import com.mannchuoy.service.AirportService;
import com.mannchuoy.service.FlightService;
import com.mannchuoy.service.PassengerService;
import com.mannchuoy.service.RouteService;

/**
 * @author Mannchuoy Yam
 *
 */
public class PassengerMenu extends BaseMenu {

	PassengerService passengerService;
	PassengerUserInput passengerUserInput;

	String[] crudMenu = { "Add a new passenger", "Update the detail of the passenger", "Delete a passenger",
			"View more details about a passenger", "Go to previous" };

	public PassengerMenu(Scanner scanner) {
		super(scanner);
		passengerService = new PassengerService();
		passengerUserInput = new PassengerUserInput(scanner);
	}

	public void showPassengerMenu() {
		int option = 0;
		do {
			println("Utopia Traveler Management System");

			option = validateAndGetOption(crudMenu);

			switch (option) {
			case ADD:
				addPassengerMenu();
				break;
			case UPDATE:
				updatePassengerMenu();
				break;
			case DELETE:
				deletePassengerMenu();
				break;
			case READ:
				findPassengerMenu();
				break;
			case GO_TO_PREVIOUS:
				println("");
				break;

			default:
				break;
			}

		} while (option != GO_TO_PREVIOUS);
	}

	private void addPassengerMenu() {
		// show flight to choose from
		FlightService flightService = new FlightService();

		try {
			List<Flight> flights = flightService.findAll();
			if (flights != null && flights.size() > 0) {
				Flight flight = getSelecteFlight(flights);

				Passenger passenger = passengerUserInput.getPassenger();

				passengerService.add(passenger, flight.getId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void updatePassengerMenu() {
		try {
			List<Passenger> passengers = passengerService.findAll();
			if (passengers != null && passengers.size() > 0) {
				Passenger passenger = getSelectePassenger(passengers);

				println("You have chosen to update the Passenger: " + passenger.toString());
				println("Enter 'quit' at any prompt to cancel operation.");

				Passenger newPassenger = passengerUserInput.getPassenger(passenger);

				if (newPassenger != null) {
					passengerService.update(newPassenger);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void deletePassengerMenu() {
		try {
			List<Passenger> passengers = passengerService.findAll();
			if (passengers != null && passengers.size() > 0) {
				Passenger passenger = getSelectePassenger(passengers);
				passengerService.update(passenger);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void findPassengerMenu() {
		try {
			List<Passenger> passengers = passengerService.findAll();
			if (passengers != null && passengers.size() > 0) {
				println("Passenger List:");
				printPassengers(passengers);
				println("");
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

	private Passenger getSelectePassenger(List<Passenger> passengers) throws SQLException {
		printPassengers(passengers);

		// user pick one to update
		int optionStartAt = 1;
		int option = userInput.getFlightUpdateOption(optionStartAt, passengers.size());

		// adjust to 0 base index
		int selectedIndex = option - 1;

		return passengers.get(selectedIndex);
	}
	
	private void printPassengers(List<Passenger> passengers) {
		int index = 1;
		for (Passenger passenger : passengers) {
			println(index + ")" + passenger.getFamilyName() + " " + passenger.getFamilyName());
			index++;
		}
	}
}
