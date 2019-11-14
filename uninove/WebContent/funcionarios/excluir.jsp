<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="br.uninove.dominio.Funcionario"%>
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
		
		String msg = "";
		String sigla = "";
		Funcionario funcionario = null;

		if (request.getAttribute("msgError") != null) {			  
			msg = request.getAttribute("msgError").toString();
		}
		
		if (request.getAttribute("msgSuccess") != null) {			  
			msg = request.getAttribute("msgSuccess").toString();
		}

		if (request.getAttribute("funcionario") != null) {
			funcionario = (Funcionario) request.getAttribute("funcionario");
		}

		if (request.getAttribute("sigla") != null) {
			sigla = request.getAttribute("sigla").toString();
		}
	%>
	<div class="container mt-4">
	<h1 class="mb-5">Excluir Funcionario</h1>
		<%
			if (funcionario != null) {
		%>
		<form action="/uninove/funcionario/excluir" method="post">
			<input type="hidden" name="codigo" value="<%=funcionario.getCodigo()%>">
			<input type="hidden" name="sigla" value="<%=sigla%>">
			
			<div class="row">
				<div class="col">
					<h3>Deseja remover o funcionario <%=funcionario.getNome()%>?</h3>
				</div>
				<div class="col-sm-12 mt-4">
					<button type="submit" class="btn btn-danger">Sim</button>
					<a class="btn btn-secondary" href="/uninove/funcionario?sigla=<%=sigla%>">Voltar</a>
				</div>
			</div>
		</form>
		<%
			} else {
		%>
		<h3 class="text-info"><%=msg%>
		</h3>
		<a class="btn btn-secondary" href="/uninove/funcionario?sigla=<%=sigla%>">Voltar</a>
		<%
			}
		%>
	</div>
</body>
</html>