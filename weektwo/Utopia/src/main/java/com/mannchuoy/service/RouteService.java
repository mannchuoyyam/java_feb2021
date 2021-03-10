/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.mannchuoy.dao.DBConnection;
import com.mannchuoy.dao.RouteDao;
import com.mannchuoy.entity.Route;

/**
 * @author Mannchuoy Yam
 *
 */
public class RouteService {

	public Route findById(int id) throws SQLException {
		Connection connection = null;
		Route route = null;
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			RouteDao routeDao = new RouteDao(connection);
			route = routeDao.findById(id);
			
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
		
		return route;
	}
}
