package com.healthmanagement.medicalapi.repository;

import com.healthmanagement.medicalapi.model.Medical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MedicalRepository extends JpaRepository<Medical, Long> {

    List<Medical> findMedicalByUserId(Long userId);
    @Query("select count(*) from Medical r where month(r.registerDate) = :month")
    int countForMonth(int month);
}
