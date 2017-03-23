<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home</title>
	</head>
	<body>
		<h1>Bem vindo ao nosso gerenciador de empresas!</h1><br/>
		
		<c:if test="${not empty usuarioLogado}">
			<p>Logado como usuario: ${usuarioLogado.email}</p><br/>
		</c:if>
		
		<form action="servico" method="POST">
			Nome: <input type="text" name="nome">
			<input type="hidden" name="tarefa" value="AdicionaEmpresa">
			<input type="submit" value="Salvar">
		</form>
		
		<form action="servico" method="POST">
			Email: <input type="email" name="email"><br/>
			Senha: <input type="password" name="senha"><br/>
			<input type="hidden" name="tarefa" value="Login">
			<input type="submit" value="Entrar">
		</form>
		
		<form action="servico" method="POST">
			<input type="hidden" name="tarefa" value="Logout">
			<input type="submit" value="Sair">
		</form>
	</body>
</html>