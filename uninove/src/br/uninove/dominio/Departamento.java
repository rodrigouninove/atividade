package br.uninove.dominio;

import java.util.ArrayList;

public class Departamento {

	public Departamento() {
	}

	
	public Departamento(int codigo) {
		this.codigo = codigo;
	}
	
	public Departamento(int codigo, String nome, String sigla) {
		this.codigo = codigo;
		this.nome = nome;
		this.sigla = sigla;
	}

	private int codigo;
	private String nome;
	private String sigla;
	private ArrayList<Funcionario> funcionarios;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
