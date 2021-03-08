/**
 * 
 */
package com.mannchuoy.dao;


import static org.junit.Assert.assertNotEquals;

import java.sql.SQLException;

import org.junit.Test;


/**
 * @author Mannchuoy Yam
 *
 */
public class DBConnectionTest {
	@Test
	public void getConnectionTest() {
		try {
			assertNotEquals(null, DBConnection.getConnection(Boolean.TRUE));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
