package com.mannchuoy.entity;

public class BookingPayment {
	private int bookingId;
	private String stripeId;
	private int refunded;
	private Booking booking;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getStripeId() {
		return stripeId;
	}
	public void setStripeId(String stripeId) {
		this.stripeId = stripeId;
	}
	public int getRefunded() {
		return refunded;
	}
	public void setRefunded(int refunded) {
		this.refunded = refunded;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
}
