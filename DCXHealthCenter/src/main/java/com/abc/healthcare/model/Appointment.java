package com.abc.healthcare.model;

import java.time.LocalDate;

import com.abc.healthcare.entity.PatientEntity;

public class Appointment {
	
	private int AppointmentId;
	
	private LocalDate AppointmentDate;
	
	private int AppointmentSlot;
	
	private int patientId;

	private int doctorId;
	
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
