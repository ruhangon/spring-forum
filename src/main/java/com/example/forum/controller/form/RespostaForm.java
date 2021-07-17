package com.example.forum.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.example.forum.model.Resposta;
import com.example.forum.model.Topico;
import com.example.forum.model.Usuario;
import com.example.forum.repository.TopicoRepository;
import com.example.forum.repository.UsuarioRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespostaForm {
	@NotBlank(message = "o campo mensagem está em branco")
	@Size(min = 1, max = 2000, message = "o campo mensagem precisa ter entre {min} e {max} caracteres")
	private String mensagem;
	@PositiveOrZero(message = "O id do tópico não é válido")
	private Long idTopico;
	@PositiveOrZero(message = "O id do usuário não é válido")
	private Long idUsuario;

	public Resposta converte(TopicoRepository topicoRepository, UsuarioRepository usuarioRepository) {
		Optional<Topico> optionalTopico = topicoRepository.findById(idTopico);
		Topico topico = optionalTopico.get();
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(idUsuario);
		Usuario usuario = optionalUsuario.get();
		return new Resposta(mensagem, topico, usuario);
	}

}
