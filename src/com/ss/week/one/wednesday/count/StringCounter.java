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
	
	public static Integer countStringOccurrences(String stringToBeCounted, String fileName) {
		Integer numberOfOccurences = 0;
		
		try(BufferedReader inputStream = new BufferedReader(new FileReader(fileName))){
			String line;
			while( (line = inputStream.readLine()) != null) {
				Integer index = line.indexOf(stringToBeCounted);
				while(index != -1) {
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
