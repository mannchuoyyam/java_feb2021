/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment 1: Lambdas
 *  Date: 2/27/21 and 2/28/21 
 *  
 */
package com.ss.week.one.weekend.assignment.one;

import java.util.function.Function;

/**
 * @author Mannchuoy Yam
 *
 */
public class NumberTest {
	// define lambda functions isOdd, isPrime, and isPalindrome 
	public Function<Integer, String> isOdd = (number) -> number % 2 == 0 ? "EVEN" : "ODD";
	
	public Function<Integer, String> isPrime = (number) -> {
		Boolean isPrimeNumber = true;
		
		for(int i = 2; i <= number / 2; ++i) {
			if(number % i == 0) {
				isPrimeNumber = false;
				break;
			}
		}
		
		return isPrimeNumber ? "PRIME" : "COMPOSITE";
	};
	
	public Function<Integer, String> isPalindrome = (number) -> {
		String numbers = String.valueOf(number);
		Boolean isPalindromeNumber = true;
		
		Integer middle = (int) Math.ceil(numbers.length() / 2.0);
		
		// is Palindrome if both sides are the same
		for(int i = 0; i < middle; ++i) {
			if(numbers.charAt(i) != numbers.charAt(numbers.length() - 1 - i)) {
				isPalindromeNumber = false;
				break;
			}
		}
		
		return isPalindromeNumber ? "PALINDROME" : "NOT PALINDROME";
	};
}
