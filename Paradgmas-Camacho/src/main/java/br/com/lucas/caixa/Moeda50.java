package br.com.lucas.caixa;

public class Moeda50 extends Dinheiro {

	private double valor;
	
	public Moeda50() {
		this.valor = 50;
	}
	
	@Override
	public double getValor() {
		return valor;
	}

	
	@Override
	public String toString() {
		return "Moeda50 [valor=" + valor + "]";
	}

	
	
	
}
