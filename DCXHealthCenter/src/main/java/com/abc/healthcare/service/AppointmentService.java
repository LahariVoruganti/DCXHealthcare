package com.abc.healthcare.service;

import java.util.List;

import com.abc.healthcare.exceptions.ResourceAlreadyExistException;

import com.abc.healthcare.exceptions.ResourceNotFoundException;
import com.abc.healthcare.model.Appointment;
import com.abc.healthcare.model.Doctor;

/**
 * 
 * @author LAHARI
 *Date : 05-Jul-2021
 */
public interface AppointmentService {
	
	/**
	 * 
	 * @param appointment
	 * @throws ResourceAlreadyExistException
	 */
	public void saveAppointment(Appointment appointment) throws ResourceAlreadyExistException;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws ResourceNotFoundException
	 */
	 public Appointment findAppointmentbyId(int id) throws ResourceNotFoundException;
	 
	 /**
	  * 
	  * @param id
	  * @throws ResourceNotFoundException
	  */
	 public void deleteAppointmentbyId(int id)throws ResourceNotFoundException;
	 
	 /**
	  * 
	  * @param name
	  * @return
	  * @throws ResourceNotFoundException
	  */
	 public List<Appointment> findByDoctorName(String name) throws ResourceNotFoundException;
	 
	 /**
	  * 
	  * @param appointment
	  * @throws ResourceNotFoundException
	  */
	 public void updateAppointmentById(Appointment appointment) throws ResourceNotFoundException;
}
