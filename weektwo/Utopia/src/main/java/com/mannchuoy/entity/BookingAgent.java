/**
 * 
 */
package com.mannchuoy.entity;

import java.util.List;

/**
 * @author Mannchuoy Yam
 *
 */
public class BookingAgent {
	private int bookingId;
	private int agentId;
	private User user;
	private List<Booking> bookings;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public List<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
}
