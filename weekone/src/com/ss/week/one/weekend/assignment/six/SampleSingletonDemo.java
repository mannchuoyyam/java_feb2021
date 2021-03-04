/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment 6: Singleton Demo
 *  Date: 2/27/21 and 2/28/21 
 *  
 */
package com.ss.week.one.weekend.assignment.six;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Mannchuoy Yam
 *
 */
public class SampleSingletonDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		Runnable demo = ()->{
			SampleSingleton database_connection = SampleSingleton.getInstance();
			try {
				BigDecimal result =  database_connection.databaseQuery(new BigDecimal(10));
				System.out.println(result);
			}catch(SQLException e) {
				System.out.println("Unable to get the result. We can let the user to decide what to do");
			}
		};
		
		List<Thread> threads = new ArrayList<>();
		for(int i = 0; i < 10; ++i) {
			threads.add(new Thread(demo));
		}
		
		for(Thread t : threads) {
			t.start();
		}
		
		for(Thread t : threads) {
			t.join();
		}
		
		System.out.println("Done!");
	}

}
