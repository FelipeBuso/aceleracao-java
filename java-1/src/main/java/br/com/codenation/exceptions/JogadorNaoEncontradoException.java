package br.com.codenation.exceptions;

public class JogadorNaoEncontradoException extends RuntimeException{
  public JogadorNaoEncontradoException(String message) {
    super(message);
  }
}
