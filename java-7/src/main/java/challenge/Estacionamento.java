package challenge;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private List<Carro> carros = new ArrayList<>();
    int LIMITE = 10;
    int SENIOR = 55;
    int PONTUACAO_MAXIMA = 20;
    int IDADE_MINIMA = 18;

  public void estacionar(Carro carro) {
      if(carro.getMotorista() == null) throw new EstacionamentoException("Não aceitamos carros autonomos");
      if(carro.getMotorista().getIdade() < IDADE_MINIMA) throw new EstacionamentoException("Menor de idade");
      if(carro.getMotorista().getPontos() > PONTUACAO_MAXIMA) throw new EstacionamentoException("Habilitação caçada");
//
      if(carros.size() < LIMITE) {
          carros.add(carro);
      } else {
          boolean achouVaga = false;
          for (Carro carroEstacionado: carros) {
            if(!achouVaga && (carroEstacionado.getMotorista().getIdade() < SENIOR)) {
              carros.remove(carroEstacionado);
              carros.add(carro);
              achouVaga = true;
            }
          }
          if (!achouVaga) throw new EstacionamentoException("Sem vagas");
      }
    }

    public int carrosEstacionados() {
        return carros.size();
    }

    public boolean carroEstacionado(Carro carro) {
      for(Carro carroEstacionado: carros) {
        if(carroEstacionado.getPlaca().equals(carro.getPlaca())
        && carroEstacionado.getMotorista().getNome().equals(carro.getMotorista().getNome())) {
          return true;
        }
      }
      return false;
    }
}
