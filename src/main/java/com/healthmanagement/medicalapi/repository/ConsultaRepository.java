package com.healthmanagement.medicalapi.repository;

import com.healthmanagement.medicalapi.model.Consulta;
import com.healthmanagement.medicalapi.model.ConsultaStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ConsultaRepository extends JpaRepository<Consulta,Long> {
    List<Consulta> findAllByUsernameEqualsAndConsultaStatusEnumEquals(String username, ConsultaStatusEnum consultaStatusEnum);
    List<Consulta> findAllByMedicoEqualsAndConsultaStatusEnumEquals(String medico, ConsultaStatusEnum consultaStatusEnum);
    @Query("select count(*) from Consulta r where month(r.registerDate) = :month")
    int countForMonth(int month);
}
