package br.com.banco.model;

public class Operacao {
	
	public void depositar(String[] registros) {
		//salvar aquivo texto aqui
	}
	
	public String preparar(Cliente depositante, Cliente depositado, Double valor) {
		String id    = depositado.getId();
		String banco = depositado.getConta().getBanco();
		String nome  = depositado.getNome();
		String ag    = depositado.getConta().getAgencia().toString();
		String cc    = depositado.getConta().getNumero().toString();
		String v     = valor.toString();
		String registro = id+","+banco+","+nome+","+ag+","+cc+","+v+","+depositante.getCpf()+"-";
		return registro;
	}
	
}
