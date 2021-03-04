/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment 5: Selection Sum Test
 *  Date: 2/27/21 and 2/28/21 
 *  
 */
package com.ss.week.one.unittest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.ss.week.one.weekend.assignment.five.SelectionSum;

/**
 * @author Mannchuoy Yam
 *
 */
public class SelectionSumTest {
	SelectionSum selectionSum = new SelectionSum();
	
	@Test
	public void groupSumClumTest() {
		List<Integer> inputs = Arrays.asList(2, 4, 8);
	
		Integer sum = 0;
		
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 2));
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 4));
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 8));
		
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 6));
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 12));
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 14));
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 10));
		
		assertEquals(false, selectionSum.groupSumClump(sum, inputs, 3));
		assertEquals(false, selectionSum.groupSumClump(sum, inputs, 13));
		assertEquals(false, selectionSum.groupSumClump(sum, inputs, 11));
	}
	
	@Test
	public void groupSumClumTest2() {
		List<Integer> inputs = Arrays.asList(1, 2, 4, 8, 1);
	
		Integer sum = 0;
		
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 1));
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 2));
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 4));
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 8));
		
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 3));
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 7));
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 11));
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 14));
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 15));
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 16));
	}
	
	@Test
	public void groupSumClumTest3() {
		List<Integer> inputs = Arrays.asList(2, 2, 4, 4, 8);
	
		Integer sum = 0;
		
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 4));
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 12));
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 20));
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 16));
		assertEquals(false, selectionSum.groupSumClump(sum, inputs, 18));
		assertEquals(false, selectionSum.groupSumClump(sum, inputs, 14));

	}
	
	@Test
	public void groupSumClumTest4() {
		List<Integer> inputs = Arrays.asList(3, 3, 7, 7, 11);
	
		Integer sum = 0;
		
		assertEquals(false, selectionSum.groupSumClump(sum, inputs, 13));
		assertEquals(false, selectionSum.groupSumClump(sum, inputs, 24));
		assertEquals(false, selectionSum.groupSumClump(sum, inputs, 28));
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 17));
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 25));
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 20));

	}
	
	@Test
	public void groupSumClumTest5() {
		List<Integer> inputs = Arrays.asList(2, 2, 2, 2, -2);
	
		Integer sum = 0;
		
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 6));
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, 8));
		assertEquals(true, selectionSum.groupSumClump(sum, inputs, -2));
		assertEquals(false, selectionSum.groupSumClump(sum, inputs, 10));
		assertEquals(false, selectionSum.groupSumClump(sum, inputs, 7));
		assertEquals(false, selectionSum.groupSumClump(sum, inputs, 9));

	}
}
