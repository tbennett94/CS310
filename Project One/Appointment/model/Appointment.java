package model;

import java.util.Date;

public class Appointment {
	private String appointmentID;
	private Date appointmentDate;
	private String appointmentDescription;
	
	public Appointment(String appointmentID, Date appointmentDate, String appointmentDescription) {
		
		
		//validate inputs against requirements
		boolean isValid = validateInput(appointmentID, 10);
		
		if(isValid) {
			this.appointmentID = appointmentID;
		}
		
		isValid = isValid && setAppointmentDate(appointmentDate);
		isValid = isValid && setAppointmentDescription(appointmentDescription);
		
		if(!isValid) {
			throw new IllegalArgumentException("Invalid input");
		}
		
	}


	public boolean setAppointmentDate(Date appointmentDate) {
		boolean isValid = validateInput(appointmentDate, appointmentDate);
		
		if(isValid) {
			this.appointmentDate = appointmentDate;
		}
		return isValid;
		
	}
	
	private boolean validateInput(Date appointmentDate, Date date) {
		//Date setAppointmentDate = null;
		return (appointmentDate != null && appointmentDate.before(new Date()));
	}


	public boolean setAppointmentDescription(String appointmentDescription) {
		boolean isValid = validateInput(appointmentDescription, 50);
		
		if(isValid) {
			this.appointmentDescription = appointmentDescription;
		}
		return isValid;
	}
	
	public String getAppointmentID() {
		return appointmentID;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public String getAppointmentDescription() {
		return appointmentDescription;
	}
	
	private boolean validateInput(String item, int length) {
		return (item != null && item.length() <= length);
	}

}
