<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="br.uninove.dominio.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Excluir Funcionário</title>
<%@ include file="../shared/head.jsp"%>
</head>
<body>
	<%@ include file="../shared/menu.jsp"%>

	<%
		Departamento departamento = (Departamento) request.getAttribute("departamento");
	%>

	<form action="/uninove/departamento/cadastro.do?fn=d" method="post">
		<input type="hidden" name="codigo"
			value="<%=departamento.getCodigo()%>">
		<div class="container mt-4">
			<div class="row">
				<div class="col-sm-12">
					<h1 class="mb-5">
						Excluir Departamento <small>(<%=departamento.getNome()%>)</small>
					</h1>
					<h4>
						<small>Funcionarios deste departamentos deverão ser
							alocados em outro departamento.</small>
					</h4>
				</div>
				<div class="col-sm-12 mt-4">
					<button class="btn btn-danger">Excluir</button>
					<a href="/uninove/departamento" class="btn btn-secondary">Cancelar</a>
				</div>
			</div>
		</div>
	</form>
</body>
</html>