package com.gradusapi.apirest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gradusapi.apirest.model.AlunoModel;
import com.gradusapi.apirest.service.AlunoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/alunos") // observação: caminho base para os endpoints deste controller
public class AlunoController {
    
    @Autowired
    private AlunoService alunoService;

    // 1. ENDPOINT que busca todos os alunos
    @GetMapping
    public ResponseEntity<List<AlunoModel>> buscarTodos() {
        List<AlunoModel> listaAlunos = alunoService.buscarTodos();
        return ResponseEntity.ok(listaAlunos); // Retorna 200 OK com a lista
    }

    // 2. ENDPOINT para inserir um novo aluno
    @PostMapping
    public ResponseEntity<AlunoModel> salvar(@Valid @RequestBody AlunoModel aluno) {
        AlunoModel alunoSalvo = alunoService.salvar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo); 
    }

    // endpoints a serem implementados(editar, excluir, buscar por id, etc.) para a 2ª entrega.
}