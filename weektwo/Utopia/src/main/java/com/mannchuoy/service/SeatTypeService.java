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
import com.mannchuoy.dao.SeatTypeDao;
import com.mannchuoy.entity.SeatType;

/**
 * @author Mannchuoy Yam
 *
 */
public class SeatTypeService {

	public List<SeatType> findAll() throws SQLException{
		Connection connection = null;
		List<SeatType> seatTypes = null;
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			SeatTypeDao seatTypeDao = new SeatTypeDao(connection);
			seatTypes = seatTypeDao.findAll();
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
		
		return seatTypes;
	}
}
