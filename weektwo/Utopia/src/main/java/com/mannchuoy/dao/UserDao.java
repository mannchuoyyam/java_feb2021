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

import com.mannchuoy.entity.User;

/**
 * @author Mannchuoy Yam
 *
 */
public class UserDao extends BaseDao<User> {
	
	final String INSERT_SQL = "INSERT INTO user(role_id, given_name, family_name, username, email, password, phone) "
							+ "VALUE(?, ?, ?, ?, ?, ?, ?)";

	final String UPDATE_SQL = "UPDATE user SET role_id = ?, given_name = ?, family_name + ?, "
							+ "username + ?, email = ?, password = ?, phone = ? WHERE id = ?";
	
	final String DELETE_SQL = "DELETE FROM user WHERE id = ?";
	
	final String GET_ONE = "SELECT * FROM user WHERE id = ?";
	
	final String GET_ALL = "SELECT * FROM user";
	
	public UserDao(Connection connection) {
		super(connection);
	}

	public Integer add(User user) throws SQLException {
		return addAndGetGeneratedKey(INSERT_SQL, new Object[] { user.getRoleId(), user.getGivenName(), user.getFamilyName(),
											user.getUsername(), user.getEmail(), user.getPassword(), user.getPhone()});
	}
	
	public int update(User user) throws SQLException{
		return update(UPDATE_SQL, new Object[] { user.getRoleId(), user.getGivenName(), user.getFamilyName(),
											user.getUsername(), user.getEmail(), user.getPassword(), user.getPhone(), user.getId()});
	}
	
	public int delete(User user) throws SQLException{
		return delete(DELETE_SQL, new Object[] {user.getId()});
	}
	
	public List<User> findAll() throws SQLException {
		return read(GET_ALL, new Object[] {});
	}

	// return null if not found
	public User findById(int id) throws SQLException {
		return findById(GET_ONE, new Object[] {id});
	}
	
	@Override
	public List<User> populateData(ResultSet resultSet) throws SQLException {
		List<User> users = new ArrayList<User>();
		
		while(resultSet.next()) {
			User user = new User();
			user.setId(resultSet.getInt("id"));
			user.setRoleId(resultSet.getInt("role_id"));
			user.setGivenName(resultSet.getString("given_name"));
			user.setFamilyName(resultSet.getString("family_name"));
			user.setUsername(resultSet.getString("username"));
			user.setEmail(resultSet.getString("email"));
			user.setPassword(resultSet.getString("password"));
			user.setPhone(resultSet.getString("phone"));
			
			users.add(user);
		}
		
		return users;
	}

	@Override
	public User getOneElement(ResultSet resultSet) throws SQLException {
		User user = null;
		
		while(resultSet.next()) {
			user = new User();
			user.setId(resultSet.getInt("id"));
			user.setRoleId(resultSet.getInt("role_id"));
			user.setGivenName(resultSet.getString("given_name"));
			user.setFamilyName(resultSet.getString("family_name"));
			user.setUsername(resultSet.getString("username"));
			user.setEmail(resultSet.getString("email"));
			user.setPassword(resultSet.getString("password"));
			user.setPhone(resultSet.getString("phone"));
	
			return user;
		}
		
		return user;
	}
	
}
