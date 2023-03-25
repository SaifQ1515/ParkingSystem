package lots;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Lot {

	public boolean availability; //variable for lot availability
	public int numSpace;
	public ArrayList<String> lots = new ArrayList<String>();
	public Map<Integer, Entry<String, Boolean>> tracker = new HashMap<Integer, Entry<String, Boolean>>();
	public String location; //for the string in entry (location info)
	
	public Lot(boolean newAvailability, int newNumSpace, String newLocation) {
		this.availability = newAvailability;
		this.numSpace = newNumSpace;
		this.location = newLocation;
		lots.add(location);
		
		mapCreation();
	}
	
	/*
	 * REQ7
	 * this private method makes our lot maps
	 */
	private void mapCreation() {
		for(int i = 1; i <= numSpace; i++) // 1-100
		{
			this.tracker.put(i, new SimpleEntry(this.location, true));
		}
	}
	
	public boolean getSpot(int spaceNum) {
		Entry<String, Boolean> trackerEntry = tracker.get(spaceNum);
		return trackerEntry.getValue();
	}
	
	public void setSpot(int spaceNum, boolean spotState) {
		Entry<String, Boolean> trackerEntry = tracker.get(spaceNum);
		trackerEntry.setValue(spotState);
	}
	
	public boolean getAvailability() {
		return this.availability;
	}
	
	public void setAvailability(boolean newAvail) {
		this.availability = newAvail;
	}
	
	public int getNumSpace() {
		return this.numSpace;
	}
	//no setter for numSpace
	
	public String getLocation() {
		return this.location;
	}
	
	public void setLocation(String newLocation) {
		this.location = newLocation;
	}
	
	public String getLots() {
		return lots.toString();
	}

}
