/**
 * 
 */
package com.mannchuoy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author mann
 *
 */
public abstract class BaseDao<T> {

	public Integer save(String sql, Object[] fields) throws SQLException{
		int rowsAffected = 0;
		Connection connection = null;
		connection = DBConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement(sql);
		int placeholder = 1;
		for (Object field : fields) {
			statement.setObject(placeholder, field);
			placeholder++;
		}

		rowsAffected = statement.executeUpdate();
		return rowsAffected;
	}
	
	public Integer update(String sql, Object[] fields) throws SQLException{
		return save(sql, fields);
	}
	
	public Integer delete(String sql, Object[] fields) throws SQLException{
		return save(sql, fields);
	}
	
	public List<T> read(String sql, Object[] fields) throws SQLException{
		Connection connection = null;
		connection = DBConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement(sql);
		int placeholder = 1;
		for (Object field : fields) {
			statement.setObject(placeholder, field);
			placeholder++;
		}

		return populateData(statement.executeQuery());
	}
	
	public abstract List<T> populateData(ResultSet result) throws SQLException;
}
