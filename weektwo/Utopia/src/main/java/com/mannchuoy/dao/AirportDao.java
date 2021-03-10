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

import com.mannchuoy.entity.Airport;

/**
 * @author Mannchuoy Yam
 * class AirportDao is DAO for airport table in the database
 */
public class AirportDao extends BaseDao<Airport> {
	
	final static String GET_ONE = "SELECT * FROM airport WHERE iata_id = ?";
	
	public AirportDao(Connection connection) {
		super(connection);
	}

	public boolean addAirport(Airport airport) throws SQLException {
		return add("INSERT INTO airport VALUES(?, ?)", new Object[] {airport.getId(), airport.getCity()});
	}
	
	public int updateAirport(Airport airport) throws SQLException{
		return update("UPDATE airport SET city = ? WHERE iata_id = ?",
				new Object[] {airport.getCity(), airport.getId()});
	}
	
	public int deleteAirport(Airport airport) throws SQLException{
		return delete("DELETE FROM airport WHERE iata_id = ?",
				new Object[] {airport.getId()});
	}
	
	public List<Airport> retrieveAirport(Airport airport) throws SQLException {
		return read("SELECT * FROM airport WHERE iata_id = ?", new Object[] {airport.getId()});
	}
	
	public List<Airport> listAirport() throws SQLException {
		return read("SELECT * FROM airport", new Object[] {});
	}
	
	public Airport findAirportById(String id) throws SQLException {
		return findById(GET_ONE, new Object[] {id});
	}
	
	public Airport findById(String id) throws SQLException {
		return findById(GET_ONE, new Object[] {id});
	}

	@Override
	public List<Airport> populateData(ResultSet result) throws SQLException {
		List<Airport> airports = new ArrayList<Airport>();
		
		while(result.next()) {
			Airport airport = new Airport();
			airport.setId(result.getString("iata_id"));
			airport.setCity(result.getString("city"));
			airports.add(airport);
		}
		
		return airports;
	}

	@Override
	public Airport getOneElement(ResultSet result) throws SQLException {
		Airport airport = null;
		
		while(result.next()) {
			airport = new Airport();
			airport.setId(result.getString("iata_id"));
			airport.setCity(result.getString("city"));
		}
		return airport;
	}
	
	
}
