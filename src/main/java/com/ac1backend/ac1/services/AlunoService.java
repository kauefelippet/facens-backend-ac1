package com.ac1backend.ac1.services;

import com.ac1backend.ac1.entities.Aluno;
import com.ac1backend.ac1.entities.Curso;
import com.ac1backend.ac1.repositories.AlunoRepository;
import com.ac1backend.ac1.repositories.CursoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Year;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public AlunoService(AlunoRepository alunoRepository,
    CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    @Transactional
    public Aluno criarAluno(String nome) {
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setAnoIngresso(Year.now().getValue());
        return alunoRepository.save(aluno);
    }

    @Transactional
    public Aluno vincularCurso(Long alunoId, Long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        aluno.setIdCurso(curso);
        return alunoRepository.save(aluno);
    }
}
