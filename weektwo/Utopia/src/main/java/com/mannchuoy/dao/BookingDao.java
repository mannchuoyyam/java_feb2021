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

import com.mannchuoy.entity.Booking;


/**
 * @author Mannchuoy Yam
 *
 */
public class BookingDao extends BaseDao<Booking>{
	final String INSERT_SQL = "INSERT INTO booking(is_active, confirmation_code) VALUES(?, ?)";
	final String UPDATE_SQL = "UPDATE booking SET is_active = ?, confimration_code = ? WHERE id = ?";
	final String DELETE_SQL = "DELETE FROM booking WHERE id = ?";
	final String GET_ONE = "SELECT * FROM booking WHERE id = ?";
	final String GET_ALL = "SELECT * FROM booking";
	
	public BookingDao(Connection connection) {
		super(connection);
	}

	public Integer add(Booking booking) throws SQLException {
		return addAndGetGeneratedKey(INSERT_SQL, new Object[] {booking.getIsActive(), booking.getConfirmationCode()});
	}
	
	public int update(Booking booking) throws SQLException{
		return update(UPDATE_SQL, new Object[] { booking.getIsActive(), booking.getConfirmationCode(), booking.getId()});
	}
	
	public int delete(Booking booking) throws SQLException{
		return delete(DELETE_SQL, new Object[] { booking.getId() });
	}
	
	public List<Booking> findAll() throws SQLException {
		return read(GET_ALL, new Object[] {});
	}

	// return null if not found
	public Booking findById(int id) throws SQLException {
		return findById(GET_ONE, new Object[] {id});
	}
	
	@Override
	public List<Booking> populateData(ResultSet resultSet) throws SQLException {
		List<Booking> bookings = new ArrayList<Booking>();
		
		while(resultSet.next()) {
			Booking booking = new Booking();
			booking.setId(resultSet.getInt("id"));
			booking.setIsActive(resultSet.getBoolean("is_active"));
			booking.setConfirmationCode(resultSet.getString("confirmation_code"));
			
			bookings.add(booking);
		}
		
		return bookings;
	}

	@Override
	public Booking getOneElement(ResultSet resultSet) throws SQLException {
		Booking booking = null;
		
		while(resultSet.next()) {
			booking = new Booking();
			booking.setId(resultSet.getInt("id"));
			booking.setIsActive(resultSet.getBoolean("is_active"));
			booking.setConfirmationCode(resultSet.getString("confirmation_code"));
		}
		
		return booking;
	}

}
