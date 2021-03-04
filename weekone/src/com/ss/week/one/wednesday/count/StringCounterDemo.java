/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: String Counter Demo
 *  Date: 2/24/21
 *  
 */
package com.ss.week.one.wednesday.count;

import java.util.Scanner;

/**
 * @author Mannchuoy Yam
 *
 */
public class StringCounterDemo {

	/**
	 * @param args
	 * 
	 */
	
	private static final Integer MIN_ARGUEMENT = 2;
	
	public static String[] readUserInput() {
		String[] inputs = new String[2];
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter a file name: ");
		inputs[0] = scanner.nextLine();

		System.out.print("Please enter a string to be searched: ");
		inputs[1] = scanner.nextLine();

		scanner.close();

		return inputs;
	}
	
	public static void printInstruction() {
		System.out.println("You can run the application with input arguments as shown below:");
		System.out.println("java StringCounterDemo input.txt searchedString1 ...");
		System.out.println();
	}

	public static void main(String[] args) {
		
		if (args.length < MIN_ARGUEMENT) {
			printInstruction();
			
			args = readUserInput();
		}

		String fileName = args[0];

		// count number of occurrences and and display the result
		for (int i = 1; i < args.length; ++i) {
			Integer count = StringCounter.countStringOccurrences(args[i], fileName);

			String charOrString = args[i].length() == 1 ? "character" : "string";
			System.out.println("Found " + charOrString + " \"" + args[i] + "\" in " + " file \"" + fileName + "\" "
					+ count + " times.");
		}
	}
}
