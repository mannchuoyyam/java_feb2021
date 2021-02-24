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
public class Rectangle implements Shape {

	private Integer width;
	private Integer height;
	
	public Rectangle(Integer width, Integer height) {
		setWidth(width);
		setHeight(height);
	}
	
	@Override
	public Double calculatedArea() {
		return (double) (width * height);
	}

	@Override
	public void display() {
		System.out.println("The rectangle has width = " + width + " ,height = " + height + " and area = " + calculatedArea());
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}
}
