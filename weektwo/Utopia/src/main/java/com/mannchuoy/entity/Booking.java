package com.mannchuoy.entity;

import java.util.List;

public class Booking {
	private int id;
	private Boolean isActive;
	private String confirmationCode;
	private BookingPayment bookingPayment;
	private BookingAgent bookingAgent;
	private BookingUser bookingUser;
	private BookingGuest bookingGuest;
	private List<FlightBooking> flightBookings;
	private List<Passenger> passengers;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getConfirmationCode() {
		return confirmationCode;
	}
	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}
	public BookingPayment getBookingPayment() {
		return bookingPayment;
	}
	public void setBookingPayment(BookingPayment bookingPayment) {
		this.bookingPayment = bookingPayment;
	}
	public BookingAgent getBookingAgent() {
		return bookingAgent;
	}
	public void setBookingAgent(BookingAgent bookingAgent) {
		this.bookingAgent = bookingAgent;
	}
	public BookingUser getBookingUser() {
		return bookingUser;
	}
	public void setBookingUser(BookingUser bookingUser) {
		this.bookingUser = bookingUser;
	}
	public BookingGuest getBookingGuest() {
		return bookingGuest;
	}
	public void setBookingGuest(BookingGuest bookingGuest) {
		this.bookingGuest = bookingGuest;
	}
	public List<FlightBooking> getFlightBookings() {
		return flightBookings;
	}
	public void setFlightBookings(List<FlightBooking> flightBookings) {
		this.flightBookings = flightBookings;
	}
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
}
