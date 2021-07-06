package com.abc.healthcare.model;

import java.time.LocalDate;


import javax.validation.constraints.NotNull;

import com.abc.healthcare.entity.PatientEntity;

/**
 * 
 * @author LAHARI
 *Date : 06-Jul-2021
 */
public class Appointment {
	
	@NotNull(message = "please provide id")
	private int AppointmentId;
	
	@NotNull(message = "please provide date")
	private LocalDate AppointmentDate;
	
	@NotNull(message = "please provide slot")
	private int AppointmentSlot;
	
	@NotNull(message = "please provide Patient id")
	private int patientId;
	
	@NotNull(message = "please provide Doctor id")
	private int doctorId;
	
	@NotNull(message = "please provide Bill id")
	private int billId;

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getAppointmentId() {
		return AppointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		AppointmentId = appointmentId;
	}

	public LocalDate getAppointmentDate() {
		return AppointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		AppointmentDate = appointmentDate;
	}

	public int getAppointmentSlot() {
		return AppointmentSlot;
	}

	public void setAppointmentSlot(int appointmentSlot) {
		AppointmentSlot = appointmentSlot;
	}

	
	
	
}
