package com.healthmanagement.medicalapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.healthmanagement.medicalapi.model.Medical;
import com.healthmanagement.medicalapi.model.User;
import com.healthmanagement.medicalapi.repository.MedicalRepository;
import com.healthmanagement.medicalapi.service.MedicalService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MedicalController.class)
public class MedicalControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    private MedicalService medicalService;

    //@Test
    void testSaveMedical() throws Exception {

    }

    //@Test
    void updateMedical() {
    }

    //@Test
    void testGetMedical() throws Exception {
        User user = User.builder()
                .id(5l)
                .build();
        String userJson = objectMapper.writeValueAsString(user);
        mockMvc.perform(get("/api").content(userJson)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testGetStatusMedical() throws Exception {
        Medical m1 = Medical.builder()
                .evolution("dfgdfg")
                .recipe("DSFG")
                .userId(5L)
                .build();
        given(medicalService.getMedical(5L)).willReturn(List.of(m1));
        mockMvc.perform(get("/api/status").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
