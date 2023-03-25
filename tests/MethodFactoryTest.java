package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import booking.Method;
import booking.MethodFactory;

public class MethodFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		MethodFactory factory = new MethodFactory();
		
		Method credit = factory.MethodFactory(1, 123, "Saif", "Qadri", 0102, "Street", "Credit");
		Method debit = factory.MethodFactory(2, 123, "Saif", "Qadri", 0102, "Street", "Debit");
		Method mobile = factory.MethodFactory(3, 123, "Saif", "Qadri", 0102, "Street", "Mobile");
		
		assertEquals(1,credit.getCardNum());
		assertEquals(2,debit.getCardNum());
		assertEquals(3,mobile.getCardNum()); //test the factory made the right type of methods
		
		
	}

}
