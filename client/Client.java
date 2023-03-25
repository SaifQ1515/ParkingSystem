package client;

import lots.*;
import booking.*;
import manager.*;

public abstract class Client {

	public String email;
	public String pass;
	public boolean validated;
	protected int rate;
	public Book curBooking;
	
	public Client(String newEmail, String newPass, int newRate) {
		this.email = newEmail;
		this.pass = newPass;
		this.rate = newRate;
	}
	
	protected String getEmail() {
		return this.email;
	}
	
	protected void setEmail(String newEmail) {
		this.email = newEmail;
	}
	
	protected String getPass() {
		return this.pass;
	}
	
	protected void setPass(String newPass) {
		this.pass = newPass;
	}
	
	public int getRate() {
		return this.rate;
	}
	
	protected void setRate(int newRate) {
		this.rate = newRate;
	}
	
	public boolean getValidation() {
		return this.validated;
	}
	
	public void setValidation(boolean newVal) {
		this.validated = newVal;
	}
	
	public Book getBooking() {
		return this.curBooking;
	}
	
	/*
	 * REQ1
	 * this method checks to make sure there are a combination of uppercase letters,
	 * lowercase letters, numbers and symbols
	 */
	public boolean passCheck() {
		boolean hasUpperCase = false;
	    boolean hasLowerCase = false;
	    boolean hasNumber = false;
	    boolean hasSymbol = false;
	    String symbols = "!@#$%^&*()_+-=[]{}\\|;':\",./<>?";
	    
	    for (int i = 0; i < this.pass.length(); i++) {
	        char c = this.pass.charAt(i);
	        if (Character.isUpperCase(c)) {
	            hasUpperCase = true;
	        } else if (Character.isLowerCase(c)) {
	            hasLowerCase = true;
	        } else if (Character.isDigit(c)) {
	            hasNumber = true;
	        } else if (symbols.contains(String.valueOf(c))) {
	            hasSymbol = true;
	        }
	    }
	    
	    return hasUpperCase && hasLowerCase && hasNumber && hasSymbol;
	}
	
	/*
	 * REQ3
	 * allow clients to make a booking if their validated
	 */
	public void bookParking(Client newClient, Lot lotname, int spaceNum, int duration, String plate) {
		if(this.validated == true)
		{
			Book newBook = new Book(newClient, lotname, spaceNum, duration, plate);
			this.curBooking = newBook;
			this.curBooking.book();
		}
		else
		{
			System.out.println("not yet validated");
		}
	}
	
	/*
	 * REQ10/REQ4
	 * invoked upon booking and at the end 
	 * the start charges deposit
	 * the end charges rate price - deposit
	 */
	public double pay(int cardNum, int ccv, String firstName, String lastName, int expiry, String address, String type) {
		Payee pay = new Payee(this.curBooking);
		return pay.pay(cardNum, ccv, firstName, lastName, expiry, address, type);
	}
	
	public void endBooking() {
		this.curBooking.endBooking();
	}
	
	/*
	 * REQ9
	 */
	public void extendBooking(int newDuration) {
		this.curBooking.extendBooking(newDuration);
	}
	
	/*
	 * the next few methods are for REQ 8
	 */
	public void cancelBooking() {
		this.curBooking.cancelBooking();
	}
	
	public void editLicesnsePlate(String plate) {
		this.curBooking.setPlate(plate);
	}
	
	public void changeSpace(int newSpace) {
		this.curBooking.setSpace(newSpace);
	}
	
	public void changeLot(Lot lot) {
		this.curBooking.setLotName(lot);
	}
}
