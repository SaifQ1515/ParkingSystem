package booking;

import client.Client;

public class Payee {

	public Book bookingRef;
	
	public Payee(Book bookingRef) {
		this.bookingRef = bookingRef;
	}
	
	public Book getbookingRef() {
		return this.bookingRef;
	}
	
	public void setbookingRef(Book bookingRef) {
		this.bookingRef = bookingRef;
	}
	
	public double pay(int cardNum, int ccv, String firstName, String lastName, int expiry, String address, String type) {
		double paymentTotal;
		double deposit = bookingRef.getDeposit();
		
		Client curClient = bookingRef.getClient();
		double rate = curClient.getRate();
		int duration = bookingRef.getDuration();
		
		if(bookingRef.getTime() == 0)
		{
			paymentTotal = deposit; //deposit price
		}
		else
		{
			paymentTotal = (rate*duration) - deposit; //price with deposit deductible
		}
		
		MethodFactory factory = new MethodFactory();
		Method payment = factory.MethodFactory(cardNum, ccv, firstName, lastName, expiry, address, type);
		
		payment.charge(); //this is the method that would connect to the bank or further application
		
		return paymentTotal;
		
	}

}
