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

import com.mannchuoy.entity.Ticket;


/**
 * @author Mannchuoy Yam
 *
 */
public class TicketDao extends BaseDao<Ticket>{
	final String INSERT_SQL = "INSERT INTO ticket(flight_id, passenger_id, seat_number) VALUES(?, ?, ?)";
	final String UPDATE_SQL = "UPDATE ticket SET flight_id = ?, passenger_id = ?, seat_number = ? WHERE id = ?";
	final String DELETE_SQL = "DELETE FROM ticket WHERE id = ?";
	final String GET_ONE = "SELECT * FROM ticket WHERE id = ?";
	final String GET_ALL = "SELECT * FROM ticket";
	
	public TicketDao(Connection connection) {
		super(connection);
	}

	public Integer add(Ticket ticket) throws SQLException {
		return addAndGetGeneratedKey(INSERT_SQL, new Object[] {ticket.getFlightId(), ticket.getPassengerId(), ticket.getSeatNumber()});
	}
	
	public int update(Ticket ticket) throws SQLException{
		return update(UPDATE_SQL, new Object[] { ticket.getFlightId(), ticket.getPassengerId(), ticket.getSeatNumber(), ticket.getId()});
	}
	
	public int delete(Ticket ticket) throws SQLException{
		return delete(DELETE_SQL, new Object[] { ticket.getId() });
	}
	
	public List<Ticket> findAll() throws SQLException {
		return read(GET_ALL, new Object[] {});
	}

	// return null if not found
	public Ticket findById(int id) throws SQLException {
		return findById(GET_ONE, new Object[] {id});
	}
	
	@Override
	public List<Ticket> populateData(ResultSet resultSet) throws SQLException {
		List<Ticket> tickets = new ArrayList<Ticket>();
		
		while(resultSet.next()) {
			Ticket ticket = new Ticket();
			ticket.setId(resultSet.getInt("id"));
			ticket.setFlightId(resultSet.getInt("flight_id"));
			ticket.setPassengerId(resultSet.getInt("passenger_id"));
			ticket.setSeatNumber(resultSet.getString("seat_number"));
			
			tickets.add(ticket);
		}
		
		return tickets;
	}

	@Override
	public Ticket getOneElement(ResultSet resultSet) throws SQLException {
		Ticket ticket = null;
		
		while(resultSet.next()) {
			ticket = new Ticket();
			ticket.setId(resultSet.getInt("id"));
			ticket.setFlightId(resultSet.getInt("flight_id"));
			ticket.setPassengerId(resultSet.getInt("passenger_id"));
			ticket.setSeatNumber(resultSet.getString("seat_number"));
		}
		
		return ticket;
	}
}
