package com.healthmanagement.medicalapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Medical implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String evolution;
    private String recipe;
    private Long userId;
    private OffsetDateTime registerDate;
}
