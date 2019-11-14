package br.gerenciador.banco;

public class Conta {
	
	public Conta() {
		
	}

	public Conta(int codigo, String numero, double saldo, Cliente cliente) {
		this.codigo = codigo;
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	private int codigo;
	private String numero;
	private double saldo;
	
	private Cliente cliente;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
