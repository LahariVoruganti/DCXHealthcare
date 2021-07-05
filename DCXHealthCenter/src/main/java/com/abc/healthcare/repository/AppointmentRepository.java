package com.abc.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.healthcare.entity.AppointmentEntity;
import com.abc.healthcare.entity.DoctorEntity;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer>{

}
