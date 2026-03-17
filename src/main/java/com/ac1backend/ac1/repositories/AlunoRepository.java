package com.ac1backend.ac1.repositories;

import com.ac1backend.ac1.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
