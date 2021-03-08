/**
 * 
 */
package com.mannchuoy.utopia;

import java.sql.SQLException;
import java.util.Scanner;

import com.mannchuoy.menu.Menu;

/**
 * @author Mannchuoy Yam
 *
 */
public class Utopia {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Menu menu = new Menu(scanner);
		while(!menu.showMainMenu()) {
			
		}
	}

}
