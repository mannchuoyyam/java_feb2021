/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.input;

import java.util.Scanner;

import com.mannchuoy.entity.User;

/**
 * @author Mannchuoy Yam
 *
 */
public class EmployeeUserInput extends BaseUserInput{
	
	public EmployeeUserInput(Scanner scanner) {
		super(scanner);
	}
	
	public User getEmployee() {
		
		if(scanner.hasNextLine()) {
			skipNewLine();
		}
		
		User user = new User();
		
		print("Enter first name: ");
		String firstName = scanner.nextLine();
		print("Enter last name: ");
		String lastName = scanner.nextLine();
		print("Enter username: ");
		String username = scanner.nextLine();
		print("Enter email: ");
		String email = scanner.nextLine();
		print("Enter password: ");
		String password = scanner.nextLine();
		print("Enter phone: ");
		String phone = scanner.nextLine();
		
		user.setGivenName(firstName);
		user.setFamilyName(lastName);
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		
		return user;
	}
	
	public User getUser(User user) {
		
		if(scanner.hasNextLine()) {
			skipNewLine();
		}
		
		User newUser = new User();
		
		if(!updateEmployeeName(user, newUser)) {
			return null;
		}
		
		if(!updateEmployeeUsername(user, newUser)) {
			return null;
		}
		
		if(!updateEmployeeEmail(user, newUser)) {
			return null;
		}
		
		if(!updateEmployeePassword(user, newUser)) {
			return null;
		}
		
		if(!updateEmployeePhone(user, newUser)) {
			return null;
		}
		
		if(!updateEmployeeRole(user, newUser)) {
			return null;
		}
		
		newUser.setId(user.getId());
		
		return newUser;
	}
	
	private boolean updateEmployeeUsername(User user, User newUser) {
		String input = null;
		while (input == null) {
			print("Enter employee username or N/A for no change: ");
			input = scanner.nextLine();
			if (input.toLowerCase().equals("quit")) {
				return false;
			} else if (input.toLowerCase().equals("n/a")) {
				newUser.setUsername(user.getUsername());
			}else {
				newUser.setUsername(input);
			}
		}
		
		return true;
	}
	
	
	public boolean updateEmployeeName(User user, User newUser) {
		print("Enter employee first name or N/A for no change: ");
		String firstName = scanner.nextLine();
		
		if (firstName.toLowerCase().equals("quit")) {
			return false;
		} else if (firstName.toLowerCase().equals("n/a")) {
			newUser.setGivenName(user.getGivenName());
		}else {
			newUser.setGivenName(firstName);
		}
		
		print("Enter employee last name or N/A for no change: ");
		String lastName = scanner.nextLine();
		
		if (lastName.toLowerCase().equals("quit")) {
			return false;
		} else if (lastName.toLowerCase().equals("n/a")) {
			newUser.setFamilyName(user.getFamilyName());
		}else {
			newUser.setFamilyName(lastName);
		}
		
		return true;
	}
	
	private boolean updateEmployeeEmail(User user, User newUser) {
		String input = null;
		while (input == null) {
			print("Enter employee email or N/A for no change: ");
			input = scanner.nextLine();
			if (input.toLowerCase().equals("quit")) {
				return false;
			} else if (input.toLowerCase().equals("n/a")) {
				newUser.setEmail(user.getEmail());
			}else {
				newUser.setEmail(input);
			}
		}
		return true;
	}
	
	private boolean updateEmployeePassword(User user, User newUser) {
		String input = null;
		while (input == null) {
			print("Enter employee password or N/A for no change: ");
			input = scanner.nextLine();
			if (input.toLowerCase().equals("quit")) {
				return false;
			} else if (input.toLowerCase().equals("n/a")) {
				newUser.setPassword(user.getPassword());
			}else {
				newUser.setPassword(input);
			}
		}
		return true;
	}
	
	private boolean updateEmployeePhone(User user, User newUser) {
		String input = null;
		while (input == null) {
			print("Enter employee phone or N/A for no change: ");
			input = scanner.nextLine();
			if (input.toLowerCase().equals("quit")) {
				return false;
			} else if (input.toLowerCase().equals("n/a")) {
				newUser.setPhone(user.getPhone());
			}else {
				newUser.setPhone(input);
			}
		}
		return true;
	}
	
	private boolean updateEmployeeRole(User user, User newUser) {
		// show use role list
	
		String input = null;
		
		while (input == null) {
			print("Enter employee role or N/A for no change: ");
			input = scanner.nextLine();
			if (input.toLowerCase().equals("quit")) {
				return false;
			} else if (input.toLowerCase().equals("n/a")) {
				newUser.setRoleId(user.getRoleId());
			}else {
				try {
					newUser.setRoleId(Integer.valueOf(input));
				}catch(NumberFormatException e) {
					input = null;
				}
			}
		}
		return true;
	}
}
