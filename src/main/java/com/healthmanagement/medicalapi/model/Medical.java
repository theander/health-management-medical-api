package com.healthmanagement.medicalapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Medical {

    private Long id;
    private String evolution;
    private String recipe;
    private User user;
}
