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
public class FlightSeat {
	private int id;

	private int flightId;
	
	private String seatNumber;
	
	private int seatType;
	
	private boolean available;

	public FlightSeat() {
		
	}

	public FlightSeat(int id, int flightId, String seatNumber, int seatType, boolean available) {
		this.id = id;
		this.flightId = flightId;
		this.seatNumber = seatNumber;
		this.seatType = seatType;
		this.available = available;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getSeatType() {
		return seatType;
	}

	public void setSeatType(int seatType) {
		this.seatType = seatType;
	}

	public boolean getAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "FlightSeat [flightId = " + flightId + ", seatNumber = " + seatNumber + ", seatType = " + seatType
				+ ", available = " + (available ? "Yes" : "No") + "]";
	}
	
}
