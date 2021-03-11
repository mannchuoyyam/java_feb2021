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

import com.mannchuoy.entity.User;
import com.mannchuoy.input.EmployeeUserInput;
import com.mannchuoy.service.EmployeeService;

/**
 * @author Mannchuoy Yam
 *
 */
public class EmployeeMenu extends BaseMenu {

	EmployeeService employeeService;
	EmployeeUserInput employeeUserInput;

	String[] crudMenu = { "Add a new employee", "Update the detail of the employee", "Delete a employee",
			"View more details about a employee", "Go to previous" };

	public EmployeeMenu(Scanner scanner) {
		super(scanner);
		employeeService = new EmployeeService();
		employeeUserInput = new EmployeeUserInput(scanner);
	}

	public void showEmployeeMenu() {
		int option = 0;
		do {
			println("Utopia Employee Management System");

			option = validateAndGetOption(crudMenu);

			switch (option) {
			case ADD:
				addEmployeeMenu();
				break;
			case UPDATE:
				updateEmployeeMenu();
				break;
			case DELETE:
				deleteEmployeeMenu();
				break;
			case READ:
				findEmployeeMenu();
				break;
			case GO_TO_PREVIOUS:
				println("");
				break;

			default:
				break;
			}

		} while (option != GO_TO_PREVIOUS);
	}

	private void addEmployeeMenu() {
		try {
			User employee = employeeUserInput.getEmployee();
			
			employeeService.add(employee);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void updateEmployeeMenu() {
		try {
			List<User> users = employeeService.findAll();
			if (users != null && users.size() > 0) {
				User user = getSelectedUser(users);

				println("You have chosen to update the employee: " + user.getGivenName() + " " + user.getFamilyName());
				println("Enter 'quit' at any prompt to cancel operation.");

				User newUser = employeeUserInput.getUser(user);

				if (newUser != null) {
					employeeService.update(newUser);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void deleteEmployeeMenu() {
		try {
			List<User> users = employeeService.findAll();
			if (users != null && users.size() > 0) {
				User user = getSelectedUser(users);
				employeeService.update(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void findEmployeeMenu() {
		try {
			List<User> users = employeeService.findAll();
			if (users != null && users.size() > 0) {
				println("User List:");
				printUsers(users);
				println("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	private User getSelectedUser(List<User> users) throws SQLException {
		printUsers(users);

		// user pick one to update
		int optionStartAt = 1;
		int option = userInput.getFlightUpdateOption(optionStartAt, users.size());

		// adjust to 0 base index
		int selectedIndex = option - 1;

		return users.get(selectedIndex);
	}
	
	private void printUsers(List<User> users) {
		int index = 1;
		for (User user : users) {
			println(index + ")" + user.getFamilyName() + " " + user.getFamilyName());
			index++;
		}
	}
}
