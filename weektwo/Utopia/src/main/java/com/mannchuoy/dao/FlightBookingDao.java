/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mannchuoy.entity.FlightBooking;


/**
 * @author Mannchuoy Yam
 *
 */
public class FlightBookingDao extends BaseDao<FlightBooking>{
	final String INSERT_SQL = "INSERT INTO flight_bookings(flight_id, booking_id) VALUES(?, ?)";
	final String UPDATE_SQL = "UPDATE flight_bookings SET booking_id = ? WHERE flight_id = ?";
	final String DELETE_SQL = "DELETE FROM flight_bookings WHERE flight_id = ? AND booking_id = ?";
	final String GET_ONE = "SELECT * FROM flight_bookings WHERE flight_id = ? AND booking_id = ?";
	final String GET_ALL = "SELECT * FROM flight_bookings";
	
	public FlightBookingDao(Connection connection) {
		super(connection);
	}

	public int add(FlightBooking flightBooking) throws SQLException {
		return save(INSERT_SQL, new Object[] {flightBooking.getFlightId(), flightBooking.getBookingId()});
	}
	
	public int update(FlightBooking flightBooking) throws SQLException{
		return update(UPDATE_SQL, new Object[] { flightBooking.getBookingId(), flightBooking.getFlightId()});
	}
	
	public int delete(FlightBooking flightBooking) throws SQLException{
		return delete(DELETE_SQL, new Object[] { flightBooking.getFlightId(), flightBooking.getBookingId() });
	}
	
	public List<FlightBooking> findAll() throws SQLException {
		return read(GET_ALL, new Object[] {});
	}

	// return null if not found
	public FlightBooking findById(int flightId, int bookingId) throws SQLException {
		return findById(GET_ONE, new Object[] {flightId, bookingId});
	}
	
	@Override
	public List<FlightBooking> populateData(ResultSet resultSet) throws SQLException {
		List<FlightBooking> flightBookings = new ArrayList<FlightBooking>();
		
		while(resultSet.next()) {
			FlightBooking flightBooking = new FlightBooking();
			flightBooking.setFlightId(resultSet.getInt("flight_id"));
			flightBooking.setBookingId(resultSet.getInt("booking_id"));
			
			flightBookings.add(flightBooking);
		}
		
		return flightBookings;
	}

	@Override
	public FlightBooking getOneElement(ResultSet resultSet) throws SQLException {
		FlightBooking flightBooking = null;
		
		while(resultSet.next()) {
			flightBooking = new FlightBooking();
			flightBooking.setFlightId(resultSet.getInt("flight_id"));
			flightBooking.setBookingId(resultSet.getInt("booking_id"));
		}
		
		return flightBooking;
	}

}
