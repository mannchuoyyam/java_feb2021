/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.mannchuoy.dao.DBConnection;
import com.mannchuoy.dao.FlightDao;
import com.mannchuoy.entity.Flight;


/**
 * @author Mannchuoy Yam
 *
 */
public class FlightService {
	
	public List<Flight> findAll() throws SQLException{
		Connection connection = null;
		List<Flight> flights = null;
		try {
			connection = DBConnection.getConnection(Boolean.FALSE);
			FlightDao flightDao = new FlightDao(connection);
			flights = flightDao.listFlight();
			connection.commit();
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		} finally {
			connection.close();
		}
		
		return flights;
	}
}
