package com.example.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.forum.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
	Curso findByNome(String nome);

}
