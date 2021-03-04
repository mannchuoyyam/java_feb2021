/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment 2: Right Digit
 *  Date: 2/27/21 and 2/28/21 
 *  
 */
package com.ss.week.one.weekend.assignment.two;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mannchuoy Yam
 *
 */
public class RightDigit {
	//return the right most digit of each number from inputs
	public List<Integer> rightDigit(List<Integer> inputs){
		List<Integer> result = new ArrayList<>();
		
		result = inputs.stream()
						.map(e -> e % 10)
						.collect(Collectors.toList());

		return result;
	}
}
