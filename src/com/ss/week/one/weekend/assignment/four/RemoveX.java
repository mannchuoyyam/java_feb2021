/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment 4: Remove Xs
 *  Date: 2/27/21 and 2/28/21 
 *  
 */
package com.ss.week.one.weekend.assignment.four;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mannchuoy Yam
 *
 */
public class RemoveX {
	
	public List<String> removeXs(List<String> inputs) {
		List<String> result = new ArrayList<>();
		
		result = inputs.stream()
						.map(e -> e.replace("x", ""))
						.collect(Collectors.toList());
		return result;
	}
}
