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

import com.mannchuoy.entity.AirplaneType;

/**
 * @author Mannchuoy Yam
 * 
 * Class AirplaneTypeDao: DAO for AirplaneType Object
 */
public class AirplaneTypeDao extends BaseDao<AirplaneType> {
	final static String GET_ONE = "SELECT * FROM airplane_type WHERE id = ?";
			
	public AirplaneTypeDao(Connection connection) {
		super(connection);
	}

	public int addAirplaneTypeAndGetPrimaryKey(AirplaneType airplaneType) throws SQLException {
		return addAndGetGeneratedKey("INSERT INTO airplane_type(max_capacity) VALUES(?)", new Object[] {airplaneType.getMaxCapacity()});
	}
	
	public int updateAirplaneType(AirplaneType airplaneType) throws SQLException{
		return update("UPDATE airplane_type SET max_capacity = ? WHERE id = ?",
				new Object[] {airplaneType.getMaxCapacity(), airplaneType.getId()});
	}
	
	public int deleteAirplaneType(AirplaneType airplaneType) throws SQLException{
		return delete("DELETE FROM airplane_type WHERE id = ?",
				new Object[] {airplaneType.getId()});
	}
	
	public List<AirplaneType> listAirplaneType() throws SQLException {
		return read("SELECT * FROM airplane_type", new Object[] {});
	}

	public List<AirplaneType> retrieveAirplaneTypeWith(int id) throws SQLException {
		return read("SELECT * FROM airplane_type WHERE id = ?", new Object[] {id});
	}
	
	public AirplaneType findAirplaneTypeById(int id) throws SQLException {
		return findById(GET_ONE, new Object[] {id});
	}
	
	@Override
	public List<AirplaneType> populateData(ResultSet result) throws SQLException {
		List<AirplaneType> airplaneTypes = new ArrayList<AirplaneType>();
		
		while(result.next()) {
			AirplaneType airplaneType = new AirplaneType();
			airplaneType.setId(result.getInt("id"));
			airplaneType.setMaxCapacity(result.getInt("max_capacity"));
			airplaneTypes.add(airplaneType);
		}
		
		return airplaneTypes;
	}

	@Override
	public AirplaneType getOneElement(ResultSet resultSet) throws SQLException {
		AirplaneType airplaneType = null;
		
		while(resultSet.next()) {
			airplaneType = new AirplaneType();
			airplaneType.setId(resultSet.getInt("id"));
			airplaneType.setMaxCapacity(resultSet.getInt("max_capacity"));
			
			return airplaneType;
		}
		
		return airplaneType;
	}
}