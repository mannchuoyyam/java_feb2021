/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Implement Shape Interface
 *  Date: 2/23/21
 *  
 */
package com.ss.week.one.tuesday.shape;

/**
 * @author Mannchuoy Yam
 */
public class Triangle implements Shape {

	private Integer base;
	private Integer height;
	
	public Triangle(Integer base, Integer height) {
		setBase(base);
		setHeight(height);
	}
	
	@Override
	public Double calculatedArea() {
		return base * height / 2.0;
	}

	@Override
	public void display() {
		System.out.println("The triangle has base = " + base + " ,height = " + height + " and the area = " + calculatedArea());

	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getBase() {
		return base;
	}

	public void setBase(Integer base) {
		this.base = base;
	}

}
