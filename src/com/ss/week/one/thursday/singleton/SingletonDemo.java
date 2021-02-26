/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Singleton Design Pattern Demo
 *  Date: 2/25/21
 *  
 */
package com.ss.week.one.thursday.singleton;

/**
 * @author Mannchuoy Yam
 *
 */
public class SingletonDemo implements Runnable{

	/**
	 * @param args
	 */
	private static final Integer MAX_NUMBER_OF_THREADS = 50;
	
	public static void main(String[] args) throws InterruptedException {
		for(int i = 0; i < MAX_NUMBER_OF_THREADS; ++i) {
			new Thread(new SingletonDemo(), "thread " + i).start();
		}
		//wait for 1 second
		//we can use join() to wait for all the threads to return
		//but we just want to prove that we only create one singleton instance
		Thread.sleep(1000);
	}

	@Override
	public void run() {
		Singleton singleton = Singleton.getSingletonInstance();
		// prove that only one instances of singleton is created
		System.out.println("Number of singleton instance is " + singleton.getInstanceCounter() + " in " + Thread.currentThread().getName());
	}

}
