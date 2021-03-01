/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment 2: Double Integer List
 *  Date: 2/27/21 and 2/28/21 
 *  
 */
package com.ss.week.one.weekend.assignment.three;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mannchuoy Yam
 *
 */
public class DoubleInteger {
	public List<Integer> doubling(List<Integer> inputs){
		List<Integer> result = new ArrayList<>();
		
		result = inputs.stream()
						.map(e -> e * 2)
						.collect(Collectors.toList());
		
		return result;
	}
}
