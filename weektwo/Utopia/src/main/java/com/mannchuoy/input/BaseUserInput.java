/**
 *  Java_feb2021 Corhot
 *  Week 2 Evaluation
 *  Assignment: Utopia Airline
 *  Date: 3/6/21 - 3/8/21
 * 
 */
package com.mannchuoy.input;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Mannchuoy Yam
 *
 */
public abstract class BaseUserInput {
	protected Scanner scanner;
	
	protected BaseUserInput(Scanner scanner) {
		this.scanner = scanner;
	}
	
	protected void skipNewLine() {
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	}

	protected void println(String message) {
		System.out.println(message);
	}

	protected void print(String message) {
		System.out.print(message);
	}
	
	protected void flushBadInput() {
		String s = scanner.nextLine();
		print(s + " is not a good input.");
	}
	
	protected int validateAndGetInteger(String prompt) {
		int number = 0;
		boolean isCorrectInput = false;
		
		while (!isCorrectInput) {
			print(prompt);
			try {
				number = scanner.nextInt();
				isCorrectInput = true;
			} catch (NoSuchElementException e) {
				flushBadInput();
			}
		}
		
		return number;
	}
}
