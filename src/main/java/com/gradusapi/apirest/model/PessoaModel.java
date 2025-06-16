package com.gradusapi.apirest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;

    
    @NotBlank(message = "O nome do estudante não pode ser branco")
    @Column(name = "nome_estudante")
    private String nomeEstudante;

    @NotNull(message = "A idade não pode ser nula")
    @Min(value = 16, message = "A idade mínima é 16")
    private Integer idade;
    
    
    private String sexo;

    // Getters e Setters
    public Long getIdPessoa() {
        return idPessoa;
    }
    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }
    public String getNomeEstudante() {
        return nomeEstudante;
    }
    public void setNomeEstudante(String nomeEstudante) {
        this.nomeEstudante = nomeEstudante;
    }
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}