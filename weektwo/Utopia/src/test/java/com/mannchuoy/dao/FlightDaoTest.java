/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.mannchuoy.entity.Flight;

/**
 * @author Mannchuoy Yam
 *
 */
public class FlightDaoTest {
	@Test
	public void addUpdateDeleteFlightTest() throws SQLException {
		Connection connection = DBConnection.getConnection(Boolean.TRUE);

		int id = 1;
		int planeId = 1;
		int reservedSeats = 50;
		int newReservedSeats = 100;
		int routeId = 2;
		float seatPrice = 100.0f;
		
		FlightDao flightDao = new FlightDao(connection);
		Flight flight = new Flight();
		flight.setId(id);
		flight.setDepartureTime(LocalDateTime.of(2021, 03, 6, 10, 30, 0));
		flight.setPlaneId(planeId);
		flight.setReservedSeats(reservedSeats);
		flight.setRouteId(routeId);
		flight.setSeatPrice(seatPrice);

		// add test false because it doesn't return the result set
		// if throw exception it will error
		assertEquals(false, flightDao.addFlight(flight));

		List<Flight> flights = flightDao.retrieveFlight(flight);
		assertNotEquals(0, flights.size());
		assertEquals(id, flights.get(0).getId());
		assertEquals(routeId, flights.get(0).getRouteId());

		// update test
		flight.setReservedSeats(newReservedSeats);
		assertEquals(1, flightDao.updateFlight(flight));

		// delete test
		// TODO: need to check another way to test because if it fails to delete, we cannot run the test again
		assertEquals(1, flightDao.deleteFlight(flight));
	}
}
