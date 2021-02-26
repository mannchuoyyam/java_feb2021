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
 */
public class Restaurant {
	private LinkedList<Integer> order = new LinkedList<>();
	private final Integer MAX_ORDER = 5;

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

				this.notify();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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

				this.notify();

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
