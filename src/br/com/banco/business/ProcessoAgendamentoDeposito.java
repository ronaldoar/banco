package br.com.banco.business;

import java.util.ArrayList;
import java.util.List;

import br.com.banco.model.Cliente;
import br.com.banco.model.Conta;
import br.com.banco.model.Operacao;
import br.com.banco.util.FileUtils;

public class ProcessoAgendamentoDeposito {
	
	public static List<Cliente> extrair() throws Exception {
		
		try {
			StringBuffer conteudo  = FileUtils.readFile("database/", "contas.txt");
			String[] array         = conteudo.toString().split("-");
			List<Cliente>clientes  = new ArrayList<Cliente>();
			
			for(String reg : array) {
				String[] params = reg.split(",");
				
				String id     = params[0].trim();
				String banco  = params[1].trim();
				String nome   = params[2].trim();
				String cpf    = params[3].trim();
				Integer ag    = Integer.valueOf(params[4].trim());
				Long conta    = Long.valueOf(params[5].trim());
				Double saldo  = Double.valueOf(params[6].trim());

				Conta cc = new Conta();
				cc.setBanco(banco);
				cc.setAgencia(ag);
				cc.setNumero(conta);
				cc.setSaldo(saldo);
				
				Cliente c = new Cliente();
				c.setConta(cc);
				c.setCpf(cpf);
				c.setId(id);
				c.setNome(nome);
				
				clientes.add(c);
			}
			return clientes;
			
		} catch (Exception e) {
			throw new Exception("Não foi possível ler o arquivo.");
		}
	}
	
	public static void depositar(List<Cliente>clientes) {
		
		for(Cliente c : clientes) {
			//new Operacao().preparar(c, c.getConta().getSaldo());
		}
	}
}
