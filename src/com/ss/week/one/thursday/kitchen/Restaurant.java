/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Producer and Consumer
 *  Date: 2/25/21
 *  
 */
package com.ss.week.one.thursday.kitchen;

import java.util.LinkedList;

/**
 * @author Mannchuoy Yam
 *
 * Class Restaurant implements two methods.
 * takeOrder add order number to the list and wait if the list is full
 * makeOrder get order number from the list and wait if the list is empty
 */
public class Restaurant {
	private LinkedList<Integer> order = new LinkedList<>();
	private final Integer MAX_ORDER = 5;
	private final Integer SLEEP_DURATION = 1000;
	
	public void takeOrder() {
		Integer orderNumber = 0;
		while (true) {
			synchronized (this) {
				while (order.size() == MAX_ORDER) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Adding order number: " + orderNumber);
				order.add(orderNumber++);

				this.notifyAll();
			}
			try {
				Thread.sleep(SLEEP_DURATION);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void makeOrder() {
		while (true) {
			synchronized (this) {
				while (order.size() == 0) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				Integer orderNumber = order.removeFirst();
				System.out.println(">>> Start making order number: " + orderNumber);

				this.notifyAll();
			}
			try {
				Thread.sleep(SLEEP_DURATION);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
