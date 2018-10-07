package br.com.lucas.caixa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CaixaDeMoeda {

	private List<Dinheiro> moedasDe10;
	private List<Dinheiro> moedasDe25;
	private List<Dinheiro> moedasDe50;
	private List<Dinheiro> moedasDe1Real;

	public CaixaDeMoeda() {

		this.moedasDe10 = new ArrayList<Dinheiro>();
		this.moedasDe25 = new ArrayList<Dinheiro>();
		this.moedasDe50 = new ArrayList<Dinheiro>();
		this.moedasDe1Real = new ArrayList<Dinheiro>();

		moedasDe1Real.add(new MoedaUmReal());
		moedasDe1Real.add(new MoedaUmReal());
		moedasDe1Real.add(new MoedaUmReal());

		moedasDe50.add(new Moeda50());
		moedasDe50.add(new Moeda50());
		moedasDe50.add(new Moeda50());

		moedasDe25.add(new Moeda25());
		moedasDe25.add(new Moeda25());
		moedasDe25.add(new Moeda25());

		moedasDe10.add(new Moeda10());
		moedasDe10.add(new Moeda10());
		moedasDe10.add(new Moeda10());

	}

	public boolean removeMoedaDe100() {

		if (moedasDe1Real.size() > 0) {

			int index = 0;

			moedasDe1Real.remove(index);

			System.out.println("Você recebeu 1 real de troco");

			index++;

			return true;

		} else {

			System.out.println("Não tem mais moedas de 100 centavos para troco");

			return false;
		}
	}

	public boolean removeMoeda50() {

		if (moedasDe50.size() > 0) {

			int index = 0;

			moedasDe50.remove(index);

			System.out.println("Você recebeu 50 centavos de troco");

			index++;

			return true;

		} else {

			System.out.println("Não tem mais moedas de 50 para troco");

			return false;

		}
	}

	public boolean removeMoeda25() {

		if (moedasDe25.size() > 0) {

			int index = 0;

			moedasDe25.remove(index);

			System.out.println("Você recebeu 25 centavos de troco");

			index++;

			return true;

		} else {

			System.out.println("Não tem mais moedas de 25 centavos para troco");

			return false;

		}

	}

	public boolean removeMoeda10() {

		if (moedasDe10.size() > 0) {

			int index = 0;

			moedasDe10.remove(index);

			System.out.println("Você recebeu 10 centavos de troco");

			index++;

			return true;

		} else {

			System.out.println("Não tem mais moedas de 10 para troco");

			return false;

		}
	}

	public List<Dinheiro> getMoedasDe10() {
		return moedasDe10;
	}

	public List<Dinheiro> getMoedasDe25() {
		return moedasDe25;
	}

	public List<Dinheiro> getMoedasDe50() {
		return moedasDe50;
	}

	public List<Dinheiro> getMoedasDe1Real() {
		return moedasDe1Real;
	}

}
