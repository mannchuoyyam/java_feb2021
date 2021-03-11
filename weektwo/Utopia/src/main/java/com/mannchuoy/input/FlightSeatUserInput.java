/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.input;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.mannchuoy.entity.FlightSeat;
import com.mannchuoy.entity.SeatType;
import com.mannchuoy.menu.BaseMenu;
import com.mannchuoy.service.SeatTypeService;

/**
 * @author Mannchuoy Yam
 *
 */
public class FlightSeatUserInput extends BaseUserInput {

	public FlightSeatUserInput(Scanner scanner) {
		super(scanner);
	}

	public String getSeatNumber() {
		if (scanner.hasNextLine()) {
			skipNewLine();
		}
		print("Enter seat number: ");
		String seatNumber = scanner.nextLine();
		return seatNumber;
	}

	public boolean getAvailable() {
		println("1. Available");
		println("2. Not Available");

		String prompt = "Choose one of the option: ";
		int available = selectAnOption(1, 2, prompt);

		return available == 1 ? true : false;
	}

	public int getSeatNumberForClassToBeUpdated(String seatClass, int currentNumberOfSeats) {
		String prompt = "Enter number of " + seatClass + " class seats: ";
		println("Existing number of " + seatClass + " class seats: " + currentNumberOfSeats);

		return validateAndGetInteger(prompt);
	}

	public SeatType getSeatType(List<SeatType> seatTypes) {
		String prompt = "Select one of the seat class from option above: ";
		int indexStartAt = 1;
		int indexEndAt = seatTypes.size();

		int option = selectAnOption(indexStartAt, indexEndAt, prompt);

		// adjust to 0 base index
		int selectedIndex = option - 1;

		return seatTypes.get(selectedIndex);
	}

	public FlightSeat getSelectedFlightSeat(List<FlightSeat> flightSeats) {
		String prompt = "Select one of the flight seat from option above:";
		int indexStartAt = 1;
		int indexEndAt = flightSeats.size();

		int option = selectAnOption(indexStartAt, indexEndAt, prompt);

		// adjust to 0 base index
		int selectedIndex = option - 1;

		return flightSeats.get(selectedIndex);
	}

	public FlightSeat getUpdatedFlightSeat(FlightSeat flightSeat) {
		if (scanner.hasNextLine()) {
			skipNewLine();
		}

		FlightSeat newFlightSeat = new FlightSeat();

		if (!updateSeatNumber(flightSeat, newFlightSeat)) {
			return null;
		}

		if (!updateSeatType(flightSeat, newFlightSeat)) {
			return null;
		}

		if (!updateSeatAvailable(flightSeat, newFlightSeat)) {
			return null;
		}

		newFlightSeat.setId(flightSeat.getId());
		newFlightSeat.setFlightId(flightSeat.getFlightId());

		return newFlightSeat;
	}

	private boolean updateSeatNumber(FlightSeat flightSeat, FlightSeat newFlightSeat) {
		String input = null;
		while (input == null) {
			print("Enter seat number or N/A for no change: ");
			input = scanner.nextLine();
			if (input.toLowerCase().equals("quit")) {
				return false;
			} else if (input.toLowerCase().equals("n/a")) {
				newFlightSeat.setSeatNumber(flightSeat.getSeatNumber());
			} else {
				newFlightSeat.setSeatNumber(input);
			}
		}
		return true;
	}

	private boolean updateSeatType(FlightSeat flightSeat, FlightSeat newFlightSeat) {
		// get seat types
		SeatTypeService seatTypeService = new SeatTypeService();
		List<SeatType> seatTypes = null;

		try {
			seatTypes = seatTypeService.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (seatTypes != null && seatTypes.size() > 0) {
			BaseMenu.printSeatType(seatTypes);
			
			String input = null;
			while (input == null) {
				print("Enter seat type or N/A for no change: ");
				input = scanner.nextLine();
				
				if (input.toLowerCase().equals("quit")) {
					return false;
				} else if (input.toLowerCase().equals("n/a")) {
					newFlightSeat.setSeatType(flightSeat.getSeatType());
				} else {
					try {
						Integer option = Integer.valueOf(input);
						if(option > 0 && option <= seatTypes.size()) {
							int seatType = seatTypes.get(option - 1).getId();
							newFlightSeat.setSeatType(seatType);
						}else {
							input = null;
						}						
					} catch (NumberFormatException e) {
						println("Choose betwee 1 and " + seatTypes.size());
						input = null;
					}
				}
			}
		}else {
			println("Can't update the flight seat due to seat_type table is empty");
			return false;
		}

		return true;
	}

	private boolean updateSeatAvailable(FlightSeat flightSeat, FlightSeat newFlightSeat) {
		String input = null;
		println("1. Available");
		println("2. Not Available");
		while (input == null) {
			print("Enter seat available or N/A for no change: ");
			input = scanner.nextLine();
			if (input.toLowerCase().equals("quit")) {
				return false;
			} else if (input.toLowerCase().equals("n/a")) {
				newFlightSeat.setAvailable(flightSeat.getAvailable());
			} else {
				try {
					Integer option = Integer.valueOf(input);
					newFlightSeat.setAvailable(option == 1 ? true : false);
				} catch (NumberFormatException e) {
					println("Choose either 1 or 2");
					input = null;
				}
			}
		}
		return true;
	}
}
