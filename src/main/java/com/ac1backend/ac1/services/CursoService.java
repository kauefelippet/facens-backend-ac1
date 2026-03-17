package com.ac1backend.ac1.services;

import com.ac1backend.ac1.entities.Curso;
import com.ac1backend.ac1.repositories.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Transactional
    public Curso criarCurso(String nome) {
        Curso curso = new Curso();
        curso.setNome(nome);
        return cursoRepository.save(curso);
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }
}
