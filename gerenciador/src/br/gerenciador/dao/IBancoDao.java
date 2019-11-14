package br.gerenciador.dao;

import java.util.List;

import br.gerenciador.banco.Conta;

public interface IBancoDao {

	public List<Conta> Listar();
	public List<Conta> Listar(String clienteNome);
}
