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
import java.util.concurrent.atomic.AtomicInteger;

import com.mannchuoy.entity.User;
import com.mannchuoy.entity.UserRole;
import com.mannchuoy.service.UserRoleService;

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
		
		int userRoleId = getUserRoleId();
		
		if(scanner.hasNextLine()) {
			skipNewLine();
		}
		// TODO: need validation
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
		
		user.setRoleId(userRoleId);
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
	
	public User getSelectedUser(List<User> users) {
		String prompt = "Select one of the user role from option above";
		int indexStartAt = 1;
		int indexEndAt = users.size();
		
		int option = selectAnOption(indexStartAt, indexEndAt, prompt);
		
		// adjust to 0 base index
		int selectedIndex = option -1;
		
		return users.get(selectedIndex);
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
	
	
	private boolean updateEmployeeName(User user, User newUser) {
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
		UserRoleService userRoleService = new UserRoleService();
		try {
			List<UserRole> userRoles = userRoleService.findAll();
			if(userRoles != null && userRoles.size() > 0) {
				printUserRoles(userRoles);
				
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
							int selectedIndex = Integer.valueOf(input);
							if(selectedIndex < 1 || selectedIndex > userRoles.size()) {
								input = null;
							}else {
								UserRole userRole = userRoles.get(selectedIndex - 1);
								newUser.setRoleId(userRole.getId());
							}
						}catch(NumberFormatException e) {
							input = null;
						}
					}
				}
			}else {
				// TODO:need to create a user role
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return true;
	}
	
	private int getUserRoleId() {
		UserRoleService userRoleService = new UserRoleService();
		int userRoleId = 0;
		
		try {
			List<UserRole> userRoles = userRoleService.findAll();
			if(userRoles != null && userRoles.size() > 0) {
				printUserRoles(userRoles);
				
				UserRole userRole = getSelectedUserRole(userRoles);
				
				userRoleId = userRole.getId();
			}else {
				// TODO: need to create a user role
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return userRoleId;
	}
	
	private UserRole getSelectedUserRole(List<UserRole> userRoles) {
		String prompt = "Select one of the user role from option above";
		int indexStartAt = 1;
		int indexEndAt = userRoles.size();
		
		int option = selectAnOption(indexStartAt, indexEndAt, prompt);
		
		// adjust to 0 base index
		int selectedIndex = option -1;
		
		return userRoles.get(selectedIndex);
	}
	
	private void printUserRoles(List<UserRole> userRoles) {
		AtomicInteger index = new AtomicInteger(1);
		userRoles.stream()
			.forEach(e -> println(index.getAndIncrement() + ") " + e.getName()));
	}
}
