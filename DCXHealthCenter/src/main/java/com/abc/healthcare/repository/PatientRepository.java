package com.abc.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.abc.healthcare.entity.PatientEntity;
/**
 * @author admin
 *
 * date: Jul 5, 2021

 */
public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {

}
