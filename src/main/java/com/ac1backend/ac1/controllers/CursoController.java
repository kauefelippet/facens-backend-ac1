package com.ac1backend.ac1.controllers;

import com.ac1backend.ac1.DTOs.CriarCursoRequest;
import com.ac1backend.ac1.entities.Curso;
import com.ac1backend.ac1.services.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping("/cursos")
    public ResponseEntity<Curso> criarCurso(@RequestBody CriarCursoRequest nomeCurso) {
        Curso curso = cursoService.criarCurso(nomeCurso.nomeCurso());
        return ResponseEntity.ok(curso);
    }

    @GetMapping("/cursos")
    public ResponseEntity<List<Curso>> listarCursos() {
        return ResponseEntity.ok(cursoService.listarCursos());
    }
}
