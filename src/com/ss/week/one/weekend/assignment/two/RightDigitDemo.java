/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment 2: Right Digit
 *  Date: 2/27/21 and 2/28/21 
 *  
 */
package com.ss.week.one.weekend.assignment.two;

import java.util.Arrays;
import java.util.List;

/**
 * @author Mannchuoy Yam
 *
 */
public class RightDigitDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RightDigit digit = new RightDigit();
		
		List<Integer> inputs = Arrays.asList(1, 30, 77, 99, 1010, 20045);
		
		List<Integer> results = digit.rightDigit(inputs);
		
		System.out.println(results);
	}

}
