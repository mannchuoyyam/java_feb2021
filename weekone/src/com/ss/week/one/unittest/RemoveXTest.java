/**
 * 
 */
package com.ss.week.one.unittest;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.ss.week.one.weekend.assignment.four.RemoveX;

/**
 * @author mann
 *
 */
public class RemoveXTest {
	RemoveX x = new RemoveX();
	String[] inputs = {"ax", "bb", "cx", "xxax", "xxxx", "xbxbx", "xxcx"};
	String[] expected =  {"a", "bb", "c", "a", "", "bb", "c"};
	@Test
	public void removeXTest() {
		assertArrayEquals(expected, x.removeXs(inputs));
	}
	
}
