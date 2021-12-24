package br.com.codenation;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatisticUtil {

	public static int average(int[] elements) {
		List<Integer> numeros = new ArrayList<>();
		for (int element : elements) {
			numeros.add(element);
		}
		int totalNumeros = numeros.size();
		int soma = numeros.stream()
						.reduce(0, (acc, index) -> acc + index);
		int media = soma / totalNumeros;
		return media;
	}

	public static int mode(int[] elements) {
		List<Integer> numeros = new ArrayList<>();
		for (int element : elements) {
			numeros.add(element);
		}
		int moda = numeros.get(0);
		int count = 0;
		for(int numero: numeros) {
			int contagemAtual = 0;
			for (int i = 0; i < numeros.size(); i++) {
				if (numero == numeros.get(i)) {
					contagemAtual += 1;
				}
			}
			if (contagemAtual > count) {
				count = contagemAtual;
				moda = numero;
			}
		}
		return moda;
	}

	public static int median(int[] elements) {
		List<Integer> numeros = new ArrayList<>();
		for (int element : elements) {
			numeros.add(element);
		}
		Collections.sort(numeros);
		int tamanho = numeros.size();
		boolean ePar = tamanho % 2 == 0;
		int index = 0;
		int media = 0;

		if (ePar) {
			index = tamanho / 2;
			media = (numeros.get(index - 1) + numeros.get(index)) / 2;
		} else {
			index = (int) Math.floor(tamanho / 2);
			media = numeros.get(index);
		}

		return media;
	}
}