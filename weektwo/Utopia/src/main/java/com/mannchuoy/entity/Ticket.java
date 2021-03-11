/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.entity;

/**
 * @author Mannchuoy Yam
 *
 */
public class Ticket {
	private int id;
	
	private int passengerId;
	
	private int flightId;
	
	private String seatNumber;
	
	public Ticket() {
		
	}

	public Ticket(int id, int passengerId, int flightId, String seatNumber) {
		super();
		this.id = id;
		this.passengerId = passengerId;
		this.flightId = flightId;
		this.seatNumber = seatNumber;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", passengerId=" + passengerId + ", flightId=" + flightId + ", seatNumber="
				+ seatNumber + "]";
	}
}
