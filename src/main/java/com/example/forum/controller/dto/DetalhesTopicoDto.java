package com.example.forum.controller.dto;

import java.time.LocalDateTime;

import com.example.forum.model.Topico;

import lombok.Getter;

@Getter
public class DetalhesTopicoDto {
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private Boolean aberto;
	private String nomeCategoria;
	private String nomeUsuario;
	private Byte nivelUsuario;
	private Integer experienciaUsuario;
	private Integer numeroRespostas;

	public DetalhesTopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
		this.aberto = topico.getAberto();
		this.nomeCategoria = topico.getCategoria().getNome();
		this.nomeUsuario = topico.getUsuario().getNome();
		this.nivelUsuario = topico.getUsuario().getNivel();
		this.experienciaUsuario = topico.getUsuario().getExperiencia();
		this.numeroRespostas = topico.getRespostas().size();
	}

}
