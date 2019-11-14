<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.uninove.dominio.Funcionario"%>

<%@ page import="br.uninove.dominio.Funcionario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Funcionario Editar</title>
<%@ include file="../shared/head.jsp"%>
</head>
<body>
	<%@ include file="../shared/menu.jsp"%>

	<%
		Funcionario funcionario = new Funcionario();
		if(request.getAttribute("funcionario") != null){
			funcionario = (Funcionario) request.getAttribute("funcionario");
		}
	%>


	<div class="container mt-4">
		<h1 class="mb-5">Editar Funcionario</h1>

		<form action="/uninove/funcionario/editar" method="post">
			<input type="hidden" name="codigo" value="<%=funcionario.getCodigo()%>">
		
			<div class="form-group">
				<label for="exampleFormControlInput1">Nome</label> <input
					type="text" class="form-control" name="nome"
					value="<%=funcionario.getNome()%>" placeholder="Digite o nome">
			</div>
			<div class="form-group">
				<label for="exampleFormControlInput1">CPF</label> <input type="text"
					class="form-control" name="cpf" value="<%=funcionario.getCpf()%>"
					placeholder="000.000.000-00">
			</div>

			<div class="form-group">
				<label for="exampleFormControlInput1">Data Nascimento</label> <input
					type="date" class="form-control"
					value="<%=funcionario.getDtNascimento()%>" name="dtNascimento"
					placeholder="dd/mm/yyyy">
			</div>

			<div class="form-group">
				<label for="departamento_codigo">Departamento</label> <select
					class="form-control" name="departamento_codigo" id="departamento_codigo">
					<option value="1">Marketing</option>
					<option value="2">Expedição</option>
					<option value="3">Recursos Humanos</option>
				</select>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-danger">Alterar</button>
				<a class="btn btn-secondary" href="/uninove/funcionario">Cancelar</a>
			</div>
		</form>


	</div>

</body>
</html>