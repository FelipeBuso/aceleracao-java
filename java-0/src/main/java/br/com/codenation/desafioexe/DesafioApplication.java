package br.com.codenation.desafioexe;


import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {


	public static List<Integer> fibonacci() {

		ArrayList<Integer> sequenciaFibonacci = new ArrayList<Integer>();
		sequenciaFibonacci.add(0);
		sequenciaFibonacci.add(1);

		do {
			sequenciaFibonacci.add(sequenciaFibonacci.get(sequenciaFibonacci.size() -1 ) + sequenciaFibonacci.get(sequenciaFibonacci.size() -2));
		} while (sequenciaFibonacci.get(sequenciaFibonacci.size() -1) < 350);


		return sequenciaFibonacci;
	}

	public static Boolean isFibonacci(Integer a) {
		List<Integer> sequenciaFibonacciGerada = fibonacci();
		Boolean existeNumero = sequenciaFibonacciGerada.contains(a);
		return existeNumero;
	}

}