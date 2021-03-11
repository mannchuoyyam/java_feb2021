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
	final String INSERT_SQL = "INSERT INTO flight_seat(flight_id, seat_number, seat_type, available) VALUES(?, ?, ?, ?)";
	final String UPDATE_SQL = "UPDATE flight_seat SET flight_id = ?, seat_number = ?, seat_type = ?, available = ? WHERE id = ?";
	final String DELETE_SQL = "DELETE FROM flight_seat WHERE id = ?";
	final String GET_ONE = "SELECT * FROM flight_seat WHERE id = ?";
	final String GET_ALL = "SELECT * FROM flight_seat";
	
	public FlightSeatDao(Connection connection) {
		super(connection);
	}

	public Integer add(FlightSeat flightSeat) throws SQLException {
		return addAndGetGeneratedKey(INSERT_SQL, new Object[] {flightSeat.getFlightId(), flightSeat.getSeatNumber(),
											flightSeat.getSeatType(), flightSeat.getAvailable()});
	}
	
	public int update(FlightSeat flightSeat) throws SQLException{
		return update(UPDATE_SQL, new Object[] { flightSeat.getFlightId(), flightSeat.getSeatNumber(),
				flightSeat.getSeatType(), flightSeat.getAvailable(), flightSeat.getId()});
	}
	
	public int delete(FlightSeat flightSeat) throws SQLException{
		return delete(DELETE_SQL, new Object[] { flightSeat.getId() });
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
			flightSeat.setId(resultSet.getInt("id"));
			flightSeat.setSeatNumber(resultSet.getString("seat_number"));
			flightSeat.setSeatType(resultSet.getInt("seat_type"));
			flightSeat.setAvailable(resultSet.getBoolean("available"));
			
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
			flightSeat.setId(resultSet.getInt("id"));
			flightSeat.setSeatNumber(resultSet.getString("seat_number"));
			flightSeat.setSeatType(resultSet.getInt("seat_type"));
			flightSeat.setAvailable(resultSet.getBoolean("available"));
		}
		
		return flightSeat;
	}

}
