package com.gradusapi.apirest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "idPessoa")
public class AlunoModel extends PessoaModel{
    private String curso;

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
}
