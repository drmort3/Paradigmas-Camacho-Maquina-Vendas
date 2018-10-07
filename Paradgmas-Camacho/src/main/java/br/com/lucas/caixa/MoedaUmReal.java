package br.com.lucas.caixa;

public class MoedaUmReal extends Dinheiro {

	private double valor;
	
	public MoedaUmReal() {
		valor = 100;
	}
	

	@Override
	public double getValor() {
		return valor;
	}
	
	
	@Override
	public String toString() {
		return "Moeda 1 Real [valor=" + valor + "]";
	}

}
