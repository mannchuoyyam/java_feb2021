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

import com.mannchuoy.entity.Airplane;

/**
 * @author Mannchuoy Yam
 *
 */
public class AirplaneDaoTest {
	@Test
	public void addUpdateDeleteAirplaneTypeTest() throws SQLException {
		Connection connection = DBConnection.getConnection(Boolean.TRUE);

		AirplaneDao airplaneDao = new AirplaneDao(connection);
		Airplane airplane = new Airplane();

		int typeId = 2;
		int newTypeId = 1;
		airplane.setId(0);
		airplane.setTypeId(typeId);		

		// add test
		int id = airplaneDao.addAirplaneAndGetPrimaryKey(airplane);
		airplane.setId(id);

		List<Airplane> airplanes = airplaneDao.retrieveAirplaneWith(id);

		assertNotEquals(0, airplanes.size());
		assertEquals(typeId, airplanes.get(0).getTypeId());

		airplane.setTypeId(newTypeId);

		// update test
		assertEquals(1, airplaneDao.updateAirplane(airplane));

		// delete test
		assertEquals(1, airplaneDao.deleteAirplane(airplane));
	}
}
