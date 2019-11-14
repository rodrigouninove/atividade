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
		<h1 class="mb-5">Cadastro de Departamentos</h1>
		
		<div class="row">
			<div class="col">
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th>CODIGO</th>
							<th>SIGLA</th>
							<th>NOME</th>
							<th class="text-center">FUNCIONARIOS</th>
						</tr>
					</thead>
					<tbody>
					<% for(Departamento departamento : departamentos) { %>
						<tr>
							<td><%=departamento.getCodigo() %></td>
							<td><%=departamento.getSigla() %></td>
							<td><%=departamento.getNome() %></td>
							<td class="text-center"><a href="<%= String.format("funcionario?sigla=%s", departamento.getSigla()) %>">Ver</a></td>
						</tr>
					<% } %>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>