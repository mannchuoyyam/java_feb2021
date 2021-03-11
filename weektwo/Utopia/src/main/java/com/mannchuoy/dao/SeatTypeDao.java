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

import com.mannchuoy.entity.SeatType;


/**
 * @author Mannchuoy Yam
 *
 */
public class SeatTypeDao extends BaseDao<SeatType>{
	final String INSERT_SQL = "INSERT INTO seat_type(seat_class) VALUE(?)";
	final String UPDATE_SQL = "UPDATE seat_type SET seat_class = ? WHERE id = ?";
	final String DELETE_SQL = "DELETE FROM seat_type WHERE id = ?";
	final String GET_ONE = "SELECT * FROM seat_type WHERE id = ?";
	final String GET_ALL = "SELECT * FROM seat_type";
	
	public SeatTypeDao(Connection connection) {
		super(connection);
	}

	public Integer add(SeatType seatType) throws SQLException {
		return addAndGetGeneratedKey(INSERT_SQL, new Object[] { seatType.getSeatClass() });
	}
	
	public int update(SeatType seatType) throws SQLException{
		return update(UPDATE_SQL, new Object[] { seatType.getSeatClass(), seatType.getId()});
	}
	
	public int delete(SeatType seatType) throws SQLException{
		return delete(DELETE_SQL, new Object[] { seatType.getId() });
	}
	
	public List<SeatType> findAll() throws SQLException {
		return read(GET_ALL, new Object[] {});
	}

	// return null if not found
	public SeatType findById(int id) throws SQLException {
		return findById(GET_ONE, new Object[] {id});
	}
	
	@Override
	public List<SeatType> populateData(ResultSet resultSet) throws SQLException {
		List<SeatType> seatTypes = new ArrayList<SeatType>();
		
		while(resultSet.next()) {
			SeatType seatType = new SeatType();
			seatType.setId(resultSet.getInt("id"));
			seatType.setSeatClass(resultSet.getString("seat_class"));
			
			seatTypes.add(seatType);
		}
		
		return seatTypes;
	}

	@Override
	public SeatType getOneElement(ResultSet resultSet) throws SQLException {
		SeatType seatType = null;
		
		while(resultSet.next()) {
			seatType = new SeatType();
			seatType.setId(resultSet.getInt("id"));
			seatType.setSeatClass(resultSet.getString("seat_class"));
		}
		
		return seatType;
	}

}
