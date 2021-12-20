package model;

import java.util.HashMap;
import java.util.Map;

import model.Appointment;

public class AppointmentService {
	
	private static AppointmentService reference = new AppointmentService();
	private final Map<String, Appointment> appointments;
	
	AppointmentService() {
		this.appointments = new HashMap<String, Appointment>();
		
	}
	
	public static AppointmentService getService() {
		return reference;
	}
	
	public boolean addAppointment(Appointment appointment) {
		boolean isSuccess = false;
		
		if(!appointments.containsKey(appointment.getAppointmentID())) {
			appointments.put(appointment.getAppointmentID(), appointment);
			isSuccess = true;
		}
		
		return isSuccess;
	}
	
	public boolean deleteAppointment(String appointmentID) {
		return appointments.remove(appointmentID) != null;
	}
	
	public Appointment getAppointment(String appointmentID) {
		return appointments.get(appointmentID);
	}

}
