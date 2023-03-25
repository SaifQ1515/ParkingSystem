package manager;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

import iterator.Container;
import iterator.Iterator;

public class SuperManager implements Container{

	private static String name;
	private static String pass;
	private static SuperManager instance;
	public ArrayList<String> manList = new ArrayList<String>();
	
	private SuperManager(String newName, String newPass) {
		SuperManager.name = newName;
		SuperManager.pass = newPass;
	}
	
	public static SuperManager getInstance() {
		if(SuperManager.instance == null)
		{
			SuperManager.instance = new SuperManager("admin","admin");
		}
		return SuperManager.instance;
	}
	
	public String getName() {
		return SuperManager.name;
	}
	
	public void setName(String newName) {
		SuperManager.name = newName;
	}
	
	public String getPass() {
		return SuperManager.pass;
	}
	
	public void setPass(String newPass) {
		SuperManager.pass = newPass;
	}
	
	/*
	 * REQ2
	 */
	public Manager genManager() {
		String name = generateRandomString(5);
		String pass = generateRandomString(5);
		String concat = "["+ name + ", " + pass + "]";
		
		Manager newMan = new Manager(name,pass);
		manList.add(concat);
		
		System.out.println("the user is: " + newMan.getName());
		System.out.println("the pass is: " + newMan.getPass());
		return newMan;

	}
	
	public void getManagerList() {
		SuperManager temp = SuperManager.getInstance();
	    Iterator iter = temp.getIterator();

	    int i = 0;
	    while(iter.hasNext()) {
	        System.out.println(manList.get(i));
	        i++;
	        iter.next();
	    }
	}
	
	private static String generateRandomString(int length) {
	        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
	        String numbers = "0123456789";
	        String symbols = "!@#$%^&*_=+-/";

	        String availableChars = uppercaseLetters + lowercaseLetters + numbers + symbols;

	        SecureRandom random = new SecureRandom();
	        StringBuilder sb = new StringBuilder();

	        // add at least one uppercase letter
	        sb.append(uppercaseLetters.charAt(random.nextInt(uppercaseLetters.length())));

	        // add at least one lowercase letter
	        sb.append(lowercaseLetters.charAt(random.nextInt(lowercaseLetters.length())));

	        // add at least one number
	        sb.append(numbers.charAt(random.nextInt(numbers.length())));

	        // add at least one symbol
	        sb.append(symbols.charAt(random.nextInt(symbols.length())));

	        // add remaining characters randomly
	        for (int i = 4; i < length; i++) {
	            sb.append(availableChars.charAt(random.nextInt(availableChars.length())));
	        }

	        // shuffle the characters to make it more random
	        String shuffledString = shuffleString(sb.toString());
	        return shuffledString;
	    }

	    private static String shuffleString(String string) {
	        char[] chars = string.toCharArray();
	        Random random = new Random();
	        for (int i = chars.length - 1; i > 0; i--) {
	            int index = random.nextInt(i + 1);
	            char temp = chars[index];
	            chars[index] = chars[i];
	            chars[i] = temp;
	        }
	        return new String(chars);
	    }
	    
		//Iterator Implementation for Products
		@Override
		public Iterator getIterator() {
			return new SuperIterator();
		}
		
		private class SuperIterator implements Iterator{

		      int index;

		      @Override
		      public boolean hasNext() {
		      
		         if(index < manList.size()){
		            return true;
		         }
		         return false;
		      }

		      @Override
		      public Object next() {
		      
		         if(this.hasNext()){
		            return manList.get(index++);
		         }
		         return null;
			}
			
		}

}
