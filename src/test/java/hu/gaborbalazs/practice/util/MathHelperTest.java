package hu.gaborbalazs.practice.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MathHelperTest {

	private MathHelper mathHelper = new MathHelper();
	
	@Test
	public void testAdd() {
		int result = mathHelper.add(2, 3);
		int expected = 5;
		assertEquals(expected, result);
	}
}
