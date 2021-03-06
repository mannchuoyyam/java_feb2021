/**
 * 
 */
package com.mannchuoy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mannchuoy.entity.Airport;

/**
 * @author Mannchuoy Yam
 *
 */
public class AirportDao extends BaseDao<Airport> {
	public int addAirport(Airport airport) throws SQLException {
		return save("INSERT INTO airport VALUES(?, ?)", new Object[] {airport.getId(), airport.getCity()});
	}
	
	public int updateAirport(Airport airport) throws SQLException{
		return update("UPDATE airport SET city = ? WHERE iata_id = ?",
				new Object[] {airport.getCity(), airport.getId()});
	}
	
	public int deleteAirport(Airport airport) throws SQLException{
		return delete("DELECT FROM airport WHERE iata_id = ?",
				new Object[] {airport.getCity()});
	}
	
	public List<Airport> listAirport() throws SQLException {
		return read("SELECT * FROM airport", new Object[] {});
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
}
