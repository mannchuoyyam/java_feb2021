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
public class SeatType {
	private int id;
	
	private String seatClass;

	public SeatType() {
		
	}
	
	public SeatType(int id, String seatClass) {
		this.id = id;
		this.seatClass = seatClass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	@Override
	public String toString() {
		return "SeatType [id=" + id + ", seatClass=" + seatClass + "]";
	}
}
