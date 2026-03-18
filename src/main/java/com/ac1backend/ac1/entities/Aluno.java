package com.ac1backend.ac1.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tbl_alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false)
    private int anoIngresso;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    @JsonBackReference
    private Curso idCurso;
}
