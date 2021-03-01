/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment 5: Selection Sum
 *  Date: 2/27/21 and 2/28/21 
 *  
 */
package com.ss.week.one.weekend.assignment.five;

import java.util.List;

/**
 * @author Mannchuoy Yam
 *
 */
public class SelectionSum {
	public Boolean groupSumClump(Integer sum, List<Integer> inputs, Integer answer) {
		if (inputs.isEmpty()) {
			return false;
		} else {
			int firstElement = 0;
			sum += inputs.get(firstElement);
			int nextIndex = 1;
			int sumOfSameAdjacentNumber = inputs.get(firstElement);
			for (int i = 1; i < inputs.size(); ++i) {
				if (inputs.get(i) == inputs.get(i - 1)) {
					sum += inputs.get(i);
					sumOfSameAdjacentNumber += inputs.get(i);
					nextIndex = i + 1;
				} else {
					break;
				}
			}
			// is possible to get the sum
			if (sum == answer) {
				return true;
			} else {
				// adding the next element with new sum
				if(groupSumClump(sum, inputs.subList(nextIndex, inputs.size()), answer)) {
					return true;
				}
				// remove the last element or same adjacent numbers
				// start adding again
				sum -= sumOfSameAdjacentNumber;
				if(groupSumClump(sum, inputs.subList(nextIndex, inputs.size()), answer)) {
					return true;
				}
				return false;
			}
		}
	}
}
