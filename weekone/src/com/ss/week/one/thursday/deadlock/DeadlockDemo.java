/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Deadlock Demo
 *  Date: 2/25/21
 *  
 */
package com.ss.week.one.thursday.deadlock;

/**
 * @author Mannchuoy Yam
 *
 */
public class DeadlockDemo {

	/**
	 * The application will be stuck in a deadlock condition while
	 * one thread is holding frontDoorLock and trying to get backDoorLock, 
	 * the other thread is holding backDoorLock and trying to get frontDoorLock 
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Deadlock door = new Deadlock();
		
		Thread frontDoor = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					door.openFrontDoor();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread backDoor = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					door.openBackDoor();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});
		
		// start both threads
		backDoor.start();
		frontDoor.start();
		
		// wait for both threads
		frontDoor.join();
		backDoor.join();
	}

}
