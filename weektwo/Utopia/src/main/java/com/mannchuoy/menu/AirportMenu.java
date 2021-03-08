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
import java.util.List;
import java.util.Scanner;

import com.mannchuoy.dao.AirportDao;
import com.mannchuoy.dao.DBConnection;
import com.mannchuoy.entity.Airport;
import com.mannchuoy.service.AdminService;

/**
 * @author Mannchuoy Yam
 *
 */
public class AirportMenu extends BaseMenu {
	AdminService adminService;
	
	public AirportMenu(Scanner scanner) {
		super(scanner);
		adminService = new AdminService();
	}
	
	public void showAirportMenus() {
		int option = 0;
		do {
			println("Utopia Airports Management System?");
			try {
				option = validateAndGetOption(crudMenu);
				switch (option) {
				case ADD:
					addAirportMenu();
					break;
				case UPDATE:
					updateAirportMenu();
					break;
				case DELETE:
					deleteAirportMenu();
					break;
				case READ:
					getAirportMenu();
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
	
	private void addAirportMenu() throws SQLException {
		Airport airport = userInput.getAirport("");
		adminService.addAirport(airport);
	}
	
	private void updateAirportMenu() throws SQLException{
		// show list of airport
		Connection connection = DBConnection.getConnection(Boolean.TRUE);
		AirportDao airportDao = new AirportDao(connection);
		List<Airport> airports = airportDao.listAirport();
		if(airports.size() > 0) {
			int index = 1;
			for(Airport airport : airports) {
				println(index + ")" + airport);
				index++;
			}
			
			int optionStartAt = 1;
			int optionEndAt = airports.size();
			int option = userInput.getFlightUpdateOption(optionStartAt, optionEndAt);
			
			Airport airport = airports.get(option -1);
			println("You have selected airport: " +  airport + " to update");
			
			String city = userInput.getAirportCity("Enter city for the airport: ");
			airport.setCity(city);
			adminService.updateAirport(airport);	
		}
	}
	
	private void deleteAirportMenu() throws SQLException{
		Connection connection = DBConnection.getConnection(Boolean.TRUE);
		AirportDao airportDao = new AirportDao(connection);
		List<Airport> airports = airportDao.listAirport();
		if(airports.size() > 0) {
			int index = 1;
			for(Airport airport : airports) {
				println(index + ")" + airport);
				index++;
			}
			
			int optionStartAt = 1;
			int optionEndAt = airports.size();
			int option = userInput.getFlightUpdateOption(optionStartAt, optionEndAt);
			
			Airport airport = airports.get(option -1);
			
			adminService.deleteAirport(airport);	
		}
	}
	
	private void getAirportMenu() throws SQLException {
		List<Airport> airports = adminService.listAirports();
		int index = 1;
		for(Airport airport : airports) {
			println(index + ")" + airport);
			index++;
		}
		println("");
	}
	
}
