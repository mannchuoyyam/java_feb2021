/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: List All Files and Directories
 *  Date: 2/24/21
 *  
 */
package com.ss.week.one.wednesday.path;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mannchuoy Yam
 *
 */
public class Directory {

	private Path path;

	public Directory(Path path) {
		setPath(path);
	}

	public List<Path> listAllFilesAndDirectories() {
		if (path != null) {
			List<Path> paths = new ArrayList<>();

			return listAllFilesAndDirectories(path, paths);
		}

		return null;
	}

	private List<Path> listAllFilesAndDirectories(Path path, List<Path> allPaths) {
		File file = path.toFile();
		try {
			File[] allFiles = file.listFiles();

			for (File f : allFiles) {
				if (f.isFile()) {
					allPaths.add(f.toPath());
				} else if (f.isDirectory()) {
					allPaths.add(f.toPath());
					listAllFilesAndDirectories(f.toPath(), allPaths);
				}
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			return null;
		}

		return allPaths;
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		try {
			File testFile = path.toFile();
			if (testFile.exists() && testFile.isDirectory()) {
				this.path = path;
			} else {
				System.out.println("Path name: \'" + path.toAbsolutePath() + "\' is not a valid path.");
				this.path = null;
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			this.path = null;
		}
	}
}
