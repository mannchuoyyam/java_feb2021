/**
 *  Week 1
 *  Assignment 2: Guess a Number
 */
package com.ss.week.one.guessnumber;

import java.util.Scanner;
import java.util.Random;

/**
 * @author Mannchuoy Yam
 *
 */
public class GuessNumber {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Random randomGenerator = new Random();
		int generatedNumber = randomGenerator.nextInt(200) + 1;
		final int plusOrMinusErrorRange = 10;
		final int numberOfChances = 5;
		boolean isWinning = false;
		
		System.out.print("Please guess a number between (1-200): ");
		
		for(int i = 0; i < numberOfChances; ++i) {
			int userGuessedNumber = scanner.nextInt();
			// check if userGuessedNumber is outside the plus or minus error range
			if (userGuessedNumber < generatedNumber - plusOrMinusErrorRange || userGuessedNumber > generatedNumber + plusOrMinusErrorRange) {
				// Don't print if it is the last chance
				if(i + 1 < numberOfChances) {
					System.out.printf("You have %d more chance(s) left. Please try again: ", numberOfChances - 1 - i);
				}
			}else {
				isWinning = true;
				break;
			}
		}
		scanner.close();

		if(isWinning) {
			System.out.println("You Win!");
		}else {
			System.out.println("Sorry :-(");
		}
		System.out.println("The number is " + generatedNumber + ".");
	}

}
