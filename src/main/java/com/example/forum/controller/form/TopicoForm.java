package com.example.forum.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.forum.model.Curso;
import com.example.forum.model.Topico;
import com.example.forum.repository.CursoRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicoForm {
	@NotBlank(message = "o campo titulo está em branco")
	@Size(min = 5, max = 100, message = "o campo titulo precisa ter entre 5 e 100 caracteres")
	private String titulo;
	@NotBlank(message = "o campo mensagem está em branco")
	@Size(min = 1, max = 1000, message = "o campo mensagem precisa ter entre 1 e 1000 caracteres")
	private String mensagem;
	@NotNull(message = "o campo de nome do curso está nulo")
	@NotEmpty(message = "o campo de nome do curso está vazio")
	private String nomeCurso;

	public Topico converter(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(nomeCurso);
		return new Topico(titulo, mensagem, curso);
	}

}
