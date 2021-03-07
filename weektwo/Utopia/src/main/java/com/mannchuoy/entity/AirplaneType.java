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
 *
 * Class AirplaneType represent airplane_type table in Utopia database
 */
public class AirplaneType {
	private int id;
	private int maxCapacity;
	private List<Airplane> airplanes;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getMaxCapacity() {
		return maxCapacity;
	}
	
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	
	public List<Airplane> getAirplanes() {
		return airplanes;
	}
	
	public void setAirplanes(List<Airplane> airplanes) {
		this.airplanes = airplanes;
	}
}
