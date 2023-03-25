package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import lots.Lot;

public class LotTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		/*
		 * Lot testing
		 * ensuring that the hash map is being manipulated
		 * properly based on if we want to get spot availability
		 * or change it
		 * 
		 * also test out some other functionality
		 */
		Lot test = new Lot(true, 100, "A");
		
		boolean temp = test.getSpot(1);
		assertEquals(true,temp);
		
		test.setSpot(1, false); //books space
		
		temp = test.getSpot(1);
		assertEquals(false,temp);
		
		test.setSpot(1, true); //free space
		
		temp = test.getSpot(1);
		assertEquals(true,temp);
		
		String temp1 = test.getLots();
		assertEquals("[A]",temp1);

	}

}
