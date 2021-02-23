/**
 * 	Class Pattern prints four different patterns.
 */
package com.ss.week.one.pattern;

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
		System.out.println("1)");
		int numberOfLines = 5;
		for(int line = 1; line <= numberOfLines; ++line) {
			if(line != 5) {
				printChars('*', 0, line);
			}else {
				printChars('-', 0, 9);
				
			}
			System.out.println();
		}
		System.out.println();	
	}
	
	public void printPatternTwo() {
		System.out.println("2)");
		int numberOfLines = 5;
		for(int line = 1; line <= numberOfLines; ++line) {
			if(line == 1) {
				printChars('-', 0, 10);
			}else {
				printChars('*', 0, numberOfLines - line + 1);
				
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void printPatternThree() {
		System.out.println("3)");
		int numberOfLines = 5;
		int startAt = 5;
		for(int line = 1; line <= numberOfLines; ++line) {
			if(line == numberOfLines) {
				printChars('-', startAt--, 11);
			}else {
				printChars('*', startAt--, (2 * line) - 1);
				
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void printPatternFour() {
		System.out.println("4)");
		System.out.println("-----------");
		System.out.println("  *******  ");
		System.out.println("   *****   ");
		System.out.println("    ***    ");
		System.out.println("     *     ");
	}
	
	public static void main(String[] args) {
		Pattern pattern = new Pattern();
		
		pattern.printPatternOne();
		
		pattern.printPatternTwo();
		
		pattern.printPatternThree();
		
		pattern.printPatternFour();
	}
}

