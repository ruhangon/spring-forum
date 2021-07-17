package com.example.forum.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.example.forum.model.Topico;
import com.example.forum.model.Usuario;
import com.example.forum.repository.UsuarioRepository;

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
	@PositiveOrZero(message = "O id do usuário não é válido")
	private Long idUsuario;

	public Topico converte(UsuarioRepository usuarioRepository) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(idUsuario);
		Usuario usuario = optionalUsuario.get();
		return new Topico(titulo, mensagem, usuario);
	}

}
