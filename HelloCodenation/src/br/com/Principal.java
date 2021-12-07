package br.com;

import java.util.Locale;

public class Principal {

    public static void main(String[] args){
//        String teste = "sejam bem vindos ao Acelera Brasil 2019";
//        String novo = teste.toLowerCase();
//        String convertida = "";
//        int c = novo.length();
//
//        for (int i = 0; i < c; i++) {
//            if (novo.charAt(i) == (' ') || (novo.charAt(i) >= '0' && novo.charAt(i) <= '9')) {
//                convertida += novo.charAt(i);
//            } else {
//                convertida += (char)(novo.charAt(i) + 3);
//            }
//        }
        String texto = "a ligeira raposa marrom saltou sobre o cachorro cansado";
        String lowCaseString = texto.toLowerCase();
        String criptoString = "";
        int limit = lowCaseString.length();

        for (int i = 0; i < limit; i++) {
            if (lowCaseString.charAt(i) == ' ' || (lowCaseString.charAt(i) >= '0' && lowCaseString.charAt(i) <= '9')) {
                criptoString += lowCaseString.charAt(i);
            } else {
                criptoString += (char)(lowCaseString.charAt(i) + 3);
            }
        }

        System.out.println(criptoString);
    }
}
