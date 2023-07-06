package br.com.banco;

import java.util.List;

import br.com.banco.business.ProcessoAgendamentoDeposito;
import br.com.banco.model.Cliente;

public class Banco {
	
	public static void main(String[] args) throws Exception {
		List<Cliente>clientes = ProcessoAgendamentoDeposito.extrair();
		
		ProcessoAgendamentoDeposito.depositar(clientes);
	}
}
