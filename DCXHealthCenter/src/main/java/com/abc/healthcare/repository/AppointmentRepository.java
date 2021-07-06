package com.abc.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.healthcare.entity.AppointmentEntity;
import com.abc.healthcare.entity.DoctorEntity;

/**
 * 
 * @author LAHARI
 *Date : 06-Jul-2021
 */
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer>{

}
