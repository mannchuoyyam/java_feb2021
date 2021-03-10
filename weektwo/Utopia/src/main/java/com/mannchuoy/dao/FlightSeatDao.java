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

import com.mannchuoy.entity.FlightSeat;


/**
 * @author Mannchuoy Yam
 *
 */
public class FlightSeatDao extends BaseDao<FlightSeat>{
	final String INSERT_SQL = "INSERT INTO flight_seat(flight_id, first, business, economy) VALUES(?, ?, ?, ?)";
	final String UPDATE_SQL = "UPDATE flight_seat SET first = ?, business = ?, economy = ?, WHERE flight_id = ?";
	final String DELETE_SQL = "DELETE FROM flight_seat WHERE flight_id = ?";
	final String GET_ONE = "SELECT * FROM flight_seat WHERE flight_id = ?";
	final String GET_ALL = "SELECT * FROM flight_seat";
	
	public FlightSeatDao(Connection connection) {
		super(connection);
	}

	public int add(FlightSeat flightSeat) throws SQLException {
		return save(INSERT_SQL, new Object[] {flightSeat.getFlightId(), flightSeat.getNumberOfFirstClass(),
											flightSeat.getNumberOfBusinessClass(), flightSeat.getNumberOfEconomyClass()});
	}
	
	public int update(FlightSeat flightSeat) throws SQLException{
		return update(UPDATE_SQL, new Object[] { flightSeat.getNumberOfFirstClass(),
				flightSeat.getNumberOfBusinessClass(), flightSeat.getNumberOfEconomyClass(), flightSeat.getFlightId()});
	}
	
	public int delete(FlightSeat flightSeat) throws SQLException{
		return delete(DELETE_SQL, new Object[] { flightSeat.getFlightId() });
	}
	
	public List<FlightSeat> findAll() throws SQLException {
		return read(GET_ALL, new Object[] {});
	}

	// return null if not found
	public FlightSeat findById(int id) throws SQLException {
		return findById(GET_ONE, new Object[] {id});
	}
	
	@Override
	public List<FlightSeat> populateData(ResultSet resultSet) throws SQLException {
		List<FlightSeat> flightSeats = new ArrayList<FlightSeat>();
		
		while(resultSet.next()) {
			FlightSeat flightSeat = new FlightSeat();
			flightSeat.setFlightId(resultSet.getInt("flight_id"));
			flightSeat.setNumberOfFirstClass(resultSet.getInt("first"));
			flightSeat.setNumberOfBusinessClass(resultSet.getInt("business"));
			flightSeat.setNumberOfEconomyClass(resultSet.getInt("economy"));
			
			flightSeats.add(flightSeat);
		}
		
		return flightSeats;
	}

	@Override
	public FlightSeat getOneElement(ResultSet resultSet) throws SQLException {
		FlightSeat flightSeat = null;
		
		while(resultSet.next()) {
			flightSeat = new FlightSeat();
			
			flightSeat.setFlightId(resultSet.getInt("flight_id"));
			flightSeat.setNumberOfFirstClass(resultSet.getInt("first"));
			flightSeat.setNumberOfBusinessClass(resultSet.getInt("business"));
			flightSeat.setNumberOfEconomyClass(resultSet.getInt("economy"));
		}
		
		return flightSeat;
	}

}
