/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Stream Utilities Demo
 *  Date: 2/26/21
 *  
 */
package com.ss.week.one.friday.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mannchuoy Yam
 *
 */
public class UtilsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> inputs = Arrays.asList("Hello", "smoothslack", "ais", "You", "I", "abce","abc", "e");

		List<Integer> inputIntegers = Arrays.asList(1, 2, 3, 4, 5);

		String[] inputsStringArray = {"Hello", "smoothslack", "ais", "You", "I", "abce", "e"};
		
		Utils stringUtils = new Utils();

		List<String> sortedList = null;
		
		// demo each function in Utils class and print outputs
		sortedList = stringUtils.sortedByLength(inputs);
		print(inputs, sortedList, "shortest length first");
		
		sortedList = stringUtils.sortedByReverseLength(inputs);
		print(inputs, sortedList, "longest length first");
		
		sortedList = stringUtils.sortedByFirstCharacter(inputs);
		print(inputs, sortedList, "shorted by first character alphabetically");

		String result = stringUtils.splitIntegersToString(inputIntegers);
		print(inputIntegers, result, "o for odd e for even number");

		sortedList = stringUtils.getStringsWithLength3AndStartWitha(inputs);
		print(inputs, sortedList, "filter string starting with an a and length is 3");
		
		sortedList = stringUtils.sortedByEFirst(inputs);
		print(inputs, sortedList, "sorted by string containing \"e\"");
				
		System.out.printf("Input: %s\n", Arrays.toString(inputsStringArray));
		Arrays.sort(inputsStringArray, (s1, s2) -> Utils.sortedByEFirst(s1, s2));	
		System.out.printf("Output sorted by string containing \"e\": %s\n", Arrays.toString(inputsStringArray));
	}
	
	public static <T, U>void print(List<T> inputs, List<U> outputs, String description) {
		System.out.println("Input: " + inputs);
		System.out.println("Output (" + description + "): " + outputs);
		System.out.println();
	}
	
	public static <T, U>void print(List<T> inputs, String outputs, String description) {
		System.out.println("Input: " + inputs);
		System.out.println("Output (" + description + "): \"" + outputs + "\"");
		System.out.println();
	}
}
