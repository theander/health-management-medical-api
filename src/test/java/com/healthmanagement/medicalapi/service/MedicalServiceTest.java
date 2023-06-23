package com.healthmanagement.medicalapi.service;

import com.healthmanagement.medicalapi.model.Medical;
import com.healthmanagement.medicalapi.repository.MedicalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class MedicalServiceTest {
    @Mock
    MedicalRepository medicalRepository;
    @InjectMocks
    MedicalService medicalService;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createMedical() {
        Medical medical = this.dummyMedical();
        medical.setId(123l);
        when(medicalRepository.save(any())).thenReturn(medical);
        Medical medical1 = medicalService.createMedical(medical);
        assertThat(medical1.getId()).isNotNull();
    }

    @Test
    void updateMedical() {
        Medical medical = this.dummyMedical();
        medical.setId(123l);
        when(medicalRepository.save(any())).thenReturn(medical);
        Medical medical1 = medicalService.updateMedical(medical);
        assertThat(medical1.getId()).isNotNull();

    }

    @Test
    void getMedical() {
        Medical medical = this.dummyMedical();
        medical.setId(123l);
        when(medicalRepository.findMedicalByUserId(any())).thenReturn(Arrays.asList(medical));
        List<Medical> medical1 = medicalService.getMedical(1l);
        assertThat(medical1.size()).isGreaterThan(0);

    }

    @Test
    void generateExams() {
    }
private Medical dummyMedical(){
        return Medical.builder().userId(123l).recipe("Recipe").build();
}

}