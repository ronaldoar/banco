package br.com.banco.model;

public class Operacao {
	
	private Conta conta;
	
	public Operacao(Conta conta) {
		this.conta = conta;
	}
	
	public Double sacar(Double valor) {
		if(valor > conta.getSaldo())throw new IllegalArgumentException("Saldo insuficiente.");
		return valor;
	}
	
	public Double depositar(Double valor) {
		if(valor <= 0)throw new IllegalArgumentException("Valor inválido.");
		Double total = valor + conta.getSaldo();
		conta.setSaldo(total);
		return total;
	}
}
