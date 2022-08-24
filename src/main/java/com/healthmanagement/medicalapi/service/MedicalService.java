package com.healthmanagement.medicalapi.service;

import com.healthmanagement.medicalapi.model.Medical;
import com.healthmanagement.medicalapi.model.User;
import com.healthmanagement.medicalapi.repository.MedicalRepository;
import org.springframework.cache.annotation.CachePut;
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
    public Medical createMedical(Long userId, String recipe, String evolution) {
        return medicalRepository.save(new Medical(null, evolution, recipe, userId));
    }

    @Override
    @CachePut("medical")
    public Medical updateMedical(Long userId, String recipe, String evolution) {
        return medicalRepository.save(Medical.builder()
                .userId(userId)
                .evolution(evolution)
                .recipe(recipe)
                .build());
    }

    @Override
    @Cacheable("medical")
    public Medical getMedical(Long userId) {
        return medicalRepository.findMedicalByUserId(userId);
    }
    @Override
    public void generateExams(String examName) {
    }
}
