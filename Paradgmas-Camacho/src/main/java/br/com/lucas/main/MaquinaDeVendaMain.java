package br.com.lucas.main;

import java.util.Scanner;

import br.com.lucas.caixa.CaixaDeMoeda;
import br.com.lucas.maquinaDeVenda.MaquinaDeVenda;
import br.com.lucas.produto.ListaDeProdutos;
import br.com.lucas.produto.Produto;
import br.com.lucas.validacoes.Validacoes;

public class MaquinaDeVendaMain {

	public static void main(String[] args) {

		boolean maquinaLigada = true;

		// Crio a lista de produtos
		ListaDeProdutos listaDeProdutos = new ListaDeProdutos();

		// Cria as rotinas de uma maquina de venda
		MaquinaDeVenda maquina = new MaquinaDeVenda();

		// faço as validações de campo
		Validacoes validador = new Validacoes();

		// rodar os dados no cache

		while (maquinaLigada) {

			if (maquina.ePossivelDarTrocoParaQualquerValor() == true
					&& listaDeProdutos.verificaSeTemProdutosNaMaquina()) {

				System.out.println("A seguir sera exibida a lista de produtos da máquina: ");

				// Mostra Lista de Produtos na tela

				listaDeProdutos.mostraProdutos();
				// listaDeProdutos.removeProduto();

				System.out.println("Selecione um produto digitando o código do produto ");

				Scanner scan = new Scanner(System.in);

				// recebe o código do produto

				int codigo = 0;
				
				try {
					 codigo = scan.nextInt();
					 
				} catch (Exception e) {
					
					e.getMessage();

				}

				// verifica se a busca pelo produto foi bem sucedida
				boolean buscaProdutoPorCodigo = listaDeProdutos.buscaProdutoPorCodigo(codigo);

				if (buscaProdutoPorCodigo) {

					double valorProdutoEscolhido = listaDeProdutos.valorProdutoEscolhido();

					System.out.println("Insira o valor: " + valorProdutoEscolhido);

					int valorDigitadoAValidar = scan.nextInt();

					// validação para só conseguir digitar moedas que existam
					int valorValidado = validador.validaMoedas(valorDigitadoAValidar);

					while (valorValidado == -1) {

						System.out.println("Coloque uma moeda válida");

						valorDigitadoAValidar = scan.nextInt();

						valorValidado = validador.validaMoedas((valorDigitadoAValidar));

					}

					// recebe os valores digitado e o o valor do produto que foi selecionado
					int verificaValorRecebidoNaMaquina = maquina.maquinaDeVendaRecebeValor(
							(double) valorDigitadoAValidar, listaDeProdutos.valorProdutoEscolhido());

					while (verificaValorRecebidoNaMaquina != 0) {

						if (verificaValorRecebidoNaMaquina > 0) {

							System.out.println("Você tem troco ");

							maquina.devolveTroco();

							verificaValorRecebidoNaMaquina = (int) maquina.getValorADevolver();

						} else if (verificaValorRecebidoNaMaquina < 0) {

							while (verificaValorRecebidoNaMaquina < 0) {

								System.out.println("Ainda falta dinheiro: " + maquina.getValorFaltante()
										+ " coloque a proxima Moeda");

								int valorFaltanteDigitado = scan.nextInt();

								// validação para só conseguir digitar moedas que existam
								int validadorNumero = validador.validaMoedas(valorFaltanteDigitado);

								while (validadorNumero == -1) {

									System.out.println("Coloque uma moeda válida");

									valorDigitadoAValidar = scan.nextInt();

									validadorNumero = validador.validaMoedas(valorDigitadoAValidar);

								}

								valorFaltanteDigitado = validadorNumero;

								verificaValorRecebidoNaMaquina = maquina.maquinaDeVendaRecebeValor(
										(double) valorFaltanteDigitado, maquina.getValorFaltante());

							}

						} else {

							System.out.println("Produto Pago!! ");

						}
					}

				}
			} else {

				System.out.println(
						"Máquina não tem mais troco, então será desligada para evitar problemas financeiros ao cliente");

				maquinaLigada = false;

			}

		}
	}

}
