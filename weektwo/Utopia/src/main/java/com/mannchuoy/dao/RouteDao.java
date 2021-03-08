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

import com.mannchuoy.entity.Route;

/**
 * @author Mannchuoy Yam
 *
 */
public class RouteDao extends BaseDao<Route> {
	public RouteDao(Connection connection) {
		super(connection);
	}

	public int addRoute(Route route) throws SQLException {
		return save("INSERT INTO route(origin_id, destination_id) VALUES(?, ?)", new Object[] {route.getOriginId(), route.getDestinationId()});
	}
	
	public Integer addRouteAndGetPrimaryKey(Route route) throws SQLException{
		return addAndGetGeneratedKey("INSERT INTO route(origin_id, destination_id) VALUES(?, ?)", new Object[] {route.getOriginId(), route.getDestinationId()});
	}
	
	public int updateRoute(Route route) throws SQLException{
		return update("UPDATE route SET origin_id = ?, destination_id = ? WHERE id = ?",
				new Object[] {route.getOriginId(), route.getDestinationId(), route.getId()});
	}
	
	public int deleteRoute(Route route) throws SQLException{
		return delete("DELETE FROM route WHERE id = ?",
				new Object[] {route.getId()});
	}
	
	public List<Route> listRoute() throws SQLException {
		return read("SELECT * FROM route", new Object[] {});
	}

	public List<Route> retrieveAirplaneWith(Route route) throws SQLException {
		return read("SELECT * FROM route WHERE id = ? AND origin_id = ? AND destination_id = ? ", 
				new Object[] {route.getId(), route.getOriginId(), route.getDestinationId()});
	}
	
	public Route getRouteById(int id) throws SQLException{
		List<Route> routes = read("SELECT * FROM route WHERE id = ?", 
				new Object[] { id });
		if(routes.size() != 0) {
			return routes.get(0);
		}
		return null;
	}
	
	@Override
	public List<Route> populateData(ResultSet result) throws SQLException {
		List<Route> routes = new ArrayList<Route>();
		
		while(result.next()) {
			Route route = new Route();
			route.setId(result.getInt("id"));
			route.setOriginId(result.getString("origin_id"));
			route.setDestinationId(result.getString("destination_id"));
			routes.add(route);
		}
		
		return routes;
	}
}