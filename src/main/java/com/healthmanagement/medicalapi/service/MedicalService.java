package com.healthmanagement.medicalapi.service;

import com.healthmanagement.medicalapi.model.Medical;
import com.healthmanagement.medicalapi.repository.MedicalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


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
    public Map<Integer,Integer> countMedicalByMonth() {
        Map<Integer,Integer> map = new HashMap<>();
        Stream<Month> stream = Arrays.stream(Month.values());
        stream.forEach(month -> {
            int o = medicalRepository.countForMonth(month.getValue());
            map.put(month.getValue(),o);
        });
        return map;
    }
}
