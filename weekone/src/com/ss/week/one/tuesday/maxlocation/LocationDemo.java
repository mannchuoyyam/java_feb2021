/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Demo
 *  Date: 2/23/21
 *  
 */
package com.ss.week.one.tuesday.maxlocation;

import java.util.Arrays;

/**
 * @author Mannchuoy Yam
 *
 */
public class LocationDemo {
	
	public static void displayInput(Integer[][] inputs) {
		System.out.println("Find max value location.");
		System.out.println("Input: ");
		System.out.print("[");
		for(int i = 0; i < inputs.length; ++i) {
			System.out.print(Arrays.toString(inputs[i]));
			if(i + 1 != inputs.length) {
				System.out.println(",");
			}
		}
		System.out.println("]");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Location location = new Location();
		
		Integer[][] inputs = {
				{100,200,3},
				{4,5,6},
				{7,8,9,},
				{10,1100,12}
		};
		
		displayInput(inputs);
				
		MaxLocation maxLocation = location.findMaxLocation(inputs);
		
		// output
		if(maxLocation.isValidLocation()) {
			System.out.println(maxLocation);
		}else {
			System.out.println("Input 2D array might be empty.");
		}
	}

}
