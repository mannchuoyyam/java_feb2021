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
import com.mannchuoy.entity.FlightSeat;
import com.mannchuoy.entity.Route;
import com.mannchuoy.entity.SeatType;
import com.mannchuoy.input.FlightSeatUserInput;
import com.mannchuoy.service.AirportService;
import com.mannchuoy.service.FlightSeatService;
import com.mannchuoy.service.FlightService;
import com.mannchuoy.service.RouteService;
import com.mannchuoy.service.SeatTypeService;

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

		} while (option != GO_TO_PREVIOUS);
	}

	private void addFlightSeatMenu() {
		// show flight to choose from
		FlightService flightService = new FlightService();

		try {
			List<Flight> flights = flightService.findAll();
			if (flights != null && flights.size() > 0) {
				Flight flight = getSelecteFlight(flights);

				String seatNumber = flightSeatUserInput.getSeatNumber();
				int seatType = getSeatTypeId();
				boolean available = flightSeatUserInput.getAvailable();

				FlightSeat flightSeat = new FlightSeat(0, flight.getId(), seatNumber, seatType, available);

				flightSeatService.add(flightSeat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private int getSeatTypeId() {
		int seatTypeId = 0;
		SeatTypeService seatTypeService = new SeatTypeService();
		try {
			List<SeatType> seatTypes = seatTypeService.findAll();
			if (seatTypes != null && seatTypes.size() > 0) {
				BaseMenu.printSeatType(seatTypes);
				SeatType seatType = flightSeatUserInput.getSeatType(seatTypes);
				seatTypeId = seatType.getId();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return seatTypeId;
	}

	private void updateFlightSeatMenu() {
		// show flight to choose from
		FlightService flightService = new FlightService();

		try {
			List<Flight> flights = flightService.findAll();
			if (flights != null && flights.size() > 0) {
				Flight flight = getSelecteFlight(flights);

				List<FlightSeat> flightSeats = flightSeatService.findByFlightId(flight.getId());

				FlightSeat flightSeat = getSelectedFlightSeat(flightSeats);

				println("You have chosen to update the Seat: " + flightSeat.toString());
				println("Enter 'quit' at any prompt to cancel operation.");

				FlightSeat newFlightSeat = flightSeatUserInput.getUpdatedFlightSeat(flightSeat);

				if (newFlightSeat != null) {
					flightSeatService.update(newFlightSeat);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private FlightSeat getSelectedFlightSeat(List<FlightSeat> flightSeats) {
		printFlightSeat(flightSeats);
		return flightSeatUserInput.getSelectedFlightSeat(flightSeats);
	}

	private void printFlightSeat(List<FlightSeat> flightSeats) {
		int index = 1;
		for (FlightSeat flightSeat : flightSeats) {
			println(index + ") " + flightSeat);
			index++;
		}

	}

	private void deleteFlightSeatMenu() {
		// show flight to choose from
		FlightService flightService = new FlightService();

		try {
			List<Flight> flights = flightService.findAll();
			if (flights != null && flights.size() > 0) {
				Flight flight = getSelecteFlight(flights);

				List<FlightSeat> flightSeats = flightSeatService.findByFlightId(flight.getId());

				FlightSeat flightSeat = getSelectedFlightSeat(flightSeats);

				println("You have chosen to delete the seat: " + flightSeat.toString());

				flightSeatService.delete(flightSeat);
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

				List<FlightSeat> flightSeats = flightSeatService.findByFlightId(flight.getId());

				println("\nSeat list: ");
				printFlightSeat(flightSeats);
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
}
