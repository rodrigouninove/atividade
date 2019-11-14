<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.uninove.dominio.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Funcionarios</title>
<%@ include file="../shared/head.jsp"%>
</head>

<body>
	<%@ include file="../shared/menu.jsp"%>

	<%
		List<Funcionario> funcionarios = new ArrayList<Funcionario>(); 
				if(request.getAttribute("funcionarios") != null){	
			funcionarios = (List<Funcionario>) request.getAttribute("funcionarios");
		}
		
		String sigla = "";
		if (request.getAttribute("sigla") != null) {
			sigla = request.getAttribute("sigla").toString();
		}
	%>

	<div class="container mt-4">
		<h1 class="mb-5">Cadastro de Funcionarios</h1>

		<div class="row">
			<div class="col-md-12 mb-4 text-rigth">
				<a href="/uninove/funcionario/cadastrar" class="btn btn-secondary">Cadastrar</a>
			</div>
			<div class="col-md-12">
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th>NOME</th>
							<th>CPF</th>
							<th>DEPARTAMENTO</th>
							<th colspan="2" class="text-center">AÇÃO</th>

						</tr>
					</thead>
					<tbody>
						<%
							for (Funcionario funcionario : funcionarios) {
						%>
						<tr>
							<td><%=funcionario.getNome()%></td>
							<td><%=funcionario.getCpf()%></td>
							<td><%=funcionario.getDepartamento().getNome()%></td>
							<td class="text-center"><a
								href="<%=String.format("funcionario/editar?codigo=%s", funcionario.getCodigo())%>"
								title="Editar">Editar</a></td>
							<td class="text-center"><a
								data-nome="<%=funcionario.getNome()%>"
								href="<%=String.format("funcionario/excluir?codigo=%s&sigla=%s", funcionario.getCodigo(), sigla)%>"
								title="Excluir">Excluir</a></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>