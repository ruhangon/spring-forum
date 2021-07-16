package com.example.forum.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.forum.model.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
	Page<Resposta> findByTopicoTitulo(String tituloTopico, Pageable paginacao);

}
