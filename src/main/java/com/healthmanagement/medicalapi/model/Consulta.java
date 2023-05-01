package com.healthmanagement.medicalapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Consulta implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String medico;
    private String description;
    private ConsultaStatusEnum consultaStatusEnum;
    @Column(name = "data_cadastro",updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate creationDate;

    @PrePersist
    public void prePersiste() {
        setCreationDate(LocalDate.now());
    }
}
