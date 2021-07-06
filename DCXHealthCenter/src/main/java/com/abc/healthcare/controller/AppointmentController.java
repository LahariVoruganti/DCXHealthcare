package com.abc.healthcare.controller;

import javax.validation.Valid;

import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.healthcare.model.Appointment;
import com.abc.healthcare.model.Doctor;
import com.abc.healthcare.model.Response;
import com.abc.healthcare.service.AppointmentService;

/**
 * 
 * @author LAHARI
 *Date : 06-Jul-2021
 */
@RestController
@Validated
@RequestMapping("/appointment")
public class AppointmentController {
	
	Response response = new Response();
	
	@Autowired
	private AppointmentService appointmentService;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(AppointmentController.class);
	
	
	@PostMapping("/saveAppointment")
	public ResponseEntity<?> addAppointment(@Valid @RequestBody Appointment appointment){
		LOGGER.info("AppointmentServiceImp::saveAppointment(Appointment appointment) method called");
		appointmentService.saveAppointment(appointment);
		response.setMsg("Hello "+appointment.getPatientId()+" Welcome to DCX HealthCare,your appointment is saved");
		response.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<>(response,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/findAppointment/{id}")
	public ResponseEntity<?> findAppointmentbyId(@Valid @Min(1) @PathVariable int id){
		LOGGER.info("AppointmentServiceImp::findAppointmentbyId(Appointment appointment) method called");
		Appointment appointment = appointmentService.findAppointmentbyId(id);
		return new ResponseEntity<>(appointment,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deleteAppointment/{id}")
	public ResponseEntity<?> deleteAppointment(@Valid @Min(1) @PathVariable int id){
		appointmentService.deleteAppointmentbyId(id);
		response.setMsg("Deleted appointment successfully");
		response.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<>(response,HttpStatus.FOUND);
	}
	
	@PutMapping("/updateAppointment")
	public ResponseEntity<?> updateAppointment(@Valid @RequestBody Appointment appointment){
		appointmentService.updateAppointmentById(appointment);
		response.setMsg("Hello, your appointment detalis with Appointment Id "+appointment.getAppointmentId()+", are updated");
		response.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<>(response,HttpStatus.FOUND);
	}
	

}
