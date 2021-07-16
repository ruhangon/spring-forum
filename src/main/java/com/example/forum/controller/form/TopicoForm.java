package com.example.forum.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.forum.model.Topico;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicoForm {
	@NotBlank(message = "o campo titulo está em branco")
	@Size(min = 5, max = 100, message = "o campo titulo precisa ter entre {min} e {max} caracteres")
	private String titulo;
	@NotBlank(message = "o campo mensagem está em branco")
	@Size(min = 1, max = 1000, message = "o campo mensagem precisa ter entre {min} e {max} caracteres")
	private String mensagem;

	public Topico converte() {
		return new Topico(titulo, mensagem);
	}

}
