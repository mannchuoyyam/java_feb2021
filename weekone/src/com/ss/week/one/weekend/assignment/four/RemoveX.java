/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment 4: Remove Xs
 *  Date: 2/27/21 and 2/28/21 
 *  
 */
package com.ss.week.one.weekend.assignment.four;

import java.util.Arrays;

/**
 * @author Mannchuoy Yam
 *
 */
public class RemoveX {
	
	public String[] removeXs(String[] inputs) {
		return Arrays.stream(inputs)
						.map(e -> e.replace("x", ""))
						.toArray(String[]::new);
	}
}
