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
import java.time.Instant;
import java.util.List;

import com.mannchuoy.dao.BookingDao;
import com.mannchuoy.dao.DBConnection;
import com.mannchuoy.dao.FlightBookingDao;
import com.mannchuoy.dao.PassengerDao;
import com.mannchuoy.entity.Booking;
import com.mannchuoy.entity.FlightBooking;
import com.mannchuoy.entity.Passenger;

/**
 * @author Mannchuoy Yam
 *
 */
public class PassengerService {
	
	public void add(Passenger passenger, int flightId) throws SQLException {
		Connection connection = null;
		try {
			connection = DBConnection.getConnection(Boolean.FALSE);
			PassengerDao passengerDao = new PassengerDao(connection);
			BookingDao bookingDao = new BookingDao(connection);
			FlightBookingDao flightBookingDao = new FlightBookingDao(connection);
			
			//create booking 
			Booking booking = new Booking();
			booking.setIsActive(true);
			
			//TODO: need to generate unique confirmation for the flight
			booking.setConfirmationCode(Instant.now().toString());
			Integer id = bookingDao.add(booking);
			
			booking = bookingDao.findById(id);
			
			//create flight booking
			FlightBooking flightBooking = new FlightBooking();
			flightBooking.setFlightId(flightId);
			flightBooking.setBookingId(booking.getId());
			
			flightBookingDao.add(flightBooking);
			
			passenger.setBookingId(booking.getId());
			
			id = passengerDao.add(passenger);

			connection.commit();
			
			if(passengerDao.findById(id) != null){
				System.out.println("\n" + passenger + " has been added.\n");
			}
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		} finally {
			connection.close();
		}
	}
	
	public void update(Passenger passenger) throws SQLException {
		Connection connection = null;
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			PassengerDao passengerDao = new PassengerDao(connection);
			passengerDao.update(passenger);

			if(passengerDao.findById(passenger.getId()) != null){
				System.out.println("\n" + passenger + " has been updated.\n");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
	}
	
	public void delete(Passenger passenger) throws SQLException {
		Connection connection = null;
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			PassengerDao passengerDao = new PassengerDao(connection);
			passengerDao.delete(passenger);

			if(passengerDao.findById(passenger.getId()) == null){
				System.out.println("\n" + passenger + " has been deleted.\n");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
	}
	
	public Passenger findById(int id) throws SQLException {
		Connection connection = null;
		Passenger passenger = null;
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			PassengerDao passengerDao = new PassengerDao(connection);
			passenger = passengerDao.findById(id);
			
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
		
		return passenger;
	}
	
	public List<Passenger> findAll() throws SQLException{
		Connection connection = null;
		List<Passenger> passengers = null;
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			PassengerDao passengerDao = new PassengerDao(connection);
			passengers = passengerDao.findAll();
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
		
		return passengers;
	}
}
