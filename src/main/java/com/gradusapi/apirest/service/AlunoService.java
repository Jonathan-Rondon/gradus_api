package com.gradusapi.apirest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gradusapi.apirest.model.AlunoModel;
import com.gradusapi.apirest.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    //  função "buscar todos"
    public List<AlunoModel> buscarTodos() {
        return alunoRepository.findAll();
    }

    // função "inserir"
    public AlunoModel salvar(AlunoModel aluno) {
        return alunoRepository.save(aluno);
    }
}
