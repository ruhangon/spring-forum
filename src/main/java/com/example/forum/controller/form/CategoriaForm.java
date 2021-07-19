package com.example.forum.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.forum.model.Categoria;
import com.example.forum.repository.CategoriaRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaForm {
	@NotBlank(message = "o campo nome está em branco")
	@Size(min = 1, max = 20, message = "o campo nome precisa ter entre {min} e {max} caracteres")
	private String nome;

	public Categoria converte() {
		return new Categoria(nome);
	}

	public Categoria atualiza(Long id, CategoriaRepository categoriaRepository) {
		Categoria categoria = categoriaRepository.getOne(id);
		categoria.setNome(nome);
		return categoria;
	}

}
