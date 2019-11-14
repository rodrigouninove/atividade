package br.gerenciador.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection GetConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastro_cliente","root","");
			return conn;
		
		}catch(ClassNotFoundException e) {
			System.err.println("Erro ao registrar driver mysql: " + e.getMessage());
			return null;
		} catch (SQLException e) {
			System.err.println("Erro ao conectar no banco de dados: " + e.getMessage());
			return null;
			
		}
		
	}
}
