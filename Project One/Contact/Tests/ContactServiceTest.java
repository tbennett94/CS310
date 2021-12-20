package Tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.Contact;
import model.ContactService;

class ContactServiceTest {

	private static ContactService contacts;
	
	@BeforeAll
	
	static void setup() {
		contacts = ContactService.getService();
	}
	
	@Test
	void testAddContactSuccess() {
		Contact contact = new Contact("12345", "Tyler", "Bennett", "9892871854", "Test Address");
		assertTrue(contacts.addContact(contact));
		
		Contact cachedContact = contacts.getContact(contact.getContactID());
		
		assertTrue(cachedContact != null);
		assertTrue(cachedContact.getContactID().equals("12345"));
		assertTrue(cachedContact.getFirstName().equals("Tyler"));
		assertTrue(cachedContact.getLastName().equals("Bennett"));
		assertTrue(cachedContact.getNumber().equals("9892871854"));
		assertTrue(cachedContact.getAddress().equals("Test Address"));
	}
	
	@Test
	void testContactDeletionSuccess() {
		Contact contact = new Contact("123", "Tyler", "Bennett", "9892871854", "Test Addy");
		
		assertTrue(contacts.addContact(contact));
		
		assertTrue(contact != null);
		
		assertTrue(contacts.deleteContact(contact.getContactID()));
		assertTrue(contacts.getContact(contact.getContactID()) == null);
	}
	
	@Test
	void testContactDeletionFailure() {
		String invalidContactID = "111";
		
		assertFalse(contacts.deleteContact(invalidContactID));
		
	}
	
	@Test
	void testContactUpdate() {
		Contact contact = new Contact("1234", "Test", "Contact", "1234567890", "Test addy");
		
		assertTrue(contacts.addContact(contact));
		Contact updateContact = contacts.getContact(contact.getContactID());
		
		updateContact.setNumber("9892871854");
		updateContact = contacts.getContact(updateContact.getContactID());
		assertTrue(updateContact.getNumber().equals("9892871854"));
	}
	

}
