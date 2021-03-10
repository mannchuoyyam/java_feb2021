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
	private int flightId;
	
	private int numberOfFirstClass;
	
	private int numberOfBusinessClass;
	
	private int numberOfEconomyClass;

	public FlightSeat() {
		
	}
	
	public FlightSeat(int flightId, int numberOfFirstClass, int numberOfBusinessClass, int numberOfEconomyClass) {
		this.flightId = flightId;
		this.numberOfFirstClass = numberOfFirstClass;
		this.numberOfBusinessClass = numberOfBusinessClass;
		this.numberOfEconomyClass = numberOfEconomyClass;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getNumberOfFirstClass() {
		return numberOfFirstClass;
	}

	public void setNumberOfFirstClass(int numberOfFirstClass) {
		this.numberOfFirstClass = numberOfFirstClass;
	}

	public int getNumberOfBusinessClass() {
		return numberOfBusinessClass;
	}

	public void setNumberOfBusinessClass(int numberOfBusinessClass) {
		this.numberOfBusinessClass = numberOfBusinessClass;
	}

	public int getNumberOfEconomyClass() {
		return numberOfEconomyClass;
	}

	public void setNumberOfEconomyClass(int numberOfEconomyClass) {
		this.numberOfEconomyClass = numberOfEconomyClass;
	}

	@Override
	public String toString() {
		return "FlightSeat [flightId=" + flightId + ", numberOfFirstClass=" + numberOfFirstClass
				+ ", numberOfBusinessClass=" + numberOfBusinessClass + ", numberOfEconomyClass=" + numberOfEconomyClass
				+ "]";
	}

	
}
