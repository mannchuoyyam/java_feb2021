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
import com.mannchuoy.dao.UserRoleDao;
import com.mannchuoy.entity.UserRole;

/**
 * @author Mannchuoy Yam
 *
 */
public class UserRoleService {

	public List<UserRole> findAll() throws SQLException{
		Connection connection = null;
		List<UserRole> userRoles = null;
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			UserRoleDao userRoleDao = new UserRoleDao(connection);
			userRoles = userRoleDao.findAll();
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
		
		return userRoles;
	}
}
