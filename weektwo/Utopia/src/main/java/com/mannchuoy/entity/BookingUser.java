/**
 * 
 */
package com.mannchuoy.entity;

import java.util.List;

/**
 * @author mann
 *
 */
public class BookingUser {
	private int bookingId;
	private int userId;
	private User user;
	private List<Booking> bookings;
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
}
