package client;

public class Visitors extends Client {

	public Visitors(String newEmail, String newPass) {
		super(newEmail, newPass, 15);
		this.validated = true;
	}

}
