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
import com.mannchuoy.entity.Passenger;
import com.mannchuoy.entity.Route;
import com.mannchuoy.entity.Ticket;
import com.mannchuoy.input.FlightSeatUserInput;
import com.mannchuoy.input.TicketUserInput;
import com.mannchuoy.service.AirportService;
import com.mannchuoy.service.FlightSeatService;
import com.mannchuoy.service.TicketService;
import com.mannchuoy.service.FlightService;
import com.mannchuoy.service.PassengerService;
import com.mannchuoy.service.RouteService;

/**
 * @author Mannchuoy Yam
 *
 */
public class TicketMenu extends BaseMenu {

	final int QUIT = -1;
	final int NO_CHANGE = -2;
	final int OFF_SET = 1;
	
	TicketService ticketService;
	TicketUserInput ticketUserInput;

	String[] crudMenu = { "Add a new ticket", "Update the detail of the ticket", "Delete a ticket",
			"View more details about a ticket", "Go to previous" };

	public TicketMenu(Scanner scanner) {
		super(scanner);
		ticketService = new TicketService();
		ticketUserInput = new TicketUserInput(scanner);
	}

	public void showTicketMenu() {
		int option = 0;
		do {
			println("Utopia Ticket Management System");

			option = validateAndGetOption(crudMenu);

			switch (option) {
			case ADD:
				addTicketMenu();
				break;
			case UPDATE:
				updateTicketMenu();
				break;
			case DELETE:
				deleteTicketMenu();
				break;
			case READ:
				findTicketMenu();
				break;
			case GO_TO_PREVIOUS:
				println("");
				break;

			default:
				break;
			}

		} while (option != GO_TO_PREVIOUS);
	}

