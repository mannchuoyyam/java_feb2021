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

import com.mannchuoy.entity.UserRole;

/**
 * @author Mannchuoy Yam
 *
 */
public class UserRoleDao extends BaseDao<UserRole> {
	
	final String INSERT_SQL = "INSERT INTO user_role(name) VALUE(?)";
	final String UPDATE_SQL = "UPDATE user_role SET name = ? WHERE id = ?";
	final String DELETE_SQL = "DELETE FROM user_role WHERE id = ?";
	final String GET_ONE = "SELECT * FROM user_role WHERE id = ?";
	final String GET_ALL = "SELECT * FROM user_role";
	
	public UserRoleDao(Connection connection) {
		super(connection);
	}

	public int add(UserRole userRole) throws SQLException {
		return save(INSERT_SQL, new Object[] {userRole.getName()});
	}
	
	public int update(UserRole userRole) throws SQLException{
		return update(UPDATE_SQL, new Object[] {userRole.getName(), userRole.getId()});
	}
	
	public int delete(UserRole userRole) throws SQLException{
		return delete(DELETE_SQL, new Object[] {userRole.getId()});
	}
	
	public List<UserRole> findAll() throws SQLException {
		return read(GET_ALL, new Object[] {});
	}

	// return null if not found
	public UserRole findById(int id) throws SQLException {
		return findById(GET_ONE, new Object[] {id});
	}
	
	@Override
	public List<UserRole> populateData(ResultSet result) throws SQLException {
		List<UserRole> userRoles = new ArrayList<UserRole>();
		
		while(result.next()) {
			UserRole userRole = new UserRole();
			userRole.setId(result.getInt("id"));
			userRole.setName(result.getString("name"));
			userRoles.add(userRole);
		}
		
		return userRoles;
	}

	@Override
	public UserRole getOneElement(ResultSet result) throws SQLException {
		UserRole userRole = null;
		
		while(result.next()) {
			userRole = new UserRole();
			userRole.setId(result.getInt("id"));
			userRole.setName(result.getString("name"));
	
			return userRole;
		}
		
		return userRole;
	}
	
}
