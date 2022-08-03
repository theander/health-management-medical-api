package com.healthmanagement.medicalapi.service;

import com.healthmanagement.medicalapi.model.Medical;
import com.healthmanagement.medicalapi.model.User;
import org.springframework.stereotype.Service;

@Service
public class MedicalService implements IMedicalService {


    @Override
    public Medical createMedical(User user, String recipe, String evolution) {
        return null;
    }

    @Override
    public Medical updateMedical(String recipe, String evolution) {
        return null;
    }

    @Override
    public Medical getMedical(User user) {
        return null;
    }


    @Override
    public void generateExams(String examName) {

    }
}
