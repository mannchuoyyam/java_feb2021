/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment 2: Double Integer List
 *  Date: 2/27/21 and 2/28/21 
 *  
 */
package com.ss.week.one.weekend.assignment.three;

import java.util.Arrays;

/**
 * @author Mannchuoy Yam
 *
 */
public class DoubleInteger {
	public Integer[] doubling(Integer[] inputs){
		return Arrays.stream(inputs)
						.map(e -> e * 2)
						.toArray(Integer[]::new);
	}
}
