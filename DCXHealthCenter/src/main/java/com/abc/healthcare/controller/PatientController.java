package com.abc.healthcare.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.healthcare.model.Patient;
import com.abc.healthcare.model.Response;
import com.abc.healthcare.service.PatientService;

/**
 * @author admin
 *
 * date: Jul 5, 2021

 */

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	Response response = new Response();
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/save")
	public ResponseEntity<?> addProduct(@Valid @RequestBody Patient patient) {		
		patientService.savePatient(patient);
		return new ResponseEntity<>(patient.getPatientName()+" Your Profile is Saved Successfully",HttpStatus.CREATED);
	}
	
	@PostMapping("/find/{id}")
	public ResponseEntity<?> findPatient(@Valid @Min(1) @PathVariable int id){
		Patient patient= patientService.findPatientbyId(id);
		return new ResponseEntity<>(patient,HttpStatus.FOUND);

}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePatient(@Valid @Min(1) @PathVariable int id){
		patientService.deletePatientbyId(id);
		response.setMsg("Deleted successfully");
		response.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<>(response,HttpStatus.FOUND);
	}
	@PostMapping("/update")
	public ResponseEntity<?> updateProduct(@Valid @RequestBody Patient patient) {		
		patientService.updatePatient(patient);
		return new ResponseEntity<>(patient.getPatientName()+" Your Profile is Updated Successfully",HttpStatus.CREATED);
	}

}
