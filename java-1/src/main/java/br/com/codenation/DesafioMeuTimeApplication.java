package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;
import br.com.codenation.helpers.SortByJogadorId;
import br.com.codenation.helpers.SortByMelhorJogador;
import br.com.codenation.jogadores.Jogador;
import br.com.codenation.times.Time;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private List<Time> times = new ArrayList<>();
	private List<Jogador> jogadores = new ArrayList<>();

	private Time getTime(Long id) {
		for (Time time: times) {
			if(time.getId().equals(id)) {
				return time;
			}
		}
		return null;
	}

	private Jogador getJogadorById(Long id) {
		for (Jogador jogador: jogadores) {
			if(jogador.getId().equals(id)) {
				return jogador;
			}
		}
		return null;
	}

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		Time time = new Time(id, nome, dataCriacao,corUniformePrincipal,corUniformeSecundario);
		if(getTime(id) == null) {
			times.add(time);
		} else {
			throw new IdentificadorUtilizadoException("Time já cadastrado");
		}
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
		if (getTime(idTime) == null) {
			throw new TimeNaoEncontradoException();
		} else {
			if (getJogadorById(id) == null) {
				jogadores.add(jogador);
			} else {
				throw new IdentificadorUtilizadoException("Jogador já cadastrado");
			}
		}
	}

	public void definirCapitao(Long idJogador) {
		if(getJogadorById(idJogador) == null) {
			throw new JogadorNaoEncontradoException("jogador não encontrado");
		}
		Long jogadorTimeID = getJogadorById(idJogador).getIdTime();
		for (Jogador jogador: jogadores) {
			if(jogador.getIdTime().equals(jogadorTimeID) && jogador.getId() != idJogador) {
				jogador.seteCapitao(false);
			}
			if(jogador.getIdTime().equals(jogadorTimeID) && jogador.getId().equals(idJogador)) {
				jogador.seteCapitao(true);
			}
		}
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		if(getTime(idTime) == null) throw new TimeNaoEncontradoException();
		Long idCapitao = null;
		for (Jogador jogador: jogadores) {
			if (jogador.getIdTime().equals(idTime) && jogador.geteCapitao().equals(true)) {
				idCapitao = jogador.getId();
			}
		}
		if (idCapitao == null) throw new CapitaoNaoInformadoException();
		return idCapitao;
	}

	public String buscarNomeJogador(Long idJogador) {
		Jogador nomeJogador = getJogadorById(idJogador);
		if (nomeJogador == null) throw new JogadorNaoEncontradoException("jogador não localizado");
		return nomeJogador.getNome();
	}

	public String buscarNomeTime(Long idTime) {
		Time nomeTime = getTime(idTime);
		if(nomeTime == null) throw new TimeNaoEncontradoException();
		return nomeTime.getNome();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		if(getTime(idTime) == null) throw new TimeNaoEncontradoException();
		Collections.sort(jogadores, new SortByJogadorId());
		List<Long> jogadoresId = new ArrayList<>();
		for(Jogador jogador: jogadores) {
			jogadoresId.add(jogador.getId());
		}
		return jogadoresId;
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		if(getTime(idTime) == null) throw new TimeNaoEncontradoException();
		Collections.sort(jogadores, new SortByMelhorJogador());
		Jogador melhorJogador = jogadores.get(0);
		return  melhorJogador.getId();
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		if(getTime(idTime) == null) throw new TimeNaoEncontradoException();
		Collections.sort(jogadores, new SortByJogadorId());
		Jogador jogadorMaisVelho = jogadores.get(0);
		for (Jogador jogador: jogadores) {
			if(jogador.getDataNascimento().compareTo(jogadorMaisVelho.getDataNascimento()) < 0) {
				jogadorMaisVelho = jogador;
			}
		}
		return jogadorMaisVelho.getId();
	}

	public List<Long> buscarTimes() {
		List<Long> getTimes = new ArrayList<>();
		for (Time time: times) {
			getTimes.add(time.getId());
		}
		return getTimes;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		if(getTime(idTime) == null) throw new TimeNaoEncontradoException();
		Collections.sort(jogadores, new SortByJogadorId());
		Jogador jogadorMaiorSalario = jogadores.get(0);
		for (Jogador jogador: jogadores) {
			if (jogador.getSalario().compareTo(jogadorMaiorSalario.getSalario()) > 0) {
				jogadorMaiorSalario = jogador;
			}
		}
			return jogadorMaiorSalario.getId();
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		if(getJogadorById(idJogador) == null) throw new JogadorNaoEncontradoException("Jogador não encontrado");
		Jogador buscaSalario = getJogadorById(idJogador);
		return  buscaSalario.getSalario();
	}

	public List<Long> buscarTopJogadores(Integer top) {
		List<Long> topJogadores = new ArrayList<>();
		if(jogadores.size() == 0 ) return topJogadores;

		Collections.sort(jogadores, new SortByJogadorId());
		Collections.sort(jogadores, new SortByMelhorJogador());
		for(int i = 0; i < top; i++) {
			topJogadores.add(jogadores.get(i).getId());
		}
		return topJogadores;
	}

}
