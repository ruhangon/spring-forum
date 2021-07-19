package com.example.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.forum.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	List<Categoria> findByOrderByNomeAsc();

}
