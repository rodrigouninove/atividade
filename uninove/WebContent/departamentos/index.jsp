<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="br.uninove.dominio.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Cadastro de Departamentos</title>
	<%@ include file="../shared/head.jsp" %>
</head>

<body>
	<%@ include file="../shared/menu.jsp" %>
	
	<%
		ArrayList<Departamento> departamentos = (ArrayList<Departamento>)request.getAttribute("departamentos");
	%>
	
	<div class="container mt-4">
		<h1 class="mb-5">Departamentos</h1>
		
		<div class="row">
			<div class="col-sm-12 mb-4">
				<a href="/uninove/departamento/cadastro.do?fn=e" class="btn btn-success">Cadastrar</a>
			</div>
			<div class="col-sm-12">
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th>CODIGO</th>
							<th>SIGLA</th>
							<th>NOME</th>
							<th colspan="3"></th>
						</tr>
					</thead>
					<tbody>
					<% for(Departamento departamento : departamentos) { %>
						<tr>
							<td><%=departamento.getCodigo() %></td>
							<td><%=departamento.getSigla() %></td>
							<td><%=departamento.getNome() %></td>
							<td><a href="/uninove/departamento/cadastro.do?fn=e&sigla=<%=departamento.getSigla()%>">Editar</a></td>
							<td><a href="/uninove/departamento/cadastro.do?fn=d&sigla=<%=departamento.getSigla()%>">Excluir</a></td>
							<td class="text-center"><a href="<%= String.format("funcionario?sigla=%s", departamento.getSigla()) %>">Funcionarios</a></td>
						</tr>
					<% } %>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>