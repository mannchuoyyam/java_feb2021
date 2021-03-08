/**
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
	
	public UserRoleDao(Connection connection) {
		super(connection);
	}

	public int addUserRole(UserRole userRole) throws SQLException {
		return save("INSERT INTO user_role(name) VALUES(?)", new Object[] {userRole.getName()});
	}
	
	public int updateAirport(UserRole userRole) throws SQLException{
		return update("UPDATE user_role SET name = ? WHERE id = ?",
				new Object[] {userRole.getName(), userRole.getId()});
	}
	
	public int deleteAirport(UserRole userRole) throws SQLException{
		return delete("DELETE FROM user_role WHERE id = ?",
				new Object[] {userRole.getId()});
	}
	
	public List<UserRole> listAirport() throws SQLException {
		return read("SELECT * FROM user_role", new Object[] {});
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
