package com.gradusapi.apirest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gradusapi.apirest.model.AlunoModel;
import com.gradusapi.apirest.service.AlunoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated
@RestController
@RequestMapping("/api/alunos") // observação: caminho base para os endpoints deste controller
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    // 1. ENDPOINT que busca todos os alunos
    //----------------------------------------------------------------------------------------------------------
    @GetMapping
    public ResponseEntity<List<AlunoModel>> buscarTodos() {
        List<AlunoModel> listaAlunos = alunoService.buscarTodos();
        return ResponseEntity.ok(listaAlunos); // Retorna 200 OK com a lista
    }

    // 2. ENDPOINT para inserir um novo aluno
    //----------------------------------------------------------------------------------------------------------
    @PostMapping
    public ResponseEntity<AlunoModel> salvar(@Valid @RequestBody AlunoModel aluno) {
        AlunoModel alunoSalvo = alunoService.salvar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);
    }

    // 3. ENDPOINT para buscar por id
    //----------------------------------------------------------------------------------------------------------

    @GetMapping("/{id}")
    public ResponseEntity<AlunoModel> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(alunoService.buscarPorId(id));
    }

    // 4. ENDPOINT para excluir um aluno
    //----------------------------------------------------------------------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        alunoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    // -- ENDPOINTS para buscar alunos por diferentes critérios
    //----------------------------------------------------------------------------------------------------------
    @GetMapping("/por-nome")
    public ResponseEntity<List<AlunoModel>> buscarPorNome(
            @RequestParam @Size(min = 3, message = "O nome para busca deve ter no mínimo 3 caracteres.") String nome) {
        return ResponseEntity.ok(alunoService.buscarPorNome(nome));
    }

    @GetMapping("/por-curso")
    public ResponseEntity<List<AlunoModel>> buscarPorCurso(
            @RequestParam @Size(min = 3, message = "A busca por curso deve ter no mínimo 3 caracteres.") String curso) {
        return ResponseEntity.ok(alunoService.buscarPorCurso(curso));
    }

    @GetMapping("/por-campus")
    public ResponseEntity<List<AlunoModel>> buscarPorCampus(
            @RequestParam @Size(min = 3, message = "A busca por campus deve ter no mínimo 3 caracteres.") String campus) {
        return ResponseEntity.ok(alunoService.buscarPorCampus(campus));

    }

    @GetMapping("/por-email")
    public ResponseEntity<List<AlunoModel>> buscarPorEmailInstitucional(@RequestParam String emailInstitucional) {

        return ResponseEntity.ok(alunoService.buscarPorEmailInstitucional(emailInstitucional));
    }

    @GetMapping("/por-periodo-ingresso")
    public ResponseEntity<List<AlunoModel>> buscarPorPeriodoIngresso(@RequestParam String periodoIngresso) {
        return ResponseEntity.ok(alunoService.buscarPorPeriodoIngresso(periodoIngresso));
    }
   

    // 5. ENDPOINT para editar um aluno
    //----------------------------------------------------------------------------------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<AlunoModel> editar(@PathVariable Long id, @Valid @RequestBody AlunoModel aluno) {
        aluno.setIdPessoa(id);
        AlunoModel alunoEditado = alunoService.editar(aluno);
        return ResponseEntity.ok(alunoEditado);
    }

}