package br.com.banco.business;

import br.com.banco.model.Cliente;
import br.com.banco.util.FileUtils;

public class ProcessoAgendamentoDeposito {
	
	public static void extrair() throws Exception {
		try {
			StringBuffer conteudo  = FileUtils.readFile("database/", "processo_deposito.txt");
			String[] array = conteudo.toString().split(",");
			
			
			
			for(String e : array) {
				
				Cliente c = new Cliente();
				c.setId(array[0]);
				c.setConta(null);
				c.setCpf(null);
				
			}
			
			
			System.out.println(conteudo);
		} catch (Exception e) {
			throw new Exception("Não foi possível ler o arquivo.");
		}
	}
}
