package com.healthmanagement.medicalapi.repository;

import com.healthmanagement.medicalapi.model.Medical;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicalRepository extends JpaRepository<Medical, Long> {
    Medical findMedicalByUserId(Long userId);



}
