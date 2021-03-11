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
import com.mannchuoy.dao.TicketDao;
import com.mannchuoy.entity.Ticket;

/**
 * @author Mannchuoy Yam
 *
 */
public class TicketService {
	
	public void add(Ticket ticket) throws SQLException {
		Connection connection = null;
		try {
			connection = DBConnection.getConnection(Boolean.FALSE);
			
			// check flight
			// check passenger
			TicketDao ticketDao = new TicketDao(connection);
			Integer id = ticketDao.add(ticket);

			connection.commit();
			Ticket newTicket = ticketDao.findById(id); 
			if(newTicket != null){
				System.out.println("\n" + newTicket + " has been added.\n");
			}
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		} finally {
			connection.close();
		}
	}
	
	public void update(Ticket ticket) throws SQLException {
		Connection connection = null;
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			TicketDao ticketDao = new TicketDao(connection);
			ticketDao.update(ticket);

			Ticket newTicket = ticketDao.findById(ticket.getId());
			if(newTicket != null){
				System.out.println("\n" + newTicket + " has been updated.\n");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
	}
	
	public void delete(Ticket ticket) throws SQLException {
		Connection connection = null;
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			TicketDao ticketDao = new TicketDao(connection);
			ticketDao.delete(ticket);

			if(ticketDao.findById(ticket.getId()) == null){
				System.out.println("\n" + ticket + " has been deleted.\n");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
	}
	
	public Ticket findById(int id) throws SQLException {
		Connection connection = null;
		Ticket ticket = null;
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			TicketDao ticketDao = new TicketDao(connection);
			ticket = ticketDao.findById(id);
			
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
		
		return ticket;
	}
	
	public List<Ticket> findByFlightId(int id) throws SQLException{
		List<Ticket> tickets = null;
		Connection connection = null;
		String sql = "SELECT * FROM ticket WHERE flight_id = ?";
		
		try {
			connection = DBConnection.getConnection(Boolean.TRUE);
			TicketDao ticketDao = new TicketDao(connection);
			tickets = ticketDao.read(sql, new Object[] { id });
			
		} catch (SQLException e) {
			throw e;
		} finally {
			connection.close();
		}
		return tickets;
	}
}
