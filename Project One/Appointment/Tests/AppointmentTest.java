package Tests;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Appointment;

class AppointmentTest {

	@Test
	void testCreateAppointmentSuccess() {
		Appointment appointment = new Appointment("12345", (new Date(12-2-2021)), "Test");
		
		assertTrue(appointment != null);
		assertTrue(appointment.getAppointmentID().equals("12345"));
		assertTrue(appointment.getAppointmentDate().equals(new Date(12-2-2021)));
		assertTrue(appointment.getAppointmentDescription().equals("Test"));
	}
	
	@Test
	void testCreateAppointmentIDFail() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345678933455", (new Date(12-2-2021)), "Test");
		});
	}
	
	@Test
	void testCreateAppointmentDateFail() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", (new Date()), "Test");
		});
	}
	
	@Test
	void  testCreateAppointmentDescriptionFail() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", (new Date(12-2-2021)), "This description name is going to be too long and throw an error");
		});
	}

}
