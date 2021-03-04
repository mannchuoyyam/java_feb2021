/**
 * 
 */
package com.ss.week.one.tuesday.sum;

import java.util.Arrays;

/**
 * @author Mannchuoy Yam
 *
 */
public class AdditionDemo {
	// print user input to console if there is any inputs
	// otherwise show the user how to run the application
	public static Boolean checkCommandlineInputs(String[] args) {
		if(args.length == 0) {
			System.out.println("There is no arguements. Please try again.");
			System.out.println("Example: java AdditionDemo 12 43 5.0 test 54");
			return false;
		}
		System.out.println("Your input is " + Arrays.toString(args)+ ".");
		return true;
	}
	
	public static void main(String[] args) {		
		
		if(!checkCommandlineInputs(args)) {
			return;
		}
		
		Addition addition = new Addition(args);
		
		Double total = addition.sumInputs();
		
		System.out.println("Total : " + total);
	}

}
