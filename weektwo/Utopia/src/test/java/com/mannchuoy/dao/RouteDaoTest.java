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

import com.mannchuoy.entity.Route;

/**
 * @author Mannchuoy Yam
 *
 */
public class RouteDaoTest {
	@Test
	public void addUpdateDeleteRouteTest() throws SQLException {
		Connection connection = DBConnection.getConnection(Boolean.TRUE);

		String origin = "CIC";
		String destination = "JFK";
		String newDestination = "LAX";

		RouteDao routeDao = new RouteDao(connection);
		Route route = new Route();
		route.setOriginId(origin);
		route.setDestinationId(destination);

		int key = routeDao.addRouteAndGetPrimaryKey(route);
		route.setId(key);
		
		List<Route> routes = routeDao.retrieveAirplaneWith(route);
		
		assertNotEquals(0, routes.size());
		assertEquals(key, routes.get(0).getId());
		assertEquals(origin, routes.get(0).getOriginId());
		assertEquals(destination, routes.get(0).getDestinationId());

		// update test
		route.setDestinationId(newDestination);
		assertEquals(1, routeDao.updateRoute(route));

		// delete test
		// TODO: need to check another way to test because if it fails to delete, we cannot run the test again
		assertEquals(1, routeDao.deleteRoute(route));
	}
}
