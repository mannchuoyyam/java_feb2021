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

}
