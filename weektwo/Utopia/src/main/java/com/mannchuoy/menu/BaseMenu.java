/**
 * 
 */
package com.mannchuoy.menu;

import java.util.NoSuchElementException;
import java.util.Scanner;

import com.mannchuoy.input.UserInput;

/**
 * @author Mannchuoy Yam
 *
 */
public abstract class BaseMenu {
	// used for CRUD menu
	final int ADD = 1;
	final int UPDATE = 2;
	final int DELETE = 3;
	final int READ = 4;
	final int GO_TO_PREVIOUS = 5;

	// used for main menu
	final int EMPLOYEE_MENU = 1;
	final int ADMIN_MENU = 2;
	final int TRAVELER_MENU = 3;
	final int EXIT_APP = 4;

	protected Scanner scanner;
	UserInput userInput;
	String[] crudMenu = { "Add", "Update", "Delete", "Read", "Go to previous" };
	
	protected BaseMenu(Scanner scanner) {
		this.scanner = scanner;
		userInput = new UserInput(scanner);
	}

	protected void println(String message) {
		System.out.println(message);
	}

	protected void print(String message) {
		System.out.print(message);
	}

	protected void printMenu(String[] menus) {
		for (int i = 0; i < menus.length; ++i) {
			println((i + 1) + ")" + menus[i]);
		}
	}
	
	protected Integer validateAndGetOption(String[] menus) {

		printMenu(menus);

		String prompt = "Please choose one of the options (1 - " + menus.length + "): ";

		int option = 0;

		while (option <= 0 || option > menus.length) {
			print(prompt);
			try {
				option = scanner.nextInt();
			} catch (NoSuchElementException e) {
				if (scanner.hasNext()) {
					scanner.nextLine();
				}
				println("Your input is incorrect. Please try again!");
			}
			println("");
		}

		return option;
	}

}
