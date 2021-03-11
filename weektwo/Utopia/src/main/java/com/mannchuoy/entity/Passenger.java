/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.entity;

import java.sql.Date;

/**
 * @author Mannchuoy Yam
 *
 */
public class Passenger {
	private int id;
	private int bookingId;
	private String givenName;
	private String familyName;
	private Date dateOfBirth;
	private String gender;
	private String address;
	private Booking booking;
		
	public Passenger() {
		
	}
	
	public Passenger(int id, int bookingId, String givenName, String familyName, Date dateOfBirth, String gender,
			String address) {
		this.id = id;
		this.bookingId = bookingId;
		this.givenName = givenName;
		this.familyName = familyName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getBookingId() {
		return bookingId;
	}
	
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	
	public String getGivenName() {
		return givenName;
	}
	
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Booking getBooking() {
		return booking;
	}
	
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", bookingId=" + bookingId + ", givenName=" + givenName + ", familyName="
				+ familyName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", address=" + address + "]";
	}
	
}
