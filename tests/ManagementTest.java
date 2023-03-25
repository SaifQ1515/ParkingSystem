package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import manager.Manager;
import manager.SuperManager;

public class ManagementTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		SuperManager test = SuperManager.getInstance();
		assertEquals("admin",test.getName());
		assertEquals("admin",test.getPass()); //check to make sure the one instance is made correctly as per singleton design pattern
		
		Manager man1 = test.genManager(); //should print a random manager login into the console and return the manager object
		Manager man2 = test.genManager();
		test.getManagerList(); //prints out all available manager accounts
		
	}

}
