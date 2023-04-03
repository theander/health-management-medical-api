package com.healthmanagement.medicalapi.service;

import com.healthmanagement.medicalapi.model.Medical;
import com.healthmanagement.medicalapi.repository.MedicalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;



@RequiredArgsConstructor
@Slf4j
@Service
public class MedicalService {

    private final MedicalRepository medicalRepository;

    public Medical createMedical(Medical medical) {
        return medicalRepository.save(medical);
    }

    public Medical updateMedical(Medical medical) {
        return medicalRepository.save(medical);
    }


    public List<Medical> getMedical(Long userId) {
        return medicalRepository.findMedicalByUserId(userId);
    }

    public void generateExams(String examName) {
    }
}
