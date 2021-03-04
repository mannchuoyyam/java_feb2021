/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment 2: Double Integer List Demo
 *  Date: 2/27/21 and 2/28/21 
 *  
 */
package com.ss.week.one.weekend.assignment.three;

import java.util.Arrays;

/**
 * @author Mannchuoy Yam
 *
 */
public class DoubleIntegerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DoubleInteger doubleInteger = new DoubleInteger();
		
		Integer[] inputs = {1, 30, 77, 99, 1010, 20045};
		
		Integer[]results = doubleInteger.doubling(inputs);
		
		System.out.println(Arrays.toString(results));
	}

}
