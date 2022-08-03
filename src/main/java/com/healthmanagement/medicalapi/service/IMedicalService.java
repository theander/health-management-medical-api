package com.healthmanagement.medicalapi.service;

import com.healthmanagement.medicalapi.model.Medical;
import com.healthmanagement.medicalapi.model.User;

public interface IMedicalService {
    Medical createMedical(User user, String recipe, String evolution);
    Medical updateMedical(String recipe, String evolution);
    Medical getMedical(User user);
    void generateExams(String examName);

}
