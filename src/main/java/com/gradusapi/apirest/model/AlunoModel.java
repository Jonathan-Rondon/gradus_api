package com.gradusapi.apirest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class AlunoModel extends PessoaModel {

    @NotBlank(message = "O campus não pode ser em branco")
    @NotNull(message = "O campus não pode ser nulo")
    @Size(min = 3, message = "O Campus não deve ter menos que 3 caracteres.")
    private String campus;

    @NotBlank(message = "O curso não pode ser em branco")
    @NotNull(message = "O curso não pode ser nulo")
    @Size(min = 3, message = "O nome curso deve ter no mínimo de 3 caracteres.")
    private String curso;

    @NotBlank(message = "O email institucional não pode ser em branco")
    @NotNull(message = "O email institucional não pode ser nulo")
    @Email(message = "Formato de email inválido")
    @Column(name = "email_institucional")
    private String emailInstitucional;

    @NotBlank(message = "O período de entrada não pode ser em branco")
    @NotNull(message = "O período de entrada não pode ser nulo")
    @Column(name = "periodo_entrada")
    private String periodoEntrada;

    @NotBlank(message = "O campo polo não pode ser em branco")
    @NotNull(message = "O campo polo não pode ser nulo")
    @Size(min = 4, message = "A situação do aluno deve ter no mínimo 4 caracteres.")
    private String polo;

    @NotBlank(message = "O campo coordenação não pode ser em branco")
    @NotNull(message = "O campo coordenação não pode ser nulo")
    private String coordenacao;

    @NotBlank(message = "A informação situação do aluno não pode ser em branco")
    @NotNull(message = "A informação situação do aluno não pode ser nula")
    @Pattern(regexp = "Matriculado|Trancado|Evadido|Formado|Em Curso", message = "A situação deve ser uma das seguintes: Matriculado,Em Curso, Trancado, Evadido, Formado.")
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