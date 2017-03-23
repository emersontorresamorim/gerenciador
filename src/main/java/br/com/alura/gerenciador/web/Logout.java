package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements Tarefa {

	// req.getSession().invalidate();
	// resp.sendRedirect("logout.html"); // Serve para redirecionar para um recurso aberto no WebContent, o client fica sabendo do redirecionamento e vê a url do recurso final
	// RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logout.html");
	// dispatcher.forward(req, resp); // Serve para redirecionar para um recurso fechado, o server que redireciona e o client não fica sabendo e fica a url do recurso inicial

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().removeAttribute("usuarioLogado");
		return "/WEB-INF/paginas/logout.html";
	}
}
