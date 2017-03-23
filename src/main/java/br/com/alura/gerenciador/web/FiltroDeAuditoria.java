package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String requestURI = req.getRequestURI();
		String usuario = getUsuario(req);
		String tarefa = req.getParameter("tarefa");
		req.getSession().setMaxInactiveInterval(60);
		System.out.println("Usuario: " + usuario + " acessando a URI/Serviço: " + requestURI + (tarefa != null ? "/"+tarefa : ""));
		chain.doFilter(request, response);
	}
	
	private String getUsuario(HttpServletRequest req) {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		return usuario == null ? "<deslogado>" : usuario.getEmail();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
