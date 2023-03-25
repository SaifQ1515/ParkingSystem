package manager;

import client.Client;
import lots.Lot;

public class Manager {

	protected String name;
	protected String pass;
	
	public Manager(String newName, String newPass) {
		this.name = newName;
		this.pass = newPass;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public String getPass() {
		return this.pass;
	}
	
	public void setPass(String newPass) {
		this.pass = newPass;
	}
	
	public void addLot(boolean newAvailability, int newNumSpace, String newLocation) {
		Lot newLot = new Lot(newAvailability, newNumSpace, newLocation);
	}
	
	public void removeLot(Lot lot) {
		lot = null;
	}
	
	public void disableLot(Lot lot) {
		lot.setAvailability(false);
	}
	
	public void enableLot(Lot lot) {
		lot.setAvailability(true);
	}
	
	public void disableSpace(Lot lot, int space) {
		lot.setSpot(space, false);
	}
	
	public void enableSpace(Lot lot, int space) {
		lot.setSpot(space, true);
	}
	
	public void validate(Client client) {
		client.setValidation(true);
	}

}
