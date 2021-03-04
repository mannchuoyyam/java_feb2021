/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: List All Files and Directories Demo
 *  Date: 2/24/21
 *  
 */
package com.ss.week.one.wednesday.path;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mannchuoy Yam
 *
 */
public class DirectoryDemo {

	/**
	 * read and validate directory name
	 */

	public static Path readUserInput() {
		Scanner scanner = new Scanner(System.in);
		Path path = null;

		System.out.print("Please enter a directory name (relative/absolute path): ");

		while (path == null) {
			String directoryName = scanner.nextLine();

			path = Paths.get(directoryName);
			File file = path.toFile();

			if (!file.exists() || !file.isDirectory()) {
				path = null;

				System.out.println("Directory name \'" + directoryName + "\' is not valid.");
				System.out.println("Please enter a valid directory name (relative/absolute path): ");
			}
		}

		scanner.close();

		return path;
	}

	public static void main(String[] args) {

		Path path = null;
		path = readUserInput();

		Directory directory = new Directory(path);

		List<Path> allPaths = null;

		allPaths = directory.listAllFilesAndDirectories();

		Collections.sort(allPaths);

		if (allPaths != null) {
			for (Path p : allPaths) {
				System.out.println(p);
			}
		}

	}

}
