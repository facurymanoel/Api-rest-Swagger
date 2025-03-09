package com.produtos.api_rest;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
public class FilterProject extends GenericFilterBean {

	// Método que captura o Token
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest servletRequest = (HttpServletRequest) request;

		String authorization = servletRequest.getHeader("authorization");

		if (authorization == null || authorization.isEmpty()) {
			authorization = servletRequest.getHeader("Authorization");
		}

		/*
		 * Validar cadastro de Token no banco. 
		 * Validar criptografia e etc.
		 */
		if (authorization != null && !authorization.isEmpty()) {// Libera acesso a API
			chain.doFilter(request, response);
		} else {
			chain.doFilter(request, response);
			System.out.println("Acesso negado!");
			return;
		}

	}

}
