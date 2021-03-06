/**
 * 
 */
package com.mannchuoy.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.mannchuoy.entity.Airport;

/**
 * @author Mannchuoy Yam
 *
 */
public class AirportDaoTest {

	@Test
	public void addAirportTest() {
		AirportDao airportDao = new AirportDao();
		Airport airport = new Airport();
		airport.setId("LAX");
		airport.setCity("Los Angeles");
		
		try {
			assertEquals(1, airportDao.addAirport(airport));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
