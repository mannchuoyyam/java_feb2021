/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Write Unit Test for class Line
 *  Date: 2/25/21
 *  
 */
package com.ss.week.one.thursday.line;

/**
 * @author Mannchuoy Yam
 *
 */
public class Line {
	private double x0, y0, x1, y1;
	private final Double ERROR_TOLERANCE = 0.0001;
	
	public Line(double x0, double y0, double x1, double y1) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
	}

	public double calculateSlope() {
		if (x1 == x0) {
			throw new ArithmeticException();
		}

		return (y1 - y0) / (x1 - x0);
	}

	public double calculateDistance() {
		return Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));
	}
	
	public boolean parallelTo(Line l) {
		if(Math.abs(calculateSlope() - l.calculateSlope()) < ERROR_TOLERANCE) {
			return true;
		}
		return false;
	}
}
