package simpleMaven;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SingletonTest {
	@Test
	public void singletonTest(){
		Singleton instance = Singleton.getSingletonInstance();
		Singleton instance1 = Singleton.getSingletonInstance();
		Singleton instance2 = Singleton.getSingletonInstance();
		Singleton instance3 = Singleton.getSingletonInstance();
		
		int numOfInstance = 1;
		assertEquals(numOfInstance, instance.getInstanceCounter().intValue());
		assertEquals(numOfInstance, instance1.getInstanceCounter().intValue());
		assertEquals(numOfInstance, instance2.getInstanceCounter().intValue());
		assertEquals(numOfInstance, instance3.getInstanceCounter().intValue());
	}
}
