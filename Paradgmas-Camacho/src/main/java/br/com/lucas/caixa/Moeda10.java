package br.com.lucas.caixa;

public class Moeda10 extends Dinheiro {

	private double valor;

	public Moeda10() {
		valor = 10;
	}

	@Override
	public double getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "Moeda10 [valor=" + valor + "]";
	}

	
	
	
}
