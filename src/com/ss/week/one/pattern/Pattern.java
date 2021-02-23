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
		for(int line = 1; line <= numberOfLines; ++line) {
			if(line == 1) {
				printChars('-', 0, 2 * numberOfLines);
			}else {
				printChars('*', 0, numberOfLines - line + 1);
				
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
	
	public static void main(String[] args) {
		Pattern pattern = new Pattern();
		
		int numberOfPatterns = 4;
		for(int i = 1; i <= numberOfPatterns; ++i) {
			System.out.println(i + ")");
			switch(i) {
			case 1:
				pattern.printPatternOne();
				break;
			case 2:
				pattern.printPatternTwo();
				break;
			case 3:
				pattern.printPatternThree();
				break;
			case 4:
				pattern.printPatternFour();
				break;
			default:
				System.out.println("No Patterns");
				break;
			}
		}
	}
}

