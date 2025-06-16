package com.gradusapi.apirest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gradusapi.apirest.model.AlunoModel;
import com.gradusapi.apirest.repository.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public String salvar(AlunoModel aluno){
        try {
            alunoRepository.saveAndFlush(aluno);
            return "Salvo com sucesso!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    public Optional<AlunoModel> buscarPorId(Long id){
        return alunoRepository.findById(id);
    }

}
