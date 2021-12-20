package model;

public class Contact {
	
	private String contactID;
	private String firstName;
	private String lastName;
	private String Number;
	private String Address;
	
	public Contact(String contactID, String firstName, String lastName, String Number, String Address) {
		
		//validate inputs against requirements
		boolean isValid = validateInput(contactID, 10);
		
		if(isValid) {
			this.contactID = contactID;
		}
		
		isValid = isValid && setFirstName(firstName);
		isValid = isValid && setLastName(lastName);
		isValid = isValid && setNumber(Number);
		isValid = isValid && setAddress(Address);
		
		if(!isValid) {
			throw new IllegalArgumentException("Invalid input");
			
		}
	}
	
	public boolean setFirstName(String firstName) {
		boolean isValid = validateInput(firstName, 10);
		
		if(isValid) {
			this.firstName = firstName;
		}
		
		return isValid;
	}
	
	public boolean setLastName(String lastName) {
		boolean isValid = validateInput(lastName, 10);
		
		if(isValid) {
			this.lastName = lastName;
		}
		
		return isValid;
	}
	
	public boolean setNumber(String Number) {
		boolean isValid = Number.matches("\\d{10}");
		
		if(isValid) {
			this.Number = Number;
		}
		return isValid;
	}
	
	public boolean setAddress(String Address) {
		boolean isValid = validateInput(Address, 30);
		
		if(isValid) {
			this.Address = Address;
		}
		
		return isValid;
	}
	
	
	public String getContactID() {
		return contactID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getNumber() {
		return Number;
	}
	public String getAddress() {
		return Address;
	}
	
	private boolean validateInput(String item, int length) {
		return (item != null && item.length() <= length);
	}
}