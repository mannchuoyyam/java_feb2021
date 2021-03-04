/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Text Appending To A File
 *  Date: 2/24/21
 *  
 */
package com.ss.week.one.wednesday.append;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Mannchuoy Yam
 *
 */
public class TextAppending {
	private String fileName;
		
	public TextAppending(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public String getFilePath() {
		Path path = Paths.get(fileName);
		return path.toAbsolutePath().toString();
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void write(String text) {
		try(PrintWriter outputFile = new PrintWriter(new FileWriter(fileName, true))){
			outputFile.println(text);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
