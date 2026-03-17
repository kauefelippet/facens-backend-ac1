package com.ac1backend.ac1.repositories;

import com.ac1backend.ac1.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
