package com.example.forum.controller.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import com.example.forum.model.Resposta;

import lombok.Getter;

@Getter
public class RespostaDto {
	private Long id;
	private String mensagem;
	private Integer votos;
	private LocalDateTime dataCriacao;
	private String tituloTopico;
	private String nomeUsuario;
	private Byte nivelUsuario;
	private Integer experienciaUsuario;

	public RespostaDto(Resposta resposta) {
		this.id = resposta.getId();
		this.mensagem = resposta.getMensagem();
		this.votos = resposta.getVotos();
		this.dataCriacao = resposta.getDataCriacao();
		this.tituloTopico = resposta.getTopico().getTitulo();
		this.nomeUsuario = resposta.getUsuario().getNome();
		this.nivelUsuario = resposta.getUsuario().getNivel();
		this.experienciaUsuario = resposta.getUsuario().getExperiencia();
	}

	public static Page<RespostaDto> converte(Page<Resposta> respostas) {
		return respostas.map(RespostaDto::new);
	}

}
