package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		Double salarioMinimo = 1039.0;
		if (salarioBase < salarioMinimo) return Math.round(0.0);

		Double salarioInss = calcularInss(salarioBase);
		Double salarioIRRF = calcularIRRF(salarioInss);

		return Math.round(salarioIRRF);
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {
		Double salarioBruto = 0.0;
		Double limit_9 = 1500.0;
		Double limit_11 = 4000.0;

		if (salarioBase > limit_9 && salarioBase <= limit_11) {
			salarioBruto = salarioBase * 0.91;
		} else if (salarioBase > limit_11) {
			salarioBruto = salarioBase * 0.89;
		} else {
			salarioBruto = salarioBase * 0.92;
		}
		return salarioBruto;
	}

	private double calcularIRRF(double salarioBruto) {
		Double salarioLiquido = 0.0;
		Double limit_7 = 3000.0;
		Double limit_15 = 6000.0;

		if (salarioBruto > limit_7 && salarioBruto <= limit_15) {
			salarioLiquido = salarioBruto * 0.925;
		} else if (salarioBruto > limit_15) {
			salarioLiquido = salarioBruto * 0.85;
		} else {
			salarioLiquido = salarioBruto;
		}
		return salarioLiquido;
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/