/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment 6: Singleton
 *  Date: 2/27/21 and 2/28/21 
 *  
 */
package com.ss.week.one.weekend.assignment.six;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Mannchuoy Yam
 *
 */
public class SampleSingleton {
	private final String DB_URL = "jdbc:mysql://localhost:3306/test";
	private final String USER_NAME = "root";
	private final String PASSWORD = "root";
	
	private Connection conn = null;
	volatile private static SampleSingleton instance = null;
	
	private SampleSingleton() throws SQLException{
		try {
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	public static SampleSingleton getInstance() {
		if(instance == null) {
			synchronized(SampleSingleton.class) {
				if(instance == null) {
					try {
						instance = new SampleSingleton();
					}catch(SQLException e) {
						System.out.println("Unable to create an instance of SampleSingleton");
					}
				}
			}
		}
		
		return instance;
	}
	
	public BigDecimal databaseQuery(BigDecimal input) throws SQLException{
		BigDecimal x = new BigDecimal(0);
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT id FROM test");
		
			while(rs.next()){
				x = input.multiply(new BigDecimal(rs.getInt(1)));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw e;
		}
		return x;
	}
}
