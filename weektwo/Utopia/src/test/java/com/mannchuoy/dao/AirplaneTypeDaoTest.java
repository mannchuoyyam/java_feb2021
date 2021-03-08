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

import com.mannchuoy.entity.AirplaneType;

/**
 * @author Mannchuoy Yam
 *
 */
public class AirplaneTypeDaoTest {
	@Test
	public void addUpdateDeleteAirplaneTypeTest() throws SQLException {
		Connection connection = DBConnection.getConnection(Boolean.TRUE);
		
		AirplaneTypeDao airplaneTypeDao = new AirplaneTypeDao(connection);
		AirplaneType airplaneType = new AirplaneType();
		int maxCapacity = 500;
		int newMaxCapacity = 600;
		airplaneType.setId(0);
		airplaneType.setMaxCapacity(maxCapacity);
		
		// add test
		int id = airplaneTypeDao.addAirplaneTypeAndGetPrimaryKey(airplaneType);
		airplaneType.setId(id);
		
		List<AirplaneType> airplaneTypes = airplaneTypeDao.retrieveAirplaneTypeWith(id);
		
		assertNotEquals(0, airplaneTypes.size());
		assertEquals(maxCapacity, airplaneTypes.get(0).getMaxCapacity());
		
		airplaneType.setMaxCapacity(newMaxCapacity);
		
		// update test
		assertEquals(1, airplaneTypeDao.updateAirplaneType(airplaneType));
		
		// delete test
		assertEquals(1, airplaneTypeDao.deleteAirplaneType(airplaneType));
	}
}
