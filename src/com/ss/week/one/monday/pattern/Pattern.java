/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Print Star Patterns
 *  Date: 2/21/21
 *  
 */
package com.ss.week.one.monday.pattern;

/**
 * @author Mannchuoy Yam
 *
 */

public class Pattern {

	public void printChars(char characterToBePrinted, int startAt, int numberOfCharacters) {
		for(int i = 0; i < startAt; ++i) {
			System.out.print(" ");
		}
		for(int i = 0; i < numberOfCharacters; ++i) {
			System.out.print(characterToBePrinted);
		}
	}
	public void printPatternOne() {
		int numberOfLines = 5;
		int startAt = 0;
		for(int line = 1; line <= numberOfLines; ++line) {
			if(line != 5) {
				printChars('*', startAt, line);
			}else {
				printChars('-', startAt, (2 * numberOfLines) - 1);
				
			}
			System.out.println();
		}
		System.out.println();	
	}
	
	public void printPatternTwo() {
		int numberOfLines = 5;
		int startAt = 0;
		for(int line = 1; line <= numberOfLines; ++line) {
			if(line == 1) {
				printChars('-', startAt, 2 * numberOfLines);
			}else {
				printChars('*', startAt, numberOfLines - line + 1);
				
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void printPatternThree() {
		int numberOfLines = 5;
		int startAt = 5;
		for(int line = 1; line <= numberOfLines; ++line) {
			if(line == numberOfLines) {
				printChars('-', 0, (2 * numberOfLines + 1));
			}else {
				printChars('*', startAt--, (2 * line) - 1);
				
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void printPatternFour() {
		int numberOfLines = 5;
		int startAt = 2;
		for(int line = 1; line <= numberOfLines; ++line) {
			if(line == 1) {
				printChars('-', 0, (2 * numberOfLines) + 1);
			}else {
				printChars('*', startAt++, (2 * (numberOfLines - line)) + 1);
				
			}
			System.out.println();
		}
		System.out.println();
	}
}

