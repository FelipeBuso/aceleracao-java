package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) throws NullPointerException {
        if (texto == null) throw new NullPointerException("Texto não pode ser nulo");
        if (texto == "") throw new IllegalArgumentException("Texto não pode ser vazio");

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
        return  criptoString;
    }

    @Override
    public String descriptografar(String texto) {
        if (texto == null) throw new NullPointerException("Texto não pode ser nulo");
        if (texto == "") throw new IllegalArgumentException("Texto não pode ser vazio");

        String lowCaseStringCripto = texto.toLowerCase();
        String uncriptoString = "";
        int limit = lowCaseStringCripto.length();

        for (int i = 0; i < limit; i++) {
            if (lowCaseStringCripto.charAt(i) == ' ' || (lowCaseStringCripto.charAt(i) >= '0' && lowCaseStringCripto.charAt(i) <= '9')) {
                uncriptoString += lowCaseStringCripto.charAt(i);
            } else {
                uncriptoString += (char)(lowCaseStringCripto.charAt(i) - 3);
            }
        }
        return  uncriptoString.toString();
    }
}
