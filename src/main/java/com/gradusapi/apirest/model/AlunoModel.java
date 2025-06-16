package com.gradusapi.apirest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "aluno") 
@PrimaryKeyJoinColumn(name = "idPessoa") 
public class AlunoModel extends PessoaModel {
    
    @NotBlank(message = "O campus não pode ser em branco")
    private String campus;

    @NotBlank(message = "O curso não pode ser em branco")
    private String curso;

    @NotBlank(message = "O email institucional não pode ser em branco")
    @Email(message = "Formato de email inválido")
    @Column(name = "email_institucional")
    private String emailInstitucional;

    @NotBlank(message = "O período de entrada não pode ser em branco")
    @Column(name = "periodo_entrada")
    private String periodoEntrada;
    
    
    private String polo;
    private String coordenacao;
    private String situacao;

    
    public String getCampus() {
        return campus;
    }
    public void setCampus(String campus) {
        this.campus = campus;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getEmailInstitucional() {
        return emailInstitucional;
    }
    public void setEmailInstitucional(String emailInstitucional) {
        this.emailInstitucional = emailInstitucional;
    }
    public String getPeriodoEntrada() {
        return periodoEntrada;
    }
    public void setPeriodoEntrada(String periodoEntrada) {
        this.periodoEntrada = periodoEntrada;
    }
    public String getPolo() {
        return polo;
    }
    public void setPolo(String polo) {
        this.polo = polo;
    }
    public String getCoordenacao() {
        return coordenacao;
    }
    public void setCoordenacao(String coordenacao) {
        this.coordenacao = coordenacao;
    }
    public String getSituacao() {
        return situacao;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}