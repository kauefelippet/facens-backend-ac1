package com.ac1backend.ac1.controllers;

import com.ac1backend.ac1.DTOs.AlunoCursoRequest;
import com.ac1backend.ac1.DTOs.CriarAlunoRequest;
import com.ac1backend.ac1.entities.Aluno;
import com.ac1backend.ac1.services.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
     }

    @PostMapping("/alunos")
    public ResponseEntity<Aluno> criarAluno(@RequestBody CriarAlunoRequest alunoRequest) {
        Aluno aluno = alunoService.criarAluno(alunoRequest.nomeAluno());
        return ResponseEntity.ok(aluno);
    }

    @PostMapping("/vincular-aluno-curso")
    public ResponseEntity<?> vincularAlunoCurso(@RequestBody AlunoCursoRequest alunoCursoRequest) {
        try {
            Aluno alunoVinculado = alunoService.vincularCurso(alunoCursoRequest.alunoId(), alunoCursoRequest.cursoId());
            return ResponseEntity.ok(alunoVinculado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
