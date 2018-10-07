package br.com.lucas.maquinaDeVenda;

import java.util.List;
import java.util.Map;

import br.com.lucas.caixa.CaixaDeMoeda;
import br.com.lucas.caixa.Dinheiro;
import br.com.lucas.caixa.Moeda10;

public class MaquinaDeVenda {

	private CaixaDeMoeda caixa;
	private double valorQueSobrouDeTroco;
	private double valorFaltante;
	private double valorADevolver;

	public MaquinaDeVenda() {

		this.caixa = new CaixaDeMoeda();
	}

	double valorRestante = 0;

	public int maquinaDeVendaRecebeValor(double valorDigitado, double valorDoProduto) {

		// falta dinheiro
		if ((valorDigitado < valorDoProduto)) {

			valorFaltante = valorDoProduto - valorDigitado;

			return -1;

		} else if (valorDigitado > valorDoProduto) { // tem troco

			valorADevolver = valorDigitado - valorDoProduto;

			return 1;

		} else {

			System.out.println("Produto Pagoo!!!"); // produto pago!!

			return 0;

		}

	}

	public boolean ePossivelDarTrocoParaQualquerValor() {

		boolean troco100 = verificarSeEPossivelDevolverTroco(100);
		boolean troco50 = verificarSeEPossivelDevolverTroco(50);
		boolean troco25 = verificarSeEPossivelDevolverTroco(25);
		boolean troco10 = verificarSeEPossivelDevolverTroco(10);
		boolean troco75 = verificarSeEPossivelDevolverTroco(75);

		if (troco100 == true && troco50 == true && troco25 == true && troco10 == true && troco75 == true) {

			return true;

		} else {

			return false;
		}

	}

	public boolean verificarSeEPossivelDevolverTroco(double valor) {

		int moeda10 = caixa.getMoedasDe10().size();
		int moeda25 = caixa.getMoedasDe25().size();
		int moeda50 = caixa.getMoedasDe50().size();
		int moeda1Real = caixa.getMoedasDe1Real().size();

		if ((valor == 10) && (moeda10 >= 1)) {
			return true;
		} else if ((valor == 20) && (moeda10 >= 2)) {
			return true;
		} else if ((valor == 25) && (moeda25 >= 1)) {
			return true;
		} else if ((valor == 50) && ((moeda50 >= 1) || (moeda25 >= 2))) {
			return true;
		} else if ((valor == 75) && ((moeda50 >= 1) && (moeda25 >= 1) || (moeda25 >= 3))) {
			return true;
		} else if ((valor == 100) && ((moeda25 >= 4) || (moeda10 >= 10) || (moeda50 >= 2) || (moeda1Real >= 1))) {
			return true;
		}

		return false;

	}

	public void devolveTroco() {

		this.getValorADevolver();

		if (this.verificarSeEPossivelDevolverTroco(this.getValorADevolver()) == true) {

			if (this.getValorADevolver() == 100) {

				this.setValorADevolver(this.getValorADevolver() - 100);

				if (caixa.getMoedasDe1Real().size() == 0) {

					caixa.removeMoeda50();
					caixa.removeMoeda50();

				} else {

					caixa.removeMoedaDe100();

				}

			} else if (this.getValorADevolver() == 50) {

				this.setValorADevolver(this.getValorADevolver() - 50);

				if (caixa.getMoedasDe50().size() == 0) {

					caixa.removeMoeda25();
					caixa.removeMoeda25();

				} else {

					caixa.removeMoeda50();

				}

			} else if (this.getValorADevolver() == 25) {

				this.setValorADevolver(this.getValorADevolver() - 25);

				caixa.removeMoeda25();

			} else if (this.getValorADevolver() == 10) {

				this.setValorADevolver(this.getValorADevolver() - 10);

				caixa.removeMoeda10();

			} else if (this.getValorADevolver() == 75) {

				this.setValorADevolver(this.getValorADevolver() - 75);

				if (caixa.getMoedasDe50().size() == 0) {

					caixa.removeMoeda25();
					caixa.removeMoeda25();
					caixa.removeMoeda25();

				} else {

					caixa.removeMoeda25();
					caixa.removeMoeda50();

				}
			}

		} else {

			System.out.println("A maquina não tem troco");

		}

	}

	public void setValorADevolver(double valorADevolver) {
		this.valorADevolver = valorADevolver;
	}

	public double getValorFaltante() {
		return valorFaltante;
	}

	public double getValorADevolver() {
		return valorADevolver;
	}

}
