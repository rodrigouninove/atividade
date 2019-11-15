<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="br.uninove.dominio.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Departamentos</title>
<%@ include file="../shared/head.jsp"%>
</head>
<body>
	<%@ include file="../shared/menu.jsp"%>

	<%
		String funcao;
		if (request.getAttribute("funcao") != null)
			funcao = request.getAttribute("funcao").toString();

		Departamento departamento = (Departamento) request.getAttribute("departamento");
		boolean empty = (departamento.getCodigo() == 0);
	%>

	<div class="container mt-4">
		<h1 class="mb-5">Cadastro Departamento</h1>

		<div class="row">
			<div class="col">
				<form action="/uninove/departamento/cadastro.do" method="post">

					<input type="hidden" name="codigo"
						value="<%=departamento.getCodigo()%>">

					<div class="form-group">
						<label for="exampleFormControlInput1">Nome</label> <input
							type="text" class="form-control" name="nome"
							value="<%=empty ? "" : departamento.getNome()%>"
							placeholder="Digite o nome">
					</div>
					<div class="form-group">
						<label for="exampleFormControlInput1">Sigla</label> <input
							type="text" class="form-control" name="sigla"
							value="<%=empty ? "" : departamento.getSigla()%>"
							placeholder="Digite o nome">
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-success">Gravar</button>
						<a class="btn btn-secondary" href="/uninove/departamento">Cancelar</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>