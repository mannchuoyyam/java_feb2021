/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Text Appending To A File Demo
 *  Date: 2/24/21
 *  
 */
package com.ss.week.one.wednesday.append;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Mannchuoy Yam
 *
 */
public class TextAppendingDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	private static final int MAX_LINES = 5;
	
	public static void main(String[] args) throws IOException {
		TextAppending textAppending = new TextAppending("text.txt");
		Scanner scanner = new Scanner(System.in);
		int startLine = 1;
		
		System.out.println("Write a poem in " + MAX_LINES + " to "+ textAppending.getFileName() + " file.");
		System.out.print("You can start from here: ");
		
		while (startLine++ < MAX_LINES) {
			String text = scanner.nextLine();
			textAppending.write(text);
		}
		
		System.out.println("Your poem is saved to " + textAppending.getFilePath() + ".");
		System.out.println("Bye! #codeforexcellence");

		scanner.close();
	}

}
