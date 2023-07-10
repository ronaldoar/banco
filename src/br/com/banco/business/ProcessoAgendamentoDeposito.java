package br.com.banco.business;

import java.util.ArrayList;
import java.util.List;

import br.com.banco.model.Cliente;
import br.com.banco.model.Conta;
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
		int contS = 1;
		int contN = 1;
		
		List<Cliente>bancoSul   = new ArrayList<Cliente>();
		List<Cliente>bancoNorte = new ArrayList<Cliente>();
		
		for(Cliente c : clientes) {
			if(c.getConta().getBanco().equals("BANCO_SUL")) {
				if(contS <= 6) {
					bancoSul.add(c);
					contS++;
				}
				
			}else if(c.getConta().getBanco().equals("BANCO_NORTE")) {
				if(contN <= 6) {
					bancoNorte.add(c);
					contN++;
				}
			}
		}

		
		for(int i=0; i<=5; i++) {
			
			Cliente clienteNorte = bancoNorte.get(i);
		    Cliente clienteSul = bancoSul.get(i);
		    
		    double saldoAtualNorte = clienteNorte.getConta().getSaldo();
		    double novoSaldoNorte = saldoAtualNorte - 100.0;
		    clienteNorte.getConta().setSaldo(novoSaldoNorte);
		    
		    double saldoAtualSul = clienteSul.getConta().getSaldo();
		    double novoSaldoBancoSul = saldoAtualSul + 100.0;
		    clienteSul.getConta().setSaldo(novoSaldoBancoSul);
		    
		    
		}		
	}
}
