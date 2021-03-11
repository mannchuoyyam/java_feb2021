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
import java.util.List;

import com.mannchuoy.dao.DBConnection;
import com.mannchuoy.dao.UserDao;
import com.mannchuoy.entity.User;

/**
 * @author Mannchuoy Yam
 *
 */
public class EmployeeService {
	
	public void add(User user) throws SQLException {
		Connection connection = null;
		try {
			connection = DBConnection.getConnection(Boolean.FALSE);
			UserDao userDao = new UserDao(connection);
			
			Integer id = userDao.add(user);
			
			connection.commit();
			
			User newUser = userDao.findById(id); 
			if(newUser != null){
				System.out.println("\n" + newUser + " has been added.\n");
			}
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		} finally {
			connection.close();
		}
	}
	
	public void update(User user) throws SQLException {
		Connection connection = null;
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			UserDao userDao = new UserDao(connection);
			userDao.update(user);

			if(userDao.findById(user.getId()) != null){
				System.out.println("\n" + user + " has been updated.\n");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
	}
	
	public void delete(User user) throws SQLException {
		Connection connection = null;
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			UserDao userDao = new UserDao(connection);
			userDao.delete(user);

			if(userDao.findById(user.getId()) == null){
				System.out.println("\n" + user + " has been deleted.\n");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
	}
	
	public User findById(int id) throws SQLException {
		Connection connection = null;
		User user = null;
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			UserDao userDao = new UserDao(connection);
			user = userDao.findById(id);
			
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
		
		return user;
	}
	
	public List<User> findAll() throws SQLException{
		Connection connection = null;
		List<User> users = null;
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			UserDao userDao = new UserDao(connection);
			users = userDao.findAll();
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
		
		return users;
	}
}
