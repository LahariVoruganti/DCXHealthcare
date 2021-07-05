package com.abc.healthcare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.abc.healthcare.entity.AppointmentEntity;
import com.abc.healthcare.entity.BillEntity;
import com.abc.healthcare.entity.DoctorEntity;
import com.abc.healthcare.entity.PatientEntity;
import com.abc.healthcare.exceptions.ResourceAlreadyExistException;
import com.abc.healthcare.exceptions.ResourceNotFoundException;
import com.abc.healthcare.model.Appointment;
import com.abc.healthcare.model.Doctor;
import com.abc.healthcare.repository.AppointmentRepository;
import com.abc.healthcare.repository.DoctorRepository;

public class AppointmentServiceImp implements AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private BillRepository billRepository;

	@Override
	public void saveAppointment(Appointment appointment) throws ResourceAlreadyExistException {
		Optional<AppointmentEntity> appointmentEntity1 = appointmentRepository.findById(appointment.getAppointmentId());
		
		if(appointmentEntity1.isPresent()) {
			throw new ResourceAlreadyExistException("Appointment already exists with this ID : "+appointment.getAppointmentId());
		}
		else {
			
			AppointmentEntity appointmentEntity = new AppointmentEntity();
			appointmentEntity.setAppointmentId(appointment.getAppointmentId());
			appointmentEntity.setAppointmentSlot(appointment.getAppointmentSlot());
			appointmentEntity.setAppointmentDate(appointment.getAppointmentDate());
			Optional<DoctorEntity> doctorEntity = doctorRepository.findById(appointment.getDoctorId());
			if(doctorEntity.isPresent()) {
				
				DoctorEntity doctorEntity1 = new DoctorEntity();
				doctorEntity1.setDoctorID(doctorEntity.get().getDoctorID());
			
				appointmentEntity.setDoctor(doctorEntity1);
				
			}
			
			Optional<PatientEntity> patientEntity = patientRepository.findById(appointment.getPatientId());
			if(patientEntity.isPresent()) {
				PatientEntity patientEntity1 = new PatientEntity();
				patientEntity1.setPatientId(patientEntity.get().getPatientId());
				
				appointmentEntity.setPatient(patientEntity1);
			}
			
			Optional<BillEntity> billEntity = billRepository.fingById(appointment.getBillId());
			if(billEntity.isPresent()) {
				
				BillEntity billEntity1 = new BillEntity();
				billEntity1.setBillId(billEntity.get().getBillId());
				
				appointmentEntity.setBill(billEntity1);
			}
			

	}

	@Override
	public Appointment findAppointmentbyId(int id) throws ResourceNotFoundException {
		Appointment appointment = new Appointment();
		Optional<AppointmentEntity> appointmentEntity = appointmentRepository.findById(id);
		if(appointmentEntity.isPresent()) {
			
			appointment.setAppointmentId(appointmentEntity.get().getAppointmentId());
			appointment.setAppointmentDate(appointmentEntity.get().getAppointmentDate());
			appointment.setAppointmentSlot(appointmentEntity.get().getAppointmentSlot());
			appointment.getDoctorId();
			appointment.getPatientId();
			appointment.getBillId();
			return appointment;
		}else {
			
			throw new ResourceNotFoundException("Cannot find appointment with this ID :"+id);
		}
		
		
	}

	@Override
	public void deleteAppointmentbyId(int id) throws ResourceNotFoundException {
		
		Optional<AppointmentEntity> appointmentEntity = appointmentRepository.findById(id);
		if(appointmentEntity.isPresent()) {
			
			appointmentRepository.deleteById(id);
		}else {
			
			throw new ResourceNotFoundException("Cannot find appointment with this ID "+id);
		}

	}

}
