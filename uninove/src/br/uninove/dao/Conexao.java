package br.uninove.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection GetConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cadastro_empresa", "root", "");
			return conn;
			
		}catch(ClassNotFoundException e) {
			
			System.out.println("Driver msql não enctrado");
			
		} catch (SQLException e) {
			
			System.out.println("Erro ao conectar no banco de dados: " + e.getMessage());
		}
		
		return null;
		
	}
}
