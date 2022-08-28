package com.healthmanagement.medicalapi.service;

import com.healthmanagement.medicalapi.model.Medical;
import com.healthmanagement.medicalapi.repository.MedicalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.ClientInfoStatus;
import java.util.List;


@Transactional
@RequiredArgsConstructor
@Slf4j
@Service
public class MedicalService implements IMedicalService {

    private final MedicalRepository medicalRepository;

    @Override
    public Medical createMedical(Medical medical) {
        return medicalRepository.save(medical);
    }

    @Override
    //@CachePut(cacheNames = "medical", key = "#medical.userId")
    @CacheEvict(cacheNames = "medical", key="#userId")
    public Medical updateMedical(Medical medical) {
        return medicalRepository.save(medical);
    }

    @Override
    @Cacheable(cacheNames = "medical", key = "#userId")
    public List<Medical> getMedical(Long userId) {
        return medicalRepository.findMedicalByUserId(userId);
    }

    @Override
    public void generateExams(String examName) {
    }
}
