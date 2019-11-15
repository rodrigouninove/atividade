package br.uninove.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import br.uninove.dominio.Funcionario;
import br.uninove.dominio.Departamento;

public class FuncionarioDao {

	public List<Funcionario> Listar(String sigla) {

		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

		try {

			StringBuilder sb = new StringBuilder();
			sb.append(
					"select f.codigo, f.nome, f.cpf, f.dt_nascimento, f.codigo_departamento, d.nome as nome_departamento, d.sigla ");
			sb.append("from funcionario f ");
			sb.append("join departamento d on f.codigo_departamento = d.codigo ");
			sb.append("where d.sigla = ? ");
			sb.append("order by f.nome");

			Connection conn = Conexao.GetConnection();
			PreparedStatement command = conn.prepareStatement(sb.toString());
			command.setString(1, sigla);

			ResultSet result = command.executeQuery();
			while (result.next()) {
				funcionarios.add(MontarFuncionario(result, true));
			}

			return funcionarios;

		} catch (Exception e) {
			System.out.println("Erro ao listar funcionarios" + e.getMessage());
			return funcionarios;
		}

	}

	public List<Funcionario> Listar() {

		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

		try {

			StringBuilder sb = new StringBuilder();
			sb.append(
					"select f.codigo, f.nome, f.cpf, f.dt_nascimento, f.codigo_departamento, d.nome as nome_departamento, d.sigla ");
			sb.append("from funcionario f ");
			sb.append("join departamento d on f.codigo_departamento = d.codigo ");
			sb.append("order by f.nome");

			Connection conn = Conexao.GetConnection();
			PreparedStatement command = conn.prepareStatement(sb.toString());

			ResultSet result = command.executeQuery();
			while (result.next()) {
				funcionarios.add(MontarFuncionario(result, true));
			}

			return funcionarios;

		} catch (Exception e) {
			System.out.println("Erro ao listar funcionarios" + e.getMessage());
			return funcionarios;
		}

	}

	public Funcionario Get(int codigo) {

		Funcionario funcionario = null;
		try {

			String sql = "";
			sql += "select codigo, nome, cpf, dt_nascimento, codigo_departamento ";
			sql += "from funcionario ";
			sql += "where codigo = ?";

			Connection conn = Conexao.GetConnection();
			PreparedStatement command = conn.prepareStatement(sql);
			command.setInt(1, codigo);

			ResultSet result = command.executeQuery();

			if (result.next()) {

				funcionario = MontarFuncionario(result, false);
			}

			return funcionario;

		} catch (SQLException e) {
			System.out.println("Erro ao consultar funcionario. " + e.getMessage());
			return funcionario;
		}

	}

	public void Excluir(int codigo) {

		try {
			Connection conn = Conexao.GetConnection();
			String sql = "delete from funcionario where codigo = ?";
			PreparedStatement command = conn.prepareStatement(sql);
			command.setInt(1, codigo);
			command.execute();

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

	}

	public boolean Gravar(int codigo, String nome, String cpf, Date dtNascimento, int codigoDepartamento)
			throws ParseException {

		try {
			String sql = "";
			if (codigo > 0) {
				sql += "update funcionario set nome = ?, cpf = ?, dt_nascimento = ?, codigo_departamento = ? ";
				sql += "where codigo = ?";
			} else {
				sql += "insert into funcionario (nome, cpf, dt_nascimento, codigo_departamento) ";
				sql += "values(?,?,?,?)";

			}

			Connection conn = Conexao.GetConnection();
			PreparedStatement command = conn.prepareStatement(sql);
			command.setString(1, nome);
			command.setString(2, cpf);
			command.setDate(3, new java.sql.Date(dtNascimento.getTime()));
			command.setInt(4, codigoDepartamento);

			if (codigo > 0) {
				command.setInt(5, codigo);
			}

			return command.execute();

		} catch (SQLException e) {

			System.out.println("Erro ao editar funcionario" + e.getMessage());

			return false;
		}

	}

	private Funcionario MontarFuncionario(ResultSet result, Boolean completo) throws SQLException {
		Departamento departamento = null;
		Funcionario funcionario = null;

		if (completo) {
			departamento = new Departamento(result.getInt("codigo_departamento"), result.getString("nome_departamento"),
					result.getString("sigla"));
			
			funcionario = new Funcionario(result.getInt("codigo"), result.getString("nome"), result.getString("cpf"),
					result.getDate("dt_nascimento"), departamento);
		} else {

			departamento = new Departamento(result.getInt("codigo_departamento")); 
			funcionario = new Funcionario(result.getInt("codigo"), result.getString("nome"), result.getString("cpf"),
					result.getDate("dt_nascimento"), result.getInt("codigo_departamento"));
			funcionario.setDepartamento(departamento);
			
		}

		return funcionario;
	}

}
