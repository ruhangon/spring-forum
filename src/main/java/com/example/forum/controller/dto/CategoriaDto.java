package com.example.forum.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.forum.model.Categoria;

import lombok.Getter;

@Getter
public class CategoriaDto {
	private Long id;
	private String nome;

	public CategoriaDto(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}

	public static List<CategoriaDto> converte(List<Categoria> categorias) {
		return categorias.stream().map(CategoriaDto::new).collect(Collectors.toList());
	}

}
