/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.entity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Mannchuoy Yam
 * class Flight represents flight table in the database
 */
public class Flight {
	private int id;
	private int routeId;
	private int planeId;
	private LocalDateTime departureTime;
	private int reservedSeats;
	private float seatPrice;
	private Route route;
	private List<FlightBooking> flightBookings;
	
	public Flight() {
		
	}
	
	public Flight(int id, int planeId, LocalDateTime departureTime, int reservedSeats, float seatPrice) {
		this.id = id;
		this.planeId = planeId;
		this.departureTime = departureTime;
		this.reservedSeats = reservedSeats;
		this.seatPrice = seatPrice;
	}
	
	public List<FlightBooking> getFlightBookings() {
		return flightBookings;
	}
	
	public void setFlightBookings(List<FlightBooking> flightBookings) {
		this.flightBookings = flightBookings;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getRouteId() {
		return routeId;
	}
	
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	
	public int getPlaneId() {
		return planeId;
	}
	
	public void setPlaneId(int planeId) {
		this.planeId = planeId;
	}
	
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	
	public int getReservedSeats() {
		return reservedSeats;
	}
	
	public void setReservedSeats(int reservedSeats) {
		this.reservedSeats = reservedSeats;
	}
	
	public float getSeatPrice() {
		return seatPrice;
	}
	
	public void setSeatPrice(float seatPrice) {
		this.seatPrice = seatPrice;
	}
	
	public Route getRoute() {
		return route;
	}
	
	public void setRoute(Route route) {
		this.route = route;
	}
}
