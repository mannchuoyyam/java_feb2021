/**
 * 
 */
package com.mannchuoy.dao;


import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

/**
 * @author Mannchuoy Yam
 *
 */
public class DBConnectionTest {
	@Test
	public void getConnectionTest() {
		try {
			assertNotEquals(null, DBConnection.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
