package model;


import java.util.HashMap;
import java.util.Map;


public class ContactService{
	
	private static ContactService reference = new ContactService();
	private final Map<String, Contact> contacts;
	
	ContactService() {
		this.contacts = new HashMap<String, Contact>();
	}
	
	public static ContactService getService() {
		return reference;
	}
	
	public boolean addContact(Contact contact) {
		boolean isSuccess = false;
		
		if(!contacts.containsKey(contact.getContactID())) {
			contacts.put(contact.getContactID(), contact);
			isSuccess = true;
		}
		
		return isSuccess;
	}
	
	public boolean deleteContact(String ContactID) {
		return contacts.remove(ContactID) != null;
	}
	
	public boolean updateContact(Contact contact) {
		boolean isSuccess = false;
		
		if(contacts.containsKey(contact.getContactID())) {
			contacts.replace(contact.getFirstName(), contact);
			contacts.replace(contact.getLastName(), contact);
			contacts.replace(contact.getNumber(), contact);
			contacts.replace(contact.getAddress(), contact);
			isSuccess = true;
		}
		
		return isSuccess;
		
	}
			
	
	public Contact getContact(String contactID) {
		return contacts.get(contactID);
	}
}
	
	
	
	
