package com.healthmanagement.medicalapi.service;

import com.healthmanagement.medicalapi.model.Medical;

public interface IMedicalService {
    Medical createMedical(Long userId, String recipe, String evolution);

    Medical updateMedical(Long userId, String recipe, String evolution);

    Medical getMedical(Long userId);

    void generateExams(String examName);

}
