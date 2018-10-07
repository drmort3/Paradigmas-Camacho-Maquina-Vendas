package br.com.lucas.produto;

public class Produto {
	
	private int codigo;
	private int quantidade;
	private double valor;
	
	
	public Produto(int codigo, int quantidade, double valor) {
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.valor = valor;
	}


	public int getCodigo() {
		return codigo;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public double getValor() {
		return valor;
	}
	

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", quantidade=" + quantidade + ", valor=" + valor + "]";
	}
	
	
}
