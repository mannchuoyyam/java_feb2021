/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Print Star Patterns Demo
 *  Date: 2/21/21
 *  
 */
package com.ss.week.one.monday.pattern;

/**
 * @author Mannchuoy Yam
 *
 */
public class PatternDemo {

	/**
	 * @param args
	 */
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
