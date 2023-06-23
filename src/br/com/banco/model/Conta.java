package br.com.banco.model;

public class Conta {
	
	private Long numero;
	private Integer agencia;
	private Tipo tipo;
	private Double saldo;
	
	/**
	 * 
	 * @param numero
	 * @param agencia
	 * @param tipo
	 * @param saldo
	 */
	public Conta(Long numero, Integer agencia, Tipo tipo, Double saldo) {
		super();
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.saldo = saldo;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Integer getAgencia() {
		return agencia;
	}
	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
}
