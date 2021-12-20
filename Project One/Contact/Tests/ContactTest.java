package Tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Contact;

class ContactTest {
 
	@Test
	void testContact() {
		Contact contact = new Contact("12345", "Tyler", "Bennett", "9892871854", "Portland");
		
		assertTrue(contact != null);
		assertTrue(contact.getContactID().equals("12345"));
		assertTrue(contact.getFirstName().equals("Tyler"));
		assertTrue(contact.getLastName().equals("Bennett"));
		assertTrue(contact.getNumber().equals("9892871854"));
		assertTrue(contact.getAddress().equals("Portland"));
	}
	
	@Test
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678912345", "Tyler", "Bennett", "9892871854", "Portland");
		});
	}
	
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Tylerrrrrrr", "Bennett", "9892871854", "Portland");
		});
	}
	
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Tyler", "Bennetttttt", "9892871854", "Portland");
		});
	}
	
	@Test
	void testContactNumberTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Tyler", "Bennett", "989287185", "Portland");
		});
	}
	
	@Test
	void testContactNumberTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Tyler", "Bennett", "98928718545", "Portland");
		});
	}
	@Test
	void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Tyler", "Bennett", "9892871854", "Portland Oregon, United States of America ");
		});
	}

}
