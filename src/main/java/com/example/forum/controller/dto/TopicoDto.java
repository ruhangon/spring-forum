package com.example.forum.controller.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import com.example.forum.model.Topico;

import lombok.Getter;

@Getter
public class TopicoDto {
	private Long id;
	private String titulo;
	private LocalDateTime dataCriacao;
	private Boolean aberto;
	private String nomeCategoria;
	private String nomeUsuario;
	private Integer numeroRespostas;

	public TopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.dataCriacao = topico.getDataCriacao();
		this.aberto = topico.getAberto();
		this.nomeCategoria = topico.getCategoria().getNome();
		this.nomeUsuario = topico.getUsuario().getNome();
		this.numeroRespostas = topico.getRespostas().size();
	}

	public static Page<TopicoDto> converte(Page<Topico> topicos) {
		return topicos.map(TopicoDto::new);
	}

}
