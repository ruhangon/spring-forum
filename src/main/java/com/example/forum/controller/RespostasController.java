package com.example.forum.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.forum.controller.dto.RespostaDto;
import com.example.forum.controller.form.AtualizacaoRespostaForm;
import com.example.forum.controller.form.RespostaForm;
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

	@GetMapping("/{id}")
	public ResponseEntity<RespostaDto> detalha(@PathVariable Long id) {
		Optional<Resposta> resposta = respostaRepository.findById(id);
		if (resposta.isPresent()) {
			return ResponseEntity.ok(new RespostaDto(resposta.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<RespostaDto> cadastra(@RequestBody @Valid RespostaForm form,
			UriComponentsBuilder uriBuilder) {
		Resposta resposta = form.converte(topicoRepository, usuarioRepository);
		respostaRepository.save(resposta);
		URI uri = uriBuilder.path("/respostas/{id}").buildAndExpand(resposta.getId()).toUri();
		return ResponseEntity.created(uri).body(new RespostaDto(resposta));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<RespostaDto> atualiza(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoRespostaForm form) {
		Optional<Resposta> optional = respostaRepository.findById(id);
		if (optional.isPresent()) {
			Resposta resposta = form.atualiza(id, respostaRepository);
			return ResponseEntity.ok(new RespostaDto(resposta));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remove(@PathVariable Long id) {
		Optional<Resposta> optional = respostaRepository.findById(id);
		if (optional.isPresent()) {
			respostaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
