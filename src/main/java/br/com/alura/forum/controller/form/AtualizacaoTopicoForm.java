package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.alura.forum.model.Topico;
import br.com.alura.forum.repository.TopicoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizacaoTopicoForm {
	@NotBlank(message = "o campo titulo está em branco")
	@Size(min = 5, max = 100, message = "o campo titulo precisa ter entre 5 e 100 caracteres")
	private String titulo;
	@NotBlank(message = "o campo mensagem está em branco")
	@Size(min = 1, max = 1000, message = "o campo mensagem precisa ter entre 1 e 1000 caracteres")
	private String mensagem;

	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.getOne(id);

		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);

		return topico;
	}

}
