package br.com.lucas.validacoes;

public class Validacoes {
	
	
	public int validaMoedas(int valor) {
		
		if((valor == 10) || (valor == 25) || (valor == 50) || (valor == 100)) {
			
			
			return valor;
			
		} 
		
		return -1;
	}
	
	

}
