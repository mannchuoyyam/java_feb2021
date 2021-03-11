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
import com.mannchuoy.dao.FlightSeatDao;
import com.mannchuoy.entity.FlightSeat;

/**
 * @author Mannchuoy Yam
 *
 */
public class FlightSeatService {
	
	public void add(FlightSeat flightSeat) throws SQLException {
		Connection connection = null;
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			FlightSeatDao flightSeatDao = new FlightSeatDao(connection);
			Integer id = flightSeatDao.add(flightSeat);

			FlightSeat newFlightSeat = null;
			if(id != null) {
				newFlightSeat = flightSeatDao.findById(id);
			}
			 
			if( newFlightSeat != null){
				System.out.println("\n" + newFlightSeat + " has been added.\n");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
	}
	
	public void update(FlightSeat flightSeat) throws SQLException {
		Connection connection = null;
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			FlightSeatDao flightSeatDao = new FlightSeatDao(connection);
			flightSeatDao.update(flightSeat);

			if(flightSeatDao.findById(flightSeat.getId()) != null){
				System.out.println("\n" + flightSeat + " has been updated.\n");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
	}
	
	public void delete(FlightSeat flightSeat) throws SQLException {
		Connection connection = null;
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			FlightSeatDao flightSeatDao = new FlightSeatDao(connection);
			flightSeatDao.delete(flightSeat);

			if(flightSeatDao.findById(flightSeat.getId()) == null){
				System.out.println("\n" + flightSeat + " has been deleted.\n");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
	}
	
	public FlightSeat findById(int id) throws SQLException {
		Connection connection = null;
		FlightSeat flightSeat = null;
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			FlightSeatDao flightSeatDao = new FlightSeatDao(connection);
			flightSeat = flightSeatDao.findById(id);
			
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
		
		return flightSeat;
	}
	
	public List<FlightSeat> findByFlightId(int id) throws SQLException{
		List<FlightSeat> flightSeats = null;
		Connection connection = null;
		String flightSeatSql = "SELECT * FROM flight_seat WHERE flight_id = ?";
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			FlightSeatDao flightSeatDao = new FlightSeatDao(connection);
			flightSeats = flightSeatDao.read(flightSeatSql, new Object[] { id });
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
		
		return flightSeats;
	}
}
