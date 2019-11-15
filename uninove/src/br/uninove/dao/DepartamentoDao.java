package br.uninove.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.uninove.dominio.Departamento;

public class DepartamentoDao {

	public List<Departamento> Listar() {

		List<Departamento> departamentos = new ArrayList<Departamento>();

		try {

			String sql = "select codigo, nome, sigla from departamento";
			Connection conn = Conexao.GetConnection();
			PreparedStatement command = conn.prepareStatement(sql);

			ResultSet result = command.executeQuery();

			while (result.next()) {

				Departamento departamento = new Departamento(result.getInt("codigo"), result.getString("nome"),
						result.getString("sigla"));

				departamentos.add(departamento);
			}

		} catch (SQLException e) {

			System.out.println("Erro ao listar departamentos." + e.getMessage());
		}

		return departamentos;

	}

	public Departamento Get(String sigla) {

		Departamento departamento = new Departamento();
		
		if(sigla == null || sigla.isEmpty()) {
			return departamento;
		}

		try {
			String sql = "select * from departamento where sigla = ?";
			Connection conn = Conexao.GetConnection();
			PreparedStatement command = conn.prepareCall(sql);
			command.setString(1, sigla);
			ResultSet result = command.executeQuery();

			if (result.next()) {
				departamento = new Departamento(result.getInt("codigo"), result.getString("nome"),
						result.getString("sigla"));
			}

			return departamento;

		} catch (SQLException e) {
			System.out.println("Erro ao buscar departamento: " + e.getMessage());
			return null;
		}
	}

	public void Gravar(int codigo, String nome, String sigla) {

		try {
			String sql = "";
			Connection conn = Conexao.GetConnection();
			PreparedStatement command;

			if (codigo > 0) {
				sql += "update departamento set nome = ?, sigla = ? where codigo = ?";
				command = conn.prepareStatement(sql);
				command.setString(1, nome);
				command.setString(2, sigla);
				command.setInt(3, codigo);
			} else {
				codigo = NextCodigo();
				sql += "insert into departamento (codigo, nome, sigla) values(?,?,?)";
				command = conn.prepareStatement(sql);
				command.setInt(1, codigo);
				command.setString(2, nome);
				command.setString(3, sigla);
			}
			
			command.execute();
						
		} catch (SQLException e) {
			System.out.println("Erro ao gravar departamento: " + e.getMessage());
		}

	}

	public void Excluir(int codigo) {
		
		try {
			
			DesalocarFuncionarios(codigo);
			Connection conn = Conexao.GetConnection();
			PreparedStatement command = conn.prepareStatement("delete from departamento where codigo = ?");
			command.setInt(1, codigo);
			
			command.execute();
			
		}catch (SQLException e) {
			System.out.println("Erro ao excluir departamento: " + e.getMessage());
		}
	}
	
	
	private void DesalocarFuncionarios(int codigo) throws SQLException {
				
			Connection conn = Conexao.GetConnection();
			PreparedStatement command = conn.prepareStatement("update funcionario set codigo_departamento = null where codigo_departamento = ?");
			command.setInt(1, codigo);
			
			command.execute();
		
	}
	
	private int NextCodigo() {

		try {
			String sql = "select ifnull(max(codigo),0) + 1 as proximo from departamento";
			Connection conn = Conexao.GetConnection();
			PreparedStatement command = conn.prepareStatement(sql);
			ResultSet result = command.executeQuery();

			if (result.next()) {
				return result.getInt("proximo");
			}

			return 1;

		} catch (SQLException e) {
			return 1;
		}
	}
}
