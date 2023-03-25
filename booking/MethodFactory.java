package booking;

public class MethodFactory {

	public Method MethodFactory(int cardNum, int ccv, String firstName, String lastName, int expiry, String address, String type) {
		
		if(type == null)
		{
			return null;
		}
		else if (type.equalsIgnoreCase("Credit"))
		{
			
			return new Credit(cardNum, ccv, firstName, lastName, expiry, address);
		}
		else if (type.equalsIgnoreCase("Debit"))
		{
			return new Debit(cardNum, ccv, firstName, lastName, expiry, address);
		}
		else if (type.equalsIgnoreCase("Mobile"))
		{
			return new Mobile(cardNum, ccv, firstName, lastName, expiry, address);
		}
		return null;
	}

}
