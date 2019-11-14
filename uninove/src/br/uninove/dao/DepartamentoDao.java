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
}
