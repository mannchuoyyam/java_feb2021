/**
 * 
 */
package com.mannchuoy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author mann
 *
 */
public class DBConnection {
	
	
	public static Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/utopia", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
		return connection;
	}
}
