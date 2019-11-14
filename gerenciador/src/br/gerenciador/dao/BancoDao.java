package br.gerenciador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.gerenciador.banco.*;

public class BancoDao implements IBancoDao {

	@Override
	public List<Conta> Listar() {

		List<Conta> contas = new ArrayList<Conta>();

		try {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT conta.codigo, conta.numero, conta.saldo, conta.codigo_cliente, ");
			sb.append("		  cliente.nome, cliente.idade, cliente.sexo, cliente.profissao ");
			sb.append("FROM   conta ");
			sb.append("JOIN   cliente ");
			sb.append("ON 	  conta.codigo_cliente = cliente.codigo ");
			sb.append("ORDER BY cliente.nome");

			Connection conn = Conexao.GetConnection();
			PreparedStatement command = conn.prepareStatement(sb.toString());

			ResultSet result = command.executeQuery();

			while (result.next()) {

				Conta conta = MontarConta(result);

				contas.add(conta);
				
			}

		} catch (SQLException e) {

			System.out.println("Erro em listar contas: " + e.getMessage());
		}
		
		return contas;

	}

	@Override
	public List<Conta> Listar(String clienteNome) {

		List<Conta> contas = new ArrayList<Conta>();

		try {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT conta.codigo, conta.numero, conta.saldo, conta.codigo_cliente, ");
			sb.append("		  cliente.nome, cliente.idade, cliente.sexo, cliente.profissao ");
			sb.append("FROM   conta ");
			sb.append("JOIN   cliente ");
			sb.append("ON 	  conta.codigo_cliente = cliente.codigo ");
			sb.append("WHERE  cliente.nome like ? ");
			sb.append("ORDER BY cliente.nome");

			Connection conn = Conexao.GetConnection();
			PreparedStatement command = conn.prepareStatement(sb.toString());
			command.setString(1, '%' + clienteNome + '%');

			ResultSet result = command.executeQuery();

			while (result.next()) {

				Conta conta = MontarConta(result);

				contas.add(conta);
				
			}

		} catch (SQLException e) {

			System.out.println("Erro em listar contas: " + e.getMessage());
		}
		
		return contas;
	}
	
	private Conta MontarConta(ResultSet result) throws SQLException {
		int codigo = result.getInt("codigo");
		String numero = result.getString("numero");
		double saldo = result.getDouble("saldo");
		int codigo_cliente = result.getInt("codigo_cliente");
		String nome = result.getString("nome");
		int idade = result.getInt("idade");
		String sexo = result.getString("sexo");
		String profissao = result.getString("profissao");

		Cliente cliente = new Cliente(codigo_cliente, nome, idade, sexo, profissao);
		Conta conta = new Conta(codigo, numero, saldo, cliente);
		return conta;
	}

}
