package com.healthmanagement.medicalapi.service;

import com.healthmanagement.medicalapi.model.Medical;
import com.healthmanagement.medicalapi.model.User;
import com.healthmanagement.medicalapi.repository.MedicalRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;


@Transactional
@Service
public class MedicalService implements IMedicalService {

    private final MedicalRepository medicalRepository;

    public MedicalService(MedicalRepository medicalRepository) {
        this.medicalRepository = medicalRepository;
    }

    @Override
    public Medical createMedical(User user, String recipe, String evolution) {

        return medicalRepository.save(new Medical(null, evolution, recipe, user.getId()));
    }

    @Override
    public Medical updateMedical(String recipe, String evolution) {
        return null;
    }

    @Override
    @Cacheable
    public Medical getMedical(User user) {
        return null;
    }


    @Override
    public void generateExams(String examName) {

    }
}
