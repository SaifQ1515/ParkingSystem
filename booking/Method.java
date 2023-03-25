package booking;

public abstract class Method {

	protected int cardNum;
	protected int ccv;
	protected String firstName;
	protected String lastName;
	protected int expiry;
	protected String address;
	
	public Method(int cardNum, int ccv, String firstName, String lastName, int expiry, String address) {
        this.cardNum = cardNum;
        this.ccv = ccv;
        this.firstName = firstName;
        this.lastName = lastName;
        this.expiry = expiry;
        this.address = address;
	}

    public int getCardNum() {
        return cardNum;
    }
    
    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }
    
    public int getCcv() {
        return ccv;
    }
    
    public void setCcv(int ccv) {
        this.ccv = ccv;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public int getExpiry() {
        return expiry;
    }
    
    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void charge() {
    	//this method would connect to some exterior payment window
    }
}
