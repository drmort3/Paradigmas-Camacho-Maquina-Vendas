package br.com.lucas.caixa;

public class Moeda25 extends Dinheiro{

	private double valor;
	
	public Moeda25() {
		valor = 25;
	}
	
	@Override
	public double getValor() {
		return valor;
	}

	
	@Override
	public String toString() {
		return "Moeda25 [valor=" + valor + "]";
	}

	
}
