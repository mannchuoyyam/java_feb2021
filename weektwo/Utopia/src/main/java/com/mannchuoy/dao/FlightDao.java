/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mannchuoy.entity.Flight;


/**
 * @author Mannchuoy Yam
 *
 */
public class FlightDao extends BaseDao<Flight> {
	
	public FlightDao(Connection connection) {
		super(connection);
	}

	public boolean addFlight(Flight flight) throws SQLException {
		return add("INSERT INTO flight(id, route_id, airplane_id, departure_time, reserved_seats, seat_price)"
				+ " VALUES(?, ?, ?, ?, ?, ?)", 
				new Object[] {flight.getId(), flight.getRouteId(), flight.getPlaneId(), flight.getDepartureTime().toString(), 
						flight.getReservedSeats(), flight.getSeatPrice()});
	}
	
	public int updateFlight(Flight flight) throws SQLException{
		return update("UPDATE flight SET route_id = ?, airplane_id = ?, departure_time = ?,"
				+ " reserved_seats = ?, seat_price = ? WHERE id = ?",
				new Object[] {flight.getRouteId(), flight.getPlaneId(), flight.getDepartureTime().toString(),
						flight.getReservedSeats(), flight.getSeatPrice(), flight.getId()});
	}
	
	public int deleteFlight(Flight flight) throws SQLException{
		return delete("DELETE FROM flight WHERE id = ?",
				new Object[] {flight.getId()});
	}
	
	public List<Flight> retrieveFlight(Flight flight) throws SQLException{
		return read("SELECT * FROM flight WHERE id = ?", new Object[] {flight.getId()});
	}
	
	public List<Flight> listFlight() throws SQLException {
		return read("SELECT * FROM flight", new Object[] {});
	}

	@Override
	public List<Flight> populateData(ResultSet result) throws SQLException {
		List<Flight> flights = new ArrayList<Flight>();
		
		while(result.next()) {
			Flight flight = new Flight();
			flight.setId(result.getInt("id"));
			flight.setRouteId(result.getInt("route_id"));
			flight.setPlaneId(result.getInt("airplane_id"));
			Date date = result.getDate("departure_time");
			Time time = result.getTime("departure_time");
			flight.setDepartureTime(LocalDateTime.parse(date.toString() + "T" + time.toString()));
			flight.setReservedSeats(result.getInt("reserved_seats"));
			flight.setSeatPrice(result.getFloat("seat_price"));
			
			flights.add(flight);
		}
		
		return flights;
	}
}
