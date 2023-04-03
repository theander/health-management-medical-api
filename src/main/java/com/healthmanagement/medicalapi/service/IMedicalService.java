package com.healthmanagement.medicalapi.service;

import com.healthmanagement.medicalapi.model.Medical;

import java.util.List;

public interface IMedicalService {
    Medical createMedical(Medical medical);

    Medical updateMedical(Medical medical);

    List<Medical> getMedical(Long userId);

    void generateExams(String examName);

}
