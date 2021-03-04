/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Implement Shape Interface
 *  Date: 2/23/21
 *  
 */
package com.ss.week.one.tuesday.shape;

/**
 * @author Mannchuoy Yam
 *
 */
public class Circle implements Shape {

	private final Float PI = 3.14f;
	private Double radius;
	
	public Circle(Double radius) {
		this.radius = radius;
	}
	
	@Override
	public Double calculatedArea() {
		return PI * radius * radius;
	}

	@Override
	public void display() {
		System.out.println("The circle has radius = " + radius + " and area = " + calculatedArea());
	}

}
