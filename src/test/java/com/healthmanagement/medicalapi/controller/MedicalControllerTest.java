package com.healthmanagement.medicalapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.healthmanagement.medicalapi.model.Medical;
import com.healthmanagement.medicalapi.model.User;
import com.healthmanagement.medicalapi.service.MedicalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MedicalController.class)
@ActiveProfiles("test")
class MedicalControllerTest {
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    MedicalService medicalService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void saveMedical() throws Exception {
        Medical medical = this.dummyMedical();
        medical.setId(123l);
        Medical medical1 = this.dummyMedical();
        String content = objectMapper.writeValueAsString(medical1);
        when(medicalService.createMedical(any())).thenReturn(medical);
        mockMvc.perform(post("/api")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andReturn();
        verify(medicalService, times(1)).createMedical(any());
    }

    @Test
    void updateMedical() throws Exception {
        Medical medical = this.dummyMedical();
        medical.setId(123l);
        medical.setRecipe("Update recipe");
        Medical medical1 = this.dummyMedical();
        medical1.setId(123l);
        String content = objectMapper.writeValueAsString(medical1);
        when(medicalService.updateMedical(any())).thenReturn(medical);
        mockMvc.perform(put("/api/list")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
                )
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$.recipe").value("Update recipe"))
                .andReturn();
        verify(medicalService, times(1)).updateMedical(any());
    }

    @Test
    void getMedical() throws Exception {
        Medical medical = this.dummyMedical();
        medical.setId(123l);

        User user = this.userDummy();
        String content = objectMapper.writeValueAsString(user);
        when(medicalService.getMedical(any())).thenReturn(Arrays.asList(medical));
        mockMvc.perform(get("/api")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id").value(123l))
                .andReturn();
        verify(medicalService, times(1)).getMedical(any());
    }

    private Medical dummyMedical() {
        return Medical.builder().evolution("Sem dores").userId(123l).recipe("Paracetamol").build();
    }

    private User userDummy() {
        return User.builder().id(2l).fullName("Jose da Silva").build();
    }
}