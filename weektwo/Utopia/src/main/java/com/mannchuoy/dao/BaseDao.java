/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author Mannchuoy Yam
 *
 */
public abstract class BaseDao<T> {

	private Connection connection;
	
	protected BaseDao(Connection connection){
		this.connection = connection;
	}
	
	private PreparedStatement getPreparedStatement(String sql, Object[] fields) throws SQLException{
		PreparedStatement statement = connection.prepareStatement(sql);
		int placeholder = 1;
		for (Object field : fields) {
			statement.setObject(placeholder, field);
			placeholder++;
		}
		return statement;
	}
	
	public Integer save(String sql, Object[] fields) throws SQLException{
		int rowsAffected = 0;
		
		PreparedStatement statement = getPreparedStatement(sql, fields);

		rowsAffected = statement.executeUpdate();
		return rowsAffected;
	}
	
	public boolean add(String sql, Object[] fields) throws SQLException{
		PreparedStatement statement = getPreparedStatement(sql, fields);
		return statement.execute();
	}
	
	/* use for INSERT, UPDATE, DELETE statement
	 * @return number of affected rows
	 */
	public Integer addWithExecuteUpdate(String sql, Object[] fields) throws SQLException{
		PreparedStatement statement = getPreparedStatement(sql, fields);
		return statement.executeUpdate();
	}
	
	public Integer addAndGetGeneratedKey(String sql, Object[] fields) throws SQLException{
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		int placeholder = 1;
		for(Object field: fields) {
			statement.setObject(placeholder, field);
			placeholder++;
		}
		statement.execute();
		ResultSet resultSet = statement.getGeneratedKeys();
		while(resultSet.next()) {
			return resultSet.getInt(1);
		}
		
		return null;
	}
	
	public Integer update(String sql, Object[] fields) throws SQLException{
		return addWithExecuteUpdate(sql, fields);
	}
	
	public Integer delete(String sql, Object[] fields) throws SQLException{
		return addWithExecuteUpdate(sql, fields);
	}
	
	public List<T> read(String sql, Object[] fields) throws SQLException{
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
