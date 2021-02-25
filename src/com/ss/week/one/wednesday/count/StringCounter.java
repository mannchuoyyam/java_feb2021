/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: String Counter
 *  Date: 2/24/21
 *  
 */
package com.ss.week.one.wednesday.count;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Mannchuoy Yam
 *
 */
public class StringCounter {
	private static final Integer NOT_FOUND_INDEX = -1;
	
	public static Integer countStringOccurrences(String stringToBeCounted, String fileName) {
		Integer numberOfOccurences = 0;
		
		try(BufferedReader inputStream = new BufferedReader(new FileReader(fileName))){
			String line;
			while( (line = inputStream.readLine()) != null) {
				Integer index = line.indexOf(stringToBeCounted);
				while(index != NOT_FOUND_INDEX) {
					numberOfOccurences++;
					index = line.indexOf(stringToBeCounted, index + stringToBeCounted.length());
				}
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return numberOfOccurences;
	}
}
