package Tests;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.Appointment;
import model.AppointmentService;

class AppointmentServiceTest {
	
	private static AppointmentService appointments;
	
	@BeforeAll
	
	static void setup() {
		appointments = AppointmentService.getService();
	}

	@Test
	void testAddAppointmentSuccess() {
		Appointment appointment = new Appointment("12345", (new Date(12-3-2021)), "Appointment Description");
		assertTrue(appointments.addAppointment(appointment));
		
		Appointment cachedAppointment = appointments.getAppointment(appointment.getAppointmentID());
		
		assertTrue(cachedAppointment != null);
		assertTrue(cachedAppointment.getAppointmentID().equals("12345"));
		assertTrue(cachedAppointment.getAppointmentDate().equals(new Date(12-3-2021)));
		assertTrue(cachedAppointment.getAppointmentDescription().equals("Appointment Description"));
	}
	
	@Test
	void testAppointmentDeletionSuccess() {
		Appointment appointment1 = new Appointment("123", (new Date(12-3-2021)), "Appointment Description");
		
		assertTrue(appointments.addAppointment(appointment1));
		
		//appointment1 = appointments.getAppointment(appointment1.getAppointmentID());
		assertTrue(appointment1 != null);
		
		assertTrue(appointments.deleteAppointment(appointment1.getAppointmentID()));
		assertTrue(appointments.getAppointment(appointment1.getAppointmentID()) == null);
		
	}
	@Test
	void testDeleteAppointmentFail() {
		String invalidAppointmentID = "123";
		
		assertFalse(appointments.deleteAppointment(invalidAppointmentID));
		
	}

	public static AppointmentService getAppointments() {
		return appointments;
	}

	public static void setAppointments(AppointmentService appointments) {
		AppointmentServiceTest.appointments = appointments;
	}


}
