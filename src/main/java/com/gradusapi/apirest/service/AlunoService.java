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

    // função "buscar todos"
    public List<AlunoModel> buscarTodos() {
        return alunoRepository.findAll();
    }

    // função "salvar"
    //---------------------------------------------------------------------------------------------------------
    public AlunoModel salvar(AlunoModel aluno) {

        if (aluno.getIdPessoa() != null) {

            if (alunoRepository.existsById(aluno.getIdPessoa())) {

                throw new IllegalStateException("ID de aluno já existente: " + aluno.getIdPessoa() +
                        ". Para atualizar um aluno, utilize o endpoint PUT /api/alunos/{id}.");
            }
        }

        aluno.setIdPessoa(null);
        return alunoRepository.save(aluno);
    }

    // função "excluir"
    //---------------------------------------------------------------------------------------------------------
    public void excluir(Long id) {

        if (!alunoRepository.existsById(id)) {

            throw new IllegalArgumentException("Falha ao excluir: Aluno com ID " + id + " não encontrado.");
        }

        alunoRepository.deleteById(id);
    }

    // função "buscar por id"
    //---------------------------------------------------------------------------------------------------------
    public AlunoModel buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluno com ID " + id + " não encontrado."));
    }

    // função "editar"
    //---------------------------------------------------------------------------------------------------------
    public AlunoModel editar(AlunoModel aluno) {
        if (aluno.getIdPessoa() == null || !alunoRepository.existsById(aluno.getIdPessoa())) {
            throw new IllegalArgumentException("Aluno não encontrado para edição");
        }
        return alunoRepository.save(aluno);
    }

    // função "buscar por nome"
    //---------------------------------------------------------------------------------------------------------
    public List<AlunoModel> buscarPorNome(String nome) {

        return alunoRepository.findByNomeEstudanteContainingIgnoreCase(nome);
    }

    // função "buscar por campus"
    //---------------------------------------------------------------------------------------------------------
    public List<AlunoModel> buscarPorCampus(String campus) {

        return alunoRepository.findByCampusContainingIgnoreCase(campus);
    }

    // função "buscar por curso"
    //---------------------------------------------------------------------------------------------------------
    public List<AlunoModel> buscarPorCurso(String curso) {
        return alunoRepository.findByCursoContainingIgnoreCase(curso);
    }

    // função "buscar por email institucional"
    //---------------------------------------------------------------------------------------------------------
    public List<AlunoModel> buscarPorEmailInstitucional(String emailInstitucional) {
        return alunoRepository.findByEmailInstitucionalContainingIgnoreCase(emailInstitucional);
    }

    // função buscar periodo de ingresso
    //---------------------------------------------------------------------------------------------------------
    public List<AlunoModel> buscarPorPeriodoIngresso(String periodoIngresso) {
        return alunoRepository.findByPeriodoEntradaContainingIgnoreCase(periodoIngresso);
    }
}
