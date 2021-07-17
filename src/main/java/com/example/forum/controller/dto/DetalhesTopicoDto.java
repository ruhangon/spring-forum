package com.example.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.forum.model.Topico;

import lombok.Getter;

@Getter
public class DetalhesTopicoDto {
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private Boolean aberto;
	private String nomeUsuario;
	private Byte nivelUsuario;
	private Integer experienciaUsuario;
	private List<RespostaDto> respostas;

	public DetalhesTopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
		this.aberto = topico.getAberto();
		this.nomeUsuario = topico.getUsuario().getNome();
		this.nivelUsuario = topico.getUsuario().getNivel();
		this.experienciaUsuario = topico.getUsuario().getExperiencia();
		this.respostas = new ArrayList<>();
		this.respostas.addAll(topico.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList()));
	}

}
