/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.entity;

import java.util.List;

/**
 * @author Mannchuoy Yam
 * class Route represents route table in the database
 */
public class Route {
	private int id;
	private String originId;
	private String destinationId;
	private Airport origin;
	private Airport destination;
	private List<Flight> flights;
	
	public Airport getOrigin() {
		return origin;
	}

	public void setOrigin(Airport origin) {
		this.origin = origin;
	}

	public Airport getDestination() {
		return destination;
	}

	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getOriginId() {
		return originId;
	}
	
	public void setOriginId(String originId) {
		this.originId = originId;
	}
	
	public String getDestinationId() {
		return destinationId;
	}
	
	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}
	
	public List<Flight> getFlights() {
		return flights;
	}
	
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
}
