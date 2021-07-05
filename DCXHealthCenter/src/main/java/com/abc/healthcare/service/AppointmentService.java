package com.abc.healthcare.service;

import com.abc.healthcare.exceptions.ResourceAlreadyExistException;
import com.abc.healthcare.exceptions.ResourceNotFoundException;
import com.abc.healthcare.model.Appointment;
import com.abc.healthcare.model.Doctor;

public interface AppointmentService {
	
	public void saveAppointment(Appointment appointment) throws ResourceAlreadyExistException;
	
	 public Appointment findAppointmentbyId(int id) throws ResourceNotFoundException;
	 
	 public void deleteAppointmentbyId(int id)throws ResourceNotFoundException;
	 
	 public void update

}
