/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment 2: Double Integer List Demo
 *  Date: 2/27/21 and 2/28/21 
 *  
 */
package com.ss.week.one.weekend.assignment.three;

import java.util.Arrays;
import java.util.List;

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
		
		List<Integer> inputs = Arrays.asList(1, 30, 77, 99, 1010, 20045);
		
		List<Integer> results = doubleInteger.doubling(inputs);
		
		System.out.println(results);
	}

}
