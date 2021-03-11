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

import com.mannchuoy.entity.Passenger;


/**
 * @author Mannchuoy Yam
 *
 */
public class PassengerDao extends BaseDao<Passenger>{
	final String INSERT_SQL = "INSERT INTO passenger(booking_id, given_name, family_name, dob, gender, address) VALUES(?, ?, ?, ?, ?, ?)";
	final String UPDATE_SQL = "UPDATE passenger SET booking_id = ?, given_name = ?, family_name = ?, dob = ?, gender = ?, address =? WHERE id = ?";
	final String DELETE_SQL = "DELETE FROM passenger WHERE id = ?";
	final String GET_ONE = "SELECT * FROM passenger WHERE id = ?";
	final String GET_ALL = "SELECT * FROM passenger";
	
	public PassengerDao(Connection connection) {
		super(connection);
	}

	public int add(Passenger passenger) throws SQLException {
		return save(INSERT_SQL, new Object[] {passenger.getBookingId(), passenger.getGivenName(),
											passenger.getFamilyName(), passenger.getDateOfBirth(),
											passenger.getGender(), passenger.getAddress()});
	}
	
	public int update(Passenger passenger) throws SQLException{
		return update(UPDATE_SQL, new Object[] {passenger.getBookingId(), passenger.getGivenName(),
				passenger.getFamilyName(), passenger.getDateOfBirth(),
				passenger.getGender(), passenger.getAddress(),
				passenger.getId()});
	}
	
	public int delete(Passenger passenger) throws SQLException{
		return delete(DELETE_SQL, new Object[] { passenger.getId() });
	}
	
	public List<Passenger> findAll() throws SQLException {
		return read(GET_ALL, new Object[] {});
	}

	// return null if not found
	public Passenger findById(int id) throws SQLException {
		return findById(GET_ONE, new Object[] {id});
	}
	
	@Override
	public List<Passenger> populateData(ResultSet resultSet) throws SQLException {
		List<Passenger> passengers = new ArrayList<Passenger>();
		
		while(resultSet.next()) {
			Passenger passenger = new Passenger();
			passenger.setId(resultSet.getInt("id"));
			passenger.setBookingId(resultSet.getInt("booking_id"));
			passenger.setGivenName(resultSet.getString("given_name"));
			passenger.setFamilyName(resultSet.getString("family_name"));
			passenger.setDateOfBirth(resultSet.getDate("dob"));
			passenger.setGender(resultSet.getString("gender"));
			passenger.setAddress(resultSet.getString("address"));
			
			passengers.add(passenger);
		}
		
		return passengers;
	}

	@Override
	public Passenger getOneElement(ResultSet resultSet) throws SQLException {
		Passenger passenger = null;
		
		while(resultSet.next()) {
			passenger = new Passenger();
			
			passenger.setId(resultSet.getInt("id"));
			passenger.setBookingId(resultSet.getInt("booking_id"));
			passenger.setGivenName(resultSet.getString("given_name"));
			passenger.setFamilyName(resultSet.getString("family_name"));
			passenger.setDateOfBirth(resultSet.getDate("dob"));
			passenger.setGender(resultSet.getString("gender"));
			passenger.setAddress(resultSet.getString("address"));
		}
		
		return passenger;
	}

}
