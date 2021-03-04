/**
 * 
 */
package com.ss.week.one.unittest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.ss.week.one.friday.lambdas.Utils;

/**
 * @author Mannchuoy Yam
 *
 */
public class UtilsTest {

	Utils utils = new Utils();
	
	List<String> inputs = Arrays.asList("Hello", "smoothslack", "ais", "You", "I", "abce","abc", "e");

	List<Integer> inputIntegers = Arrays.asList(1, 2, 3, 4, 5);

	String[] inputsStringArray = {"Hello", "smoothslack", "ais", "You", "I", "abce", "e"};

	@Test
	public void sortedByLegthTest() {
		assertEquals(Arrays.asList("I", "e", "ais", "You", "abc", "abce", "Hello", "smoothslack"), utils.sortedByLength(inputs));
	}
	
	@Test
	public void sortedByReverseLengthTest() {
		assertEquals(Arrays.asList("smoothslack", "Hello", "abce", "ais", "You", "abc", "I", "e"), utils.sortedByReverseLength(inputs));
	}
}
