<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="br.gerenciador.banco.*"%>

<html>
<head>
<meta charset="utf-8">
<title>Cadastro de Clientes</title>
<link rel="stylesheet" href="css/estilo.css">
</head>
<body>

	<%
		List<Conta> contas = (List<Conta>) request.getAttribute("contas");
		Locale locale = new Locale("pt", "BR");
		NumberFormat fomataDinheiro = NumberFormat.getCurrencyInstance(locale);
	%>

	<header class="cabecalho">
		<div class="container">
			<div class="titulo titulo-cabecalho">Sistema de Gerenciamento
				de Clientes</div>
		</div>
	</header>


	<form method='post' action='contas'>
		<table class='tabela'>
			<tr class='titulo-tabela'>
				<td width='18%'>Digite o Nome do Cliente:</td>
				<td><input type='text' name='txtpesquisar'
					placeholder='Digite aqui o cliente...' autocomplete="off"
					class='campo'></td>
				<td><input type='submit' value='Pesquisar' class='botao'></td>
			</tr>
		</table>
	</form>
	<div class="container">
		<div>
			<table class="tabela">
				<thead>
					<tr class="tabela--cabecalho">
						<th>CODIGO</th>
						<th>NOME</th>
						<th>CONTA</th>
						<th>SALDO</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Conta conta : contas) {
					%>
					<tr>
						<td class=""><%=conta.getCliente().getNome()%></td>
						<td class=""><%=conta.getCliente().getNome()%></td>
						<td class=""><%=conta.getNumero()%></td>
						<td class=""><%=fomataDinheiro.format(conta.getSaldo())%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>

		</div>
	</div>

	<footer class="rodape">
		<div class="container">
			<div class="titulo titulo-rodape">UNINOVE JAVA - Todos os
				direitos reservados</div>
		</div>
	</footer>

</body>
</html>