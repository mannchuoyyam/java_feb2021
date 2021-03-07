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

import com.mannchuoy.entity.Airplane;

/**
 * @author Mannchuoy Yam
 * class AirplaneDao is DAO for airplane table
 */
public class AirplaneDao extends BaseDao<Airplane> {
	public AirplaneDao(Connection connection) {
		super(connection);
	}

	public int addAirplaneAndGetPrimaryKey(Airplane airplane) throws SQLException {
		return addAndGetGeneratedKey("INSERT INTO airplane(type_id) VALUES(?)", new Object[] {airplane.getTypeId()});
	}
	
	public int updateAirplane(Airplane airplane) throws SQLException{
		return update("UPDATE airplane SET type_id = ? WHERE id = ?",
				new Object[] {airplane.getTypeId(), airplane.getId()});
	}
	
	public int deleteAirplane(Airplane airplane) throws SQLException{
		return delete("DELETE FROM airplane WHERE id = ?",
				new Object[] {airplane.getId()});
	}
	
	public List<Airplane> listAirplane() throws SQLException {
		return read("SELECT * FROM airplane", new Object[] {});
	}

	public List<Airplane> retrieveAirplaneWith(int id) throws SQLException {
		return read("SELECT * FROM airplane WHERE id = ?", new Object[] {id});
	}
	
	@Override
	public List<Airplane> populateData(ResultSet result) throws SQLException {
		List<Airplane> airplanes = new ArrayList<Airplane>();
		
		while(result.next()) {
			Airplane airplane = new Airplane();
			airplane.setId(result.getInt("id"));
			airplane.setTypeId(result.getInt("type_id"));
			airplanes.add(airplane);
		}
		
		return airplanes;
	}
}