	private void addTicketMenu() {
		// show flight to choose from
		FlightService flightService = new FlightService();
		FlightSeatService flightSeatService = new FlightSeatService();
		PassengerService passengerService = new PassengerService();

		try {
			List<Flight> flights = flightService.findAll();
			if (flights != null && flights.size() > 0) {
				Flight flight = getSelecteFlight(flights);

				// get flight seat
				List<FlightSeat> flightSeats = flightSeatService.findByFlightId(flight.getId());
				if (flightSeats == null || flightSeats.size() == 0) {
					println("\nThere is no seat available\n");
					return;
				}
				FlightSeat flightSeat = getSelectedFlightSeat(flightSeats);

				// get passenger
				List<Passenger> passengers = passengerService.findAllByFlightId(flight.getId());
				if (passengers == null || passengers.size() == 0) {
					println("\nThere is no passengers\n");
					return;
				}
				Passenger passenger = getSelectedPassenger(passengers);

				Ticket ticket = new Ticket(0, passenger.getId(), flight.getId(), flightSeat.getSeatNumber());

				ticketService.add(ticket);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private FlightSeat getSelectedFlightSeat(List<FlightSeat> flightSeats) {
		BaseMenu.printFlightSeat(flightSeats);
		FlightSeatUserInput flightSeatUserInput = new FlightSeatUserInput(scanner);
		return flightSeatUserInput.getSelectedFlightSeat(flightSeats);
	}

	private Ticket getSelectedTicket(List<Ticket> tickets) {
		printTicket(tickets);

		return ticketUserInput.getSelectedTicket(tickets);
	}

	private Passenger getSelectedPassenger(List<Passenger> passengers) {
		BaseMenu.printPassenger(passengers);
		String prompt = "Select a passenger: ";
		int option = ticketUserInput.selectAnOption(1, passengers.size(), prompt);

		Passenger passenger = passengers.get(option - 1);
		return passenger;
	}

	private void updateTicketMenu() {
		// show flight to choose from
		FlightService flightService = new FlightService();
		
		try {
			List<Flight> flights = flightService.findAll();
			if (flights != null && flights.size() > 0) {
				Flight flight = getSelecteFlight(flights);

				// get flight seat
				List<Ticket> tickets = ticketService.findByFlightId(flight.getId());
				if (tickets == null || tickets.size() == 0) {
					println("There is no seat available to update");
					return;
				}

				Ticket ticket = getSelectedTicket(tickets);

				Ticket newTicket = getUpdatedTicket(ticket);

				if (newTicket != null) {
					ticketService.update(newTicket);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Ticket getUpdatedTicket(Ticket ticket) {
		println("You have chosen to update ticket: " + ticket.toString());
		println("Enter 'quit' at any prompt to cancel operation.");

		Ticket newTicket = new Ticket();
		newTicket.setId(ticket.getId());

		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		if (!updateFlight(ticket, newTicket)) {
			return null;
		}

		if (!updateSeatNumber(ticket, newTicket)) {
			return null;
		}

		if (!updatePassenger(ticket, newTicket)) {
			return null;
		}
		return newTicket;
	}

	private boolean updateFlight(Ticket ticket, Ticket newTicket) {
		// show flight to choose from
		FlightService flightService = new FlightService();
	
		List<Flight> flights = null;
		try {
			flights = flightService.findAll();
			if (flights != null && flights.size() > 0) {
				println("\nSelect a flight below to change flight number");
				printFlight(flights);
				String prompt = "Enter flight to update for your ticket or N/A for no change: ";
				int flightId = ticketUserInput.getIndex(flights.size(), prompt);
				if (flightId == QUIT) {
					return false;
				} else if (flightId == NO_CHANGE) {
					newTicket.setFlightId(ticket.getFlightId());
				} else {
					newTicket.setFlightId(flights.get(flightId - OFF_SET).getId());
				}
			} else {
				println("There is no flight to choose");
				newTicket.setFlightId(ticket.getFlightId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	private boolean updatePassenger(Ticket ticket, Ticket newTicket) {
		PassengerService passengerService = new PassengerService();
		try {
			// get passenger
			List<Passenger> passengers = passengerService.findAllByFlightId(ticket.getFlightId());
			if (passengers == null || passengers.size() == 0) {
				println("\nThere is no passengers\n");
				newTicket.setPassengerId(ticket.getPassengerId());
			}else {
				println("\nChoose a passenger from below to update your ticket.\n");
				printPassenger(passengers);
				String prompt = "Enter passenger or N/A for no change: ";
				int passengerIndex = ticketUserInput.getIndex(passengers.size(), prompt);
				if (passengerIndex == QUIT) {
					return false;
				} else if (passengerIndex == NO_CHANGE) {
					newTicket.setPassengerId(ticket.getPassengerId());
				} else {
					newTicket.setPassengerId(passengers.get(passengerIndex - OFF_SET).getId());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	private boolean updateSeatNumber(Ticket ticket, Ticket newTicket) {
		FlightSeatService flightSeatService = new FlightSeatService();
		
		try {
			// get flight seat
			List<FlightSeat> flightSeats = flightSeatService.findByFlightId(newTicket.getFlightId());
			if (flightSeats == null || flightSeats.size() == 0) {
				println("\nThere is no seat available\n");			
			}else {
				println("\nSelect one of seat below to update\n");
				
				printFlightSeat(flightSeats);
				
				String prompt = "Enter seat or N/A for no change: ";
				int flightSeatIndex = ticketUserInput.getIndex(flightSeats.size(), prompt);
				if (flightSeatIndex == QUIT) {
					return false;
				} else if (flightSeatIndex == NO_CHANGE) {
					newTicket.setSeatNumber(ticket.getSeatNumber());
				} else {
					newTicket.setSeatNumber(flightSeats.get(flightSeatIndex - OFF_SET).getSeatNumber());
				}
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	private void deleteTicketMenu() {
		// show flight to choose from
		FlightService flightService = new FlightService();

		try {
			List<Flight> flights = flightService.findAll();
			if (flights != null && flights.size() > 0) {
				Flight flight = getSelecteFlight(flights);

				List<Ticket> tickets = ticketService.findByFlightId(flight.getId());

				if (tickets != null && tickets.size() > 0) {
					// get selected tickets
					Ticket ticket = getSelectedTicket(tickets);
					ticketService.delete(ticket);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void findTicketMenu() {
		// show flight to choose from
		FlightService flightService = new FlightService();

		try {
			List<Flight> flights = flightService.findAll();
			if (flights != null && flights.size() > 0) {
				Flight flight = getSelecteFlight(flights);

				List<Ticket> tickets = ticketService.findByFlightId(flight.getId());

				if (tickets != null && tickets.size() > 0) {
					printTicket(tickets);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void printTicket(List<Ticket> tickets) {
		int index = 1;
		println("List of tickets: ");
		for (Ticket ticket : tickets) {
			println(index + ") " + ticket);
			index++;
		}
		println("");
	}

	private void printFlight(List<Flight> flights) throws SQLException {
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
