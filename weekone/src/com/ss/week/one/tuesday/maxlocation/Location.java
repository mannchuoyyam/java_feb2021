/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Find Max Number Location
 *  Date: 2/23/21
 *  
 */
package com.ss.week.one.tuesday.maxlocation;

/**
 * @author Mannchuoy Yam
 *
 */
public class Location {
	public MaxLocation findMaxLocation(Integer[][] numbers) {
		MaxLocation maxLocation = new MaxLocation();

		for(int i = 0; i < numbers.length; ++i) {
			for(int j = 0; j < numbers[i].length; ++j) {
				if(numbers[i][j] > maxLocation.getMaxValue()) {
					maxLocation.setMaxValue(numbers[i][j]);
					maxLocation.setRowNumber(i);
					maxLocation.setColumnNumber(j);
				}
			}
		}
		return maxLocation;
	}

}
