package br.com.lucas.produto;

import java.util.ArrayList;
import java.util.List;

public class ListaDeProdutos {
	
	private double valor;
	private Produto produtoSelecionado;
	List<Produto> listaDeProdutos = new ArrayList<Produto>();
	List<Produto> separateCollections = new ArrayList<Produto>();
	private Integer produtoASerRemovido;
	
	
	

	public ListaDeProdutos() {

		listaDeProdutos.add(new Produto(1, 5, 150));
		listaDeProdutos.add(new Produto(2, 2, 180));
		listaDeProdutos.add(new Produto(3, 1, 200));

		
		separateCollections = listaDeProdutos;
		
	}

	public void mostraProdutos() {
		
		for (Produto produto : listaDeProdutos) {
			
//			if(produto.getQuantidade() == 0) {
//				
//				produtoASerRemovido = listaDeProdutos.indexOf(produto);/
//				
//			} else {
				
				System.out.println(produto);
				
		//	}
			
			
		}
	}
	
	
/*	
	public void removeProduto() {
		
		if(produtoASerRemovido == null) {
			
			listaDeProdutos.remove(produtoASerRemovido);
			
		} else {
			
			
		}
		
	}*/
	
	
	
	public boolean aumentaQuantidadeProduto(Produto produto) {
		
			int quantidade = produto.getQuantidade();
			
			int novaQuantidade = quantidade + 1;
			
			produto.setQuantidade(novaQuantidade);
			
			return true;
			
	}
	
	
	public boolean diminuiQuantidade(Produto produto) {
		
		
		if( produto.getQuantidade() >= 1) {
			
			int quantidade = produto.getQuantidade();
			
			int novaQuantidade = quantidade - 1;
			
			produto.setQuantidade(novaQuantidade);
			
			return true;
			
		} else {
			
			System.out.println("Quantidade Insuficiente");
			
			return false;
		}
		
	}
	
	
	public boolean verificaSeTemProdutosNaMaquina() {
		
		if(listaDeProdutos.size() > 0) {
			
			return true;
		} else {
			return false;
		}
		
		
	}
	

	public boolean buscaProdutoPorCodigo(int codigo) {
		
		int contador = 0;
		
		boolean diminuiQuantidade = true;
		
		
		for (Produto produto : listaDeProdutos) {
			
			if (produto.getCodigo() == codigo) {
				
				System.out.println("O produto escolhido é : " + produto);
				
				diminuiQuantidade = this.diminuiQuantidade(produto);
				
				this.produtoSelecionado = produto;
				
				this.valor = produto.getValor();
				
			} else {
				
				contador++;
			}
		}
		
		if(contador == listaDeProdutos.size()) {
			
			System.out.println("Não Existe Produto com esse numero");
			
			return false;
		}
		
		
		if(diminuiQuantidade == false) {
			return false;
		}
		
		return true;
	}

	
	public double valorProdutoEscolhido() {
		return valor;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}
	
	
	
	
	
	
	
	
}
