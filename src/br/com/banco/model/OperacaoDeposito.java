package br.com.banco.model;

import java.util.ArrayList;
import java.util.List;

public class OperacaoDeposito {
	
	public static void main(String[] args) {
		
		try {
			List<Conta> contas = new ArrayList<Conta>();
			Conta conta1 = new Conta(6004091l, 1933, Tipo.CORRENTE, 100.0);
			Conta conta2 = new Conta(5004091l, 1933, Tipo.POUPANCA, 200.0);
			contas.add(conta1);
			contas.add(conta2);
			
			Cliente cliente1 = new Cliente();
			cliente1.setContas(contas);
			cliente1.setCpf("65438944805");
			cliente1.setNome("Manoel");
			
//			Cliente cliente2 = new Cliente();
//			cliente2.setContas(contas);
//			cliente2.setCpf("97846238495");
//			cliente2.setNome("Joaquim");
			
			Operacao op = new Operacao(conta1);
			Double valordep1 = op.depositar(100.0);
			
			Operacao op1 = new Operacao(conta2);
			Double valordep2 = op1.depositar(800.0);
			
			System.out.println("Deposito realizado com sucesso!" + valordep1);
			System.out.println("Deposito realizado com sucesso!" + valordep2);
		}catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}		
	}
}
