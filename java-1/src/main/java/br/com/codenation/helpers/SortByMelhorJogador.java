package br.com.codenation.helpers;

import br.com.codenation.jogadores.Jogador;

import java.util.Comparator;

public class SortByMelhorJogador implements Comparator<Jogador> {
  public int compare(Jogador a, Jogador b) {
    return (int) (b.getNivelHabilidade() - a.getNivelHabilidade());
  }
}
