package com.example.forum.controller.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {
	private String email;
	private String senha;

	public UsernamePasswordAuthenticationToken converte() {
		return new UsernamePasswordAuthenticationToken(email, senha);
	}

}
