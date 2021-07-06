package com.abc.healthcare.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.healthcare.entity.AppointmentEntity;
import com.abc.healthcare.entity.BillEntity;
import com.abc.healthcare.entity.DoctorEntity;
import com.abc.healthcare.entity.PatientEntity;
import com.abc.healthcare.exceptions.ResourceAlreadyExistException;
import com.abc.healthcare.exceptions.ResourceNotFoundException;
import com.abc.healthcare.model.Appointment;
import com.abc.healthcare.model.Doctor;
import com.abc.healthcare.repository.AppointmentRepository;
import com.abc.healthcare.repository.BillRepository;
import com.abc.healthcare.repository.DoctorRepository;
import com.abc.healthcare.repository.PatientRepository;

/**
 * 
 * @author LAHARI
 *Date : 06-July-2021
 */
@Service
public class AppointmentServiceImp implements AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private BillRepository billRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentServiceImp.class);

	/**
	 * Implements Save Appointment Details  from AppointmentService Interface
	 * {@inheritdoc}
	 */
	@Override
	public void saveAppointment(Appointment appointment) throws ResourceAlreadyExistException {
		
		LOGGER.info("appointmentRepository::findById(int id)method called");
		Optional<AppointmentEntity> appointmentEntity1 = appointmentRepository.findById(appointment.getAppointmentId());
		LOGGER.info("Optional<Appointment> object saved");
		if(appointmentEntity1.isPresent()) {
			LOGGER.error("ResourceAlreadyExistException encountered with id"+appointment.getAppointmentId());
			throw new ResourceAlreadyExistException("Appointment already exists with this ID : "+appointment.getAppointmentId());
		}
		else {
			
//			AppointmentEntity appointmentEntity = convertModeltoEntity(appointment);
//			appointmentRepository.save(appointmentEntity);
//			LOGGER.info("appointment details saved in repository");
			
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
			
			Optional<BillEntity> billEntity = billRepository.findById(appointment.getBillId());
			if(billEntity.isPresent()) {
				
				BillEntity billEntity1 = new BillEntity();
				billEntity1.setBillId(billEntity.get().getBillId());
				
				appointmentEntity.setBill(billEntity1);
			}
			LOGGER.info("Appointment details saved in repository");
		}
		LOGGER.info("Exiting from AppointmentServiceImp::saveAppointment(Appointment appointment)method");
	}


	/**
	 *Implements Find Appointment by Id from AppointmentService Interface
	 * {@inheritdoc}
	 */
	@Override
	public Appointment findAppointmentbyId(int id) throws ResourceNotFoundException {
		Appointment appointment = new Appointment();
		
		LOGGER.info("appointmentRepository::findById method called from AppointmentService::findAppointmentbyId");
		Optional<AppointmentEntity> appointmentEntity = appointmentRepository.findById(id);
		if(appointmentEntity.isPresent()) {
			
			appointment.setAppointmentId(appointmentEntity.get().getAppointmentId());
			appointment.setAppointmentDate(appointmentEntity.get().getAppointmentDate());
			appointment.setAppointmentSlot(appointmentEntity.get().getAppointmentSlot());
			appointment.getDoctorId();
			appointment.getPatientId();
			appointment.getBillId();
			return appointment;

		}
		else 
		{
			LOGGER.error("ResourceNotFoundException encountered with ID "+id);
			throw new ResourceNotFoundException("Cannot find appointment with this ID :"+id);
		}
		
	}

	/**
	 *Implements delete Appointment by Id from AppointmentService Interface
	 * {@inheritdoc}
	 */
	@Override
	public void deleteAppointmentbyId(int id) throws ResourceNotFoundException {
		LOGGER.info("FindById method called from AppointmentServiceImp::deleteAppointmentbyId method");
		Optional<AppointmentEntity> appointmentEntity = appointmentRepository.findById(id);
		if(appointmentEntity.isPresent()) {
			
			appointmentRepository.deleteById(id);
			LOGGER.info("DELETED the given Appointment Details");
		}else {
			LOGGER.error("ResourceNotFoundException encountered with ID "+id);
			throw new ResourceNotFoundException("Cannot find appointment with this ID "+id);
		}
		LOGGER.info("Exiting from AppointmentServiceImp::deleteAppointmentbyId(int id)method");
	}

	/**
	 *Implements updates Appointment by Id from AppointmentService Interface
	 * {@inheritdoc}
	 */
	@Override
	public void updateAppointmentById(Appointment appointment) throws ResourceNotFoundException {
		
		LOGGER.info("FindById method called from AppointmentServiceImp::updateAppointmentbyId method");
		AppointmentEntity appointmentEntity = appointmentRepository.findById(appointment.getAppointmentId()).get();
		
		if( appointmentEntity == null) {
			LOGGER.error("ResourceNotFoundException encountered with id "+appointment.getAppointmentId());
			throw new ResourceNotFoundException("Cannot find appointment with this ID "+appointment);
		}
		else {
			AppointmentEntity appointmentEntity1 = new AppointmentEntity();
			appointmentEntity1.setAppointmentId(appointment.getAppointmentId());
			appointmentEntity1.setAppointmentSlot(appointment.getAppointmentSlot());
			appointmentEntity1.setAppointmentDate(appointment.getAppointmentDate());
			Optional<DoctorEntity> doctorEntity = doctorRepository.findById(appointment.getDoctorId());
			if(doctorEntity.isPresent()) {
				
				DoctorEntity doctorEntity1 = new DoctorEntity();
				doctorEntity1.setDoctorID(doctorEntity.get().getDoctorID());
			
				appointmentEntity1.setDoctor(doctorEntity1);
			}
			
			
			Optional<PatientEntity> patientEntity = patientRepository.findById(appointment.getPatientId());
			if(patientEntity.isPresent()) {
				PatientEntity patientEntity1 = new PatientEntity();
				patientEntity1.setPatientId(patientEntity.get().getPatientId());
				
				appointmentEntity1.setPatient(patientEntity1);
			}
			
			Optional<BillEntity> billEntity = billRepository.findById(appointment.getBillId());
			if(billEntity.isPresent()) {
				
				BillEntity billEntity1 = new BillEntity();
				billEntity1.setBillId(billEntity.get().getBillId());
				
				appointmentEntity1.setBill(billEntity1);
			}
			LOGGER.info("Appointment Details are updated");
		}
		LOGGER.info("Exiting from AppointmentServiceImp::updateAppointmentbyId(Appointment appointment)method ");
		
	}

	@Override
	public List<Appointment> findByDoctorName(String name) throws ResourceNotFoundException {
		
		
		
		return null;
	}

}
