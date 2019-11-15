<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.uninove.dominio.*"%>
<%@ page import="java.util.*"%>
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
		List<Departamento> departamentos = new ArrayList<Departamento>();
		String sigla = "";
		if (request.getAttribute("sigla") != null) {
			sigla = request.getAttribute("sigla").toString();
		}

		if (request.getAttribute("departamentos") != null) {
			departamentos = (ArrayList<Departamento>) request.getAttribute("departamentos");
		}
	%>

	<div class="container mt-4">
		<h1 class="mb-5">Cadastrar Funcionario</h1>

		<form action="/uninove/funcionario/cadastrar" method="post">
			<input type="hidden" name="codigo" value="0">

			<div class="form-group">
				<label for="exampleFormControlInput1">Nome</label> <input
					type="text" class="form-control" name="nome" value=""
					placeholder="Digite o nome">
			</div>
			<div class="form-group">
				<label for="exampleFormControlInput1">CPF</label> <input type="text"
					class="form-control" name="cpf" value=""
					placeholder="000.000.000-00">
			</div>

			<div class="form-group">
				<label for="exampleFormControlInput1">Data Nascimento</label> <input
					type="date" class="form-control" value="" name="dtNascimento"
					placeholder="dd/mm/yyyy">
			</div>

			<div class="form-group">
				<label for="departamento_codigo">Departamento</label> <select
					class="form-control" name="departamento_codigo"
					id="departamento_codigo">
					<%for (Departamento departamento : departamentos) {%>
							
							<%if (departamento.getSigla().equals(sigla)) {%>
									<option value="<%=departamento.getCodigo()%>" selected="selected"><%=departamento.getNome()%></option>
							<%} else {%>
									<option value="<%=departamento.getCodigo()%>"><%=departamento.getNome()%></option>	
							<%}%>
					<%}%>
				</select>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-success">Gravar</button>
				<a class="btn btn-secondary" href="/uninove/funcionario">Cancelar</a>
			</div>
		</form>


	</div>

</body>
</html>