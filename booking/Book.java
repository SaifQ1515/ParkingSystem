package booking;

import lots.*;
import client.*;
import manager.*;

public class Book {

	public Lot lotName;
	public int space;
	public int duration;
	public String plate;
	public Client curClient;
	public int time = 0; //used to help us determine a clock (set to duration to simulate end of booking)
	public boolean inUse; //check if car is using spot
	public String carInfo;
	public double deposit;
	
	public Book(Client newClient, Lot lot, int spaceNum, int dur, String lplate) {
		this.curClient = newClient;
		this.lotName = lot;
		this.space = spaceNum;
		this.duration = dur;
		this.plate = lplate;
		
		checkPlate();
		checkAvailability();
	}
	
	public Lot getLotName() {
		return this.lotName;
	}
	
	public void setLotName(Lot newLotName) {
		this.lotName.setSpot(this.space, true); //when you change spots, it ensure the previous one changes to empty status
		this.lotName = newLotName;
		this.lotName.setSpot(this.space, false);
	}
	
	public int getSpace() {
		return this.space;
	}

	public void setSpace(int newSpace) {
		this.lotName.setSpot(this.space, true); //when you change spots, it ensure the previous one changes to empty status
		this.space = newSpace;
		this.lotName.setSpot(this.space, false); //then you change the new spot to booked
	}
	
	public int getDuration() {
		return this.duration;
	}
	
	public void setDuration(int newDur) {
		this.duration = newDur;
	}
	
	public String getPlate() {
		return this.plate;
	}
	
	public void setPlate(String newPlate) {
		this.plate = newPlate;
	}
	
	public Client getClient() {
		return this.curClient;
	}
	
	public void setClient(Client newClient) {
		this.curClient = newClient;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public void setTime(int newTime) {
		this.time = newTime;
	}
	
	public boolean getInUse() {
		return this.inUse;
	}
	
	public void setInUse(boolean usingState) {
		this.inUse = usingState;
	}
	
	public String getCarInfo() {
		return this.carInfo;
	}
	
	public void setCarInfo(String newCarInfo) {
		this.carInfo = newCarInfo;
	}
	
	public double getDeposit() {
		return this.deposit;
	}
	
	public void setDeposit(double newDepo) {
		this.deposit = newDepo;
	}
	
	public void book() {
		this.lotName.setSpot(space, false);
		this.deposit = this.curClient.getRate();
	}
	
	public void cancelBooking() {
		this.time = 0;
	}
	
	/*
	 * REQ 8
	 * check if plate valid
	 */
	public boolean checkPlate() {
		if(this.plate.length() > 2 && this.plate.length() < 8) //make sure its between 2 and 8 characters
		{
			return true;
		}
		else
		{
			System.out.println("please enter a valid license plate");
			return false;
		}
		
	}
	
	public void extendBooking(int newDuration) {
		this.duration = this.duration + newDuration;
	}
	
	/*
	 * method to demonstrate what happens when booking ends
	 * would be called at the end of clock time
	 */
	public void endBooking() {
		this.time = this.duration;
	}

	/*
	 * method to check if the spot is available inside the given lot
	 */
	public boolean checkAvailability() {
		
		if(this.lotName.getAvailability() == true)
		{
			if(this.lotName.getSpot(space) == true) //while parking space is not taken
			{
				return true;
			}
			else
			{
				System.out.println("please select a different spot and try again");
				return false;
			}
		}
		else
		{
			System.out.println("please select a different lot and try again");
			return false;
		}
		
		
	}
	
	/*
	 * REQ 5
	 * this method is used to see if car in spot, collect car info
	 */
	public boolean scanSpot() {
		//here we assume some detection result from camera
		this.carInfo = "camera detection info:...";
		
		//here we make an assumption that inUse is altered based on some camera detection system
		if (this.inUse == true)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
