/**
 *  Cohort: Smoothstack java_feb2021 
 * 	Assignment: Simple Maven Project
 *  Date: 3/3/21
 *  
 */

package simpleMaven;



/**
 * @author Mannchuoy Yam
 *
 */
public class Singleton {

	volatile private static Singleton singleton = null;
	private static Integer instanceCounter = 0;

	private Singleton() {

	}
	
	// double lock checking by using volatile during declaration 
	public static Singleton getSingletonInstance() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
					instanceCounter++;
				}
			}
		}
		return singleton;
	}

	public Integer getInstanceCounter() {
		return instanceCounter;
	}
}