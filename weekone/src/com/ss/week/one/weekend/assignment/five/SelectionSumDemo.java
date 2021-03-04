/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment 5: Selection Sum Demo
 *  Date: 2/27/21 and 2/28/21 
 *  
 */
package com.ss.week.one.weekend.assignment.five;

import java.util.Arrays;
import java.util.List;

/**
 * @author Mannchuoy Yam
 *
 */
public class SelectionSumDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SelectionSum selectionSum = new SelectionSum();
		
		List<Integer> inputs = Arrays.asList(2, 4, 8);
		Integer sum = 0;
		Integer answer = 10;
		
		Boolean result = selectionSum.groupSumClump(sum, inputs, answer);
		
		System.out.println(result);

	}

}
