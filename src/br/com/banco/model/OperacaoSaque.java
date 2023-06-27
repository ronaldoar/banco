package br.com.banco.model;

import java.util.ArrayList;
import java.util.List;

public class OperacaoSaque {
	
	public static void main(String[] args) {
		
		try {
			List<Conta>contas = new ArrayList<Conta>();
			Conta conta = new Conta(12345678l, 199, Tipo.CORRENTE, 500.0);
			contas.add(conta);
			
			Cliente cliente = new Cliente();
			cliente.setContas(contas);
			cliente.setCpf("554877498741");
			cliente.setNome("Rambo");
			
			Operacao op  = new Operacao(conta);
			Double valor = op.sacar(200.0);
			
			System.out.println("Saque efetuado com sucesso! valor: "+valor);
		}catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
