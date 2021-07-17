package com.example.forum.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.forum.model.Resposta;
import com.example.forum.repository.RespostaRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizacaoRespostaForm {
	@NotBlank(message = "o campo mensagem está em branco")
	@Size(min = 1, max = 2000, message = "o campo mensagem precisa ter entre {min} e {max} caracteres")
	private String mensagem;

	public Resposta atualiza(Long id, RespostaRepository respostaRepository) {
		Resposta resposta = respostaRepository.getOne(id);
		resposta.setMensagem(this.mensagem);
		return resposta;
	}

}
