package br.uninove.dominio;

import java.util.Date;

public class Funcionario {
	
	public Funcionario() { }
	public Funcionario(int codigo, String nome, String cpf, Date dtNascimento, Departamento departamento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
		this.departamento = departamento;
		
	}
	
	public Funcionario(int codigo, String nome, String cpf, Date dtNascimento, int codigoDepartamento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
		this.codigoDepartamento = codigoDepartamento;
		this.departamento = new Departamento(codigoDepartamento);
		
	}
	
	private int codigo;
	private String nome;
	private String cpf;
	private Date dtNascimento;
	private int codigoDepartamento;
	private Departamento departamento;
	
	
	

	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public int getCodigoDepartamento() {
		return codigoDepartamento;
	}
	public void setCodigoDepartamento(int codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}
	
	
}
