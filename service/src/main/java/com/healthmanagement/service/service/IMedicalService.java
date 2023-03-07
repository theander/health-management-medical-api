package com.healthmanagement.service.service;

import com.healthmanagement.service.model.Medical;

import java.util.List;

public interface IMedicalService {
    Medical createMedical(Medical medical);

    Medical updateMedical(Medical medical);

    List<Medical> getMedical(Long userId);

    void generateExams(String examName);

}
