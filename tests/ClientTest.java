package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import booking.Book;
import client.*;
import lots.Lot;

public class ClientTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		/*
		 * Test the password Checker
		 */
		Student test = new Student("jeff", "As!1");
		assertEquals(true,test.passCheck());
		
		Student test0 = new Student("jeff", "a");
		assertEquals(false,test0.passCheck());
		
		/*
		 * test booking
		 */
		test.setValidation(true);
		
		Lot A = new Lot(true, 100, "A");
		
		test.bookParking(test, A, 1, 5, "BVLP662");
		
		Book book1 = test.getBooking();
		assertEquals(test,book1.getClient());
		assertEquals(A,book1.getLotName()); //check to see if book was made properly
		assertEquals(false,A.getSpot(1)); //check to see if spot was reserved in lot
		
		/*
		 * test end of booking payment
		 */
		assertEquals(5,book1.getDeposit(),0.1); //ensure deposit is being set upon booking (1h charge)
		
		double payment = test.pay(1, 123, "saif", "Qadri", 0101, "street", "Credit");
		assertEquals(5,payment,0.1); //this is our deposit payment
		
		test.endBooking();
		payment = test.pay(1, 123, "saif", "Qadri", 0101, "street", "Credit");
		assertEquals(20,payment,0.1); //now that the booking is over, we should charge the rate price subtracting initial deposit which is (5x5) - 5
		
		/*
		 * testing canceling
		 */
		Student test1 = new Student("jeff", "As!1");
		test1.setValidation(true);
		test1.bookParking(test1, A, 2, 5, "BVLP662");
		test1.cancelBooking(); 
		payment = test1.pay(1, 123, "saif", "Qadri", 0101, "street", "Credit");
		assertEquals(5,payment,0.1);
		
		/*
		 * testing extension
		 */
		Student test2 = new Student("jeff", "As!1");
		test2.setValidation(true);
		test2.bookParking(test2, A, 3, 5, "BVLP662");
		payment = test2.pay(1, 123, "saif", "Qadri", 0101, "street", "Credit");
		test2.extendBooking(1);
		test2.endBooking();
		payment = test2.pay(1, 123, "saif", "Qadri", 0101, "street", "Credit");
		assertEquals(25,payment,0.1);
	}

}
