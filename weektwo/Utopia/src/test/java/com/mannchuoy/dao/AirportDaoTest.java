/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.mannchuoy.entity.Airport;

/**
 * @author Mannchuoy Yam
 *
 */
public class AirportDaoTest {

	@Test
	public void addUpdateDeleteAirportTest() throws SQLException {
		Connection connection = DBConnection.getConnection(Boolean.TRUE);

		String id = "CLE";
		String city = "Chico, CA";
		String newCity = "Cleveland, OH";

		AirportDao airportDao = new AirportDao(connection);
		Airport airport = new Airport();
		airport.setId(id);
		airport.setCity(city);

		// add test false because it doesn't return the result set
		// if throw exception it will error
		assertEquals(false, airportDao.addAirport(airport));

		List<Airport> airports = airportDao.retrieveAirport(airport);
		assertNotEquals(0, airports.size());
		assertEquals(id, airports.get(0).getId());
		assertEquals(city, airports.get(0).getCity());

		// update test
		airport.setCity(newCity);
		assertEquals(1, airportDao.updateAirport(airport));

		// delete test
		// TODO: need to check another way to test because if it fails to delete, we cannot run the test again
		assertEquals(1, airportDao.deleteAirport(airport));
	}
}
