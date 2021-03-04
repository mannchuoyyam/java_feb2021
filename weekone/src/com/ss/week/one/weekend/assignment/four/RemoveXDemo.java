/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment 4: Remove Xs Demo
 *  Date: 2/27/21 and 2/28/21 
 *  
 */
package com.ss.week.one.weekend.assignment.four;

import java.util.Arrays;
import java.util.List;

/**
 * @author Mannchuoy Yam
 *
 */
public class RemoveXDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RemoveX removeX = new RemoveX();
		
		String[] inputs = {"ax", "bb", "cx", "xxax", "xxxx", "xbxbx", "xxcx"};
		
		String[] results = removeX.removeXs(inputs);
		
		System.out.println(Arrays.toString(results));

	}

}
