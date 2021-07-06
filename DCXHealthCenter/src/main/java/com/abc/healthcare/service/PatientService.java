package com.abc.healthcare.service;

import com.abc.healthcare.exceptions.ResourceAlreadyExistException;
import com.abc.healthcare.exceptions.ResourceNotFoundException;
import com.abc.healthcare.model.Patient;

/**
 * 
 * @author admin
 *
 * date: Jul 5, 2021

 */

public interface PatientService {
	
	/**
	 * Method to save the Patient Details
	 * @param doctor
	 * @throws ResourceAlreadyExistingException
	 */
	
	 public void savePatient(Patient patient) throws ResourceAlreadyExistException;
	 /**
	  * Method to find Patient Details by using ID
	  * @param id
	  * @return patient
	  * @throws ResourceNotFoundException
	  */
	 
	 public Patient findPatientbyId(int id) throws ResourceNotFoundException;
	 /**
	  * Method to delete Patient Details by using ID
	  * @param id
	  * @throws ResourceNotFoundException
	  */
	 
	 public void deletePatientbyId(int id)throws ResourceNotFoundException;
	 /**
	  * Method to update Patient Details
	  * @param patient
	  * @throws ResourceAlreadyExistingException
	  */
	 
	 public void updatePatient(Patient patient) throws ResourceNotFoundException;


}
