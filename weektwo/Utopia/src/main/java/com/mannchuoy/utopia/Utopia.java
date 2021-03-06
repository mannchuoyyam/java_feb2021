/**
 * 
 */
package com.mannchuoy.utopia;

import java.sql.SQLException;
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
		Menu menu = new Menu();
		while(!menu.showMainMenu()) {
			
		}
	}

}
