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

			if (sum == answer) {
				return true;
			} else {
				if (nextIndex > 1) {
					if (!groupSumClump(sum, inputs.subList(nextIndex, inputs.size()), answer)) {
						sum -= sumOfSameAdjacentNumber;
						return groupSumClump(sum, inputs.subList(nextIndex, inputs.size()), answer);
					} else {
						return true;
					} 
				} else {
					Boolean isPossibleToFindTheAnswer = false;
					for(int k = 1; k < inputs.size(); ++k) {
						if(groupSumClump(sum, inputs.subList(k, inputs.size()), answer)) {
							isPossibleToFindTheAnswer = true;
							break;
						}
					}
					if(isPossibleToFindTheAnswer) {
						return true;
					}
					return groupSumClump(0, inputs.subList(1, inputs.size()), answer);
				}
			}
		}
	}
}
