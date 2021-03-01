/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment 1: Lambdas Demo
 *  Date: 2/27/21 and 2/28/21 
 *  
 */
package com.ss.week.one.weekend.assignment.one;

import java.util.Scanner;
import java.util.function.Function;

/**
 * @author Mannchuoy Yam
 *
 */
public class NumberTestDemo {

	Integer[] operations = null;
	Integer[] inputs = null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printInstruction();
		
		NumberTestDemo demo = new NumberTestDemo();
		demo.readInputs();
		demo.testNumber();
	}

	private void readInputs() {
		Scanner scanner = new Scanner(System.in);
		// TODO: need to handle exception
		System.out.print("Please enter the number of test cases: ");
		Integer numberOfInputs = scanner.nextInt();
		
		operations = new Integer[numberOfInputs];
		inputs = new Integer[numberOfInputs];
		
		System.out.print("Please enter test case (x y): " );
		
		for(int i = 0; i < numberOfInputs; ++i) {
			operations[i] = scanner.nextInt();
			inputs[i] = scanner.nextInt();
			if( i + 1 < numberOfInputs) {
				System.out.print("Please enter test case (x y): " );
			}else {
				System.out.println();
			}
		}
		
		scanner.close();
	}
	
	private void testNumber() {
		NumberTest numberTest = new NumberTest();
		
		for(int i = 0; i < operations.length; ++i) {
			switch(operations[i]) {
			case 1:
				testNumber(inputs[i], numberTest.isOdd);
				break;
			case 2:
				testNumber(inputs[i], numberTest.isPrime);
				break;
			case 3:
				testNumber(inputs[i], numberTest.isPalindrome);
				break;
			default:
				System.out.println("[" + operations[i] + "] unsupported operation");
					break;
			}
		}
	}
	
	public <T, U> void testNumber(T number, Function<T, U> operator) {		
		System.out.println(number + " is " + operator.apply(number));
	}
	
	public static void printInstruction() {
		System.out.println("Input is in the form:");
		System.out.printf("4\n1 4\n2 11\n3 111\n2 100\n");
		System.out.println("Number 4 on the fist line is the number of test cases.");
		System.out.println("The first number of the following line is operation codes.");
		System.out.println("[1] to test if the second number is odd or even.");
		System.out.println("[2] to test if the second number is prime or composite.");
		System.out.println("[3] to test if the second number is palindrome or not.");
		System.out.println();
	}
}
