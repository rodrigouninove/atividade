<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="br.gerenciador.banco.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gerenciador: Contas</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</head>
<body>

	<%
		List<Conta> contas = (List<Conta>) request.getAttribute("contas");
		Locale locale = new Locale("pt", "BR");
		NumberFormat fomataDinheiro = NumberFormat.getCurrencyInstance(locale);
	%>

	<div class="container" style="padding-top: 50px;">
		<div class="row">
			<div class="col-sm-12">
				<form class="form-inline" action="contas" method="post">
					<div class="form-group mr-2 mb-2">
						<label for="nome" class="sr-only">Nome</label> 
						<input type="text" class="form-control" id="nome" name="nome" placeholder="Nome do Cliente">
					</div>
					<button type="submit" class="btn btn-dark mb-2">Pesquisar</button>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<table class="table table-striped">
					<thead class="thead-dark">
						<tr>
							<th>CODIGO</th>
							<th>NOME</th>
							<th>NUMERO CONTA</th>
							<th>SALDO</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (Conta conta : contas) {
						%>
						<tr>
							<td><%=conta.getCliente().getCodigo()%></td>
							<td><%=conta.getCliente().getNome()%></td>
							<td><%=conta.getNumero()%></td>
							<td><%=fomataDinheiro.format(conta.getSaldo())%></td>
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