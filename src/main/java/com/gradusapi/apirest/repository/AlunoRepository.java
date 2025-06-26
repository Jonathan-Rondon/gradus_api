package com.gradusapi.apirest.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gradusapi.apirest.model.AlunoModel;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {

    List<AlunoModel> findByNomeEstudanteContainingIgnoreCase(String nomeEstudante);

    List<AlunoModel> findByCursoContainingIgnoreCase(String curso);

    List<AlunoModel> findByCampusContainingIgnoreCase(String campus);

    List<AlunoModel> findByPeriodoEntradaContainingIgnoreCase(String periodoEntrada);

    List<AlunoModel> findByEmailInstitucionalContainingIgnoreCase(String emailInstitucional);

}
