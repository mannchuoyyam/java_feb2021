/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Stream Utilities
 *  Date: 2/26/21
 *  
 */
package com.ss.week.one.friday.lambdas;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mannchuoy Yam
 *
 */
public class Utils {

	public List<String> sortedByLength(List<String> inputs){
		List<String> sortedArray = null;
		sortedArray = inputs.stream()
							.sorted((lhs, rhs) -> lhs.length() - rhs.length())
							.collect(Collectors.toList());
		
		return sortedArray;
	}
	
	public List<String> sortedByReverseLength(List<String> inputs){
		List<String> sortedArray = null;
		sortedArray = inputs.stream()
							.sorted((lhs, rhs) -> rhs.length() - lhs.length())
							.collect(Collectors.toList());
		
		return sortedArray;
	}
	
	public List<String> sortedByFirstCharacter(List<String> inputs){
		List<String> sortedArray = null;
		sortedArray = inputs.stream()
							.sorted((lhs, rhs) -> Character.toLowerCase(lhs.charAt(0)) - Character.toLowerCase(rhs.charAt(0)))
							.collect(Collectors.toList());
		
		return sortedArray;
	}
	
	public List<String> sortedByEFirst(List<String> inputs){
		List<String> sortedArray = null;
		sortedArray = inputs.stream()
							.sorted((lhs, rhs) -> {
								if(lhs.contains("e") && !rhs.contains("e")) {
									return -1;
								}else if(!lhs.contains("e") && rhs.contains("e")) {
									return 1;
								}else {
									return 0;
								}
							})
							.collect(Collectors.toList());
		
		return sortedArray;
	}
	
	// may use it with lambda expression
	public static int sortedByEFirst(String lhs, String rhs) {
		
		if(lhs.contains("e") && !rhs.contains("e")) {
			return -1;
		}else if(!lhs.contains("e") && rhs.contains("e")) {
			return 1;
		}else {
			return 0;
		}
	}
	
	// append e or or to an integer if it is even or odd accordingly
	public String splitIntegersToString(List<Integer> inputs) {
		String result = null;
		
		result = inputs.stream()
				.map(e -> e % 2 == 0 ? "e" + e : "o" + e )
				.reduce("", (sub, e) -> {
					if(sub.isBlank()) {
						return e.toString();
					}
					return sub.toString() + "," + e.toString();
				});
		
		return result;
	}
	
	public List<String> getStringsWithLength3AndStartWitha(List<String> inputs){
		List<String> result = null;
		Integer stringLengthFilter = 3;
		
		result = inputs.stream()
						.filter(e -> e.charAt(0) == 'a' && e.length() == stringLengthFilter)
						.collect(Collectors.toList());
		
		return result;
	}
}
