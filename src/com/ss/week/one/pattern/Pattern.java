/**
 * 	Class Pattern prints four different patterns.
 */
package com.ss.week.one.pattern;

/**
 * @author Mannchuoy Yam
 *
 */

public class Pattern {

	public void printPatternOne() {
		System.out.println("1)");
		System.out.println("*");
		System.out.println("**");
		System.out.println("***");
		System.out.println("****");
		System.out.println("---------");
		System.out.println();	
	}
	
	public void printPatternTwo() {
		System.out.println("2)");
		System.out.println("----------");
		System.out.println("****");
		System.out.println("***");
		System.out.println("**");
		System.out.println("*");
		System.out.println();
	}
	
	public void printPatternThree() {
		System.out.println("3)");
		System.out.println("     *     ");
		System.out.println("    ***    ");
		System.out.println("   *****   ");
		System.out.println("  *******  ");
		System.out.println("-----------");
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

