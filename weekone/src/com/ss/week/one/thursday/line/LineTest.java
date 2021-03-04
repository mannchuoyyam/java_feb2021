/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Line Unit Testing
 *  Date: 2/25/21
 *  
 */
package com.ss.week.one.thursday.line;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

/**
 * @author Mannchuoy Yam
 *
 */
public class LineTest {
	private final Double ERROR_TOLERANCE = 0.0001;
	Line lineA = new Line(1, 2, 3, 4);
	Line lineB = new Line(2, 2, 5, 5);
	Line lineC = new Line(1, 2, 1, 5);
	Line lineD = new Line(3, 0, 5, 8);
	@Test
	public void calculateSlopeTest() {
		assertEquals(1.0, lineA.calculateSlope(), ERROR_TOLERANCE);
		assertNotEquals(1.2, lineA.calculateSlope(), ERROR_TOLERANCE);
		assertThrows(ArithmeticException.class, () -> {lineC.calculateSlope();});
	}
	
	@Test
	public void calculateDistanceTest() {
		assertEquals(2.8284, lineA.calculateDistance(), ERROR_TOLERANCE);
		assertNotEquals(2.829, lineA.calculateDistance(), ERROR_TOLERANCE);
	}
	
	@Test
	public void paralletloTest() {
		assertEquals(true, lineA.parallelTo(lineB));
		assertNotEquals(false, lineA.parallelTo(lineB));
		assertEquals(false, lineA.parallelTo(lineD));
		assertNotEquals(true, lineA.parallelTo(lineD));
	}
}
