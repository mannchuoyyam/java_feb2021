/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.mannchuoy.entity.Airport;
import com.mannchuoy.service.AdminService;

/**
 * @author Mannchuoy Yam
 *
 */
public class AirportMenu extends BaseMenu {

	public AirportMenu(Scanner scanner) {
		super(scanner);
	}
	
	public void showAirportMenus() {
		int option = 0;

		AdminService adminService = new AdminService();

		do {
			println("What would you like to do with Airports?");

			Airport airport;
			try {
				option = validateAndGetOption(crudMenu);
				switch (option) {
				case ADD:
					airport = userInput.getAirport("");
					adminService.addAirport(airport);
					break;
				case UPDATE:
					airport = userInput.getAirport("");
					adminService.updateAirport(airport);
					break;
				case DELETE:
					airport = userInput.getAirport("");
					adminService.deleteAirport(airport);
					break;
				case READ:
					List<Airport> airports = adminService.listAirports();
					airports.stream().forEach(e -> {
						println(e.getId() + ", " + e.getCity());
					});
					break;
				case GO_TO_PREVIOUS:
					break;
				default:
					break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} while (option != GO_TO_PREVIOUS);
	}
}
