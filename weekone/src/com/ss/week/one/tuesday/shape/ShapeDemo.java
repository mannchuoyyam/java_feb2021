/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Demo Shape Interface Implementation
 *  Date: 2/23/21
 *  
 */
package com.ss.week.one.tuesday.shape;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mannchuoy Yam
 *
 */
public class ShapeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Shape> shapes = new ArrayList<>();
		shapes.add(new Circle(5.0));
		shapes.add(new Rectangle(5,4));
		shapes.add(new Triangle(5,5));
		
		for(Shape shape : shapes) {
			shape.display();
		}

	}

}
