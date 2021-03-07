/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Mannchuoy Yam
 *
 */
public class DBConnection {
	
	
	public static Connection getConnection(Boolean autoCommit) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/utopia", "root", "root");
			connection.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
		return connection;
	}
}
