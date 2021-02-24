/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Sum All Numbers
 *  Date: 2/23/21
 *  
 */
package com.ss.week.one.tuesday.sum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mannchuoy Yam
 *
 */
public class Addition {

	private List<Double> inputs;
	
	public Addition(String[] args) {
		this.inputs = new ArrayList<Double>();
		parseInput(args);
	}
	/**
	 * read each string from args
	 * convert to number
	 * skip if exception occurs.
	 *
	 */
	private void parseInput(String[] args) {
		for(String arg : args) {
			try {
				double number = Double.parseDouble(arg);
				inputs.add(number);
			}catch(NumberFormatException e) {
				System.out.println("Exception Handled: Can't convert \"" + arg + "\" to number.");
				continue;
			}
		}
	}
	
	public Double sumInputs() {
		Double total = 0.0;
		for(Double input : inputs) {
			total += input;
		}
		return total;
	}
}
