package com.example.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.forum.controller.dto.RespostaDto;
import com.example.forum.model.Resposta;
import com.example.forum.repository.RespostaRepository;
import com.example.forum.repository.TopicoRepository;
import com.example.forum.repository.UsuarioRepository;

@RestController
@RequestMapping("/respostas")
public class RespostasController {
	@Autowired
	private RespostaRepository respostaRepository;

	@Autowired
	private TopicoRepository topicoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public Page<RespostaDto> lista(@RequestParam(required = false) String tituloTopico,
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 20) Pageable paginacao) {
		if (tituloTopico == null) {
			Page<Resposta> respostas = respostaRepository.findAll(paginacao);
			return RespostaDto.converte(respostas);
		} else {
			Page<Resposta> respostas = respostaRepository.findByTopicoTitulo(tituloTopico, paginacao);
			return RespostaDto.converte(respostas);
		}
	}

}
