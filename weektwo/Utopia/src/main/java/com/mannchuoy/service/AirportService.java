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

import com.mannchuoy.dao.AirportDao;
import com.mannchuoy.dao.DBConnection;
import com.mannchuoy.entity.Airport;


/**
 * @author Mannchuoy Yam
 *
 */
public class AirportService {
	public Airport findById(String id) throws SQLException {
		Connection connection = null;
		Airport airport = null;
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			AirportDao airportDao = new AirportDao(connection);
			airport = airportDao.findById(id);
			
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
		
		return airport;
	}
}
