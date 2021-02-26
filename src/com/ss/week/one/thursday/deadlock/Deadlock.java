/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Deadlock
 *  Date: 2/25/21
 *  
 */
package com.ss.week.one.thursday.deadlock;

/**
 * @author Mannchuoy Yam
 *
 */
public class Deadlock {
	
	private Integer frontDoorLock = 1;
	private Integer backDoorLock = 2;

	public void openFrontDoor() throws InterruptedException {
		synchronized (frontDoorLock) {
			System.out.println("Hold front door lock");
			Thread.sleep(50);
			synchronized (backDoorLock) {
				System.out.println("Trying to open the back door.");
			}
		}
	}

	public void openBackDoor() throws InterruptedException {
		synchronized (backDoorLock) {
			System.out.println("Holding back door lock");
			Thread.sleep(50);
			synchronized (frontDoorLock) {
				System.out.println("Trying to oepn the front door.");
			}
		}
	}
}
