/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Producer and Consumer Demo
 *  Date: 2/25/21
 *  
 */
package com.ss.week.one.thursday.kitchen;

/**
 * @author Mannchuoy Yam
 *
 */
public class RestaurantDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		Restaurant restaurant = new Restaurant();
		
		Thread server = new Thread(new Runnable() {

			@Override
			public void run() {
				restaurant.takeOrder();
			}
		});
		
		Thread cook = new Thread(new Runnable() {

			@Override
			public void run() {
				restaurant.makeOrder();
			}
		});
		
		cook.start();
		server.start();
		
		cook.join();
		server.join();	
	
	}
	
	

}
