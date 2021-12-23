package br.com.codenation.repositorios;

import br.com.codenation.times.Time;

import java.util.ArrayList;
import java.util.List;

public class RepositorioTimes {
  private List<Time> times = new ArrayList<>();

  public void add(Time time) {
    this.times.add(time);
    System.out.println(times);
  }

  public Time search(Long id) {
    for (Time time: times) {
      if(time.getId().equals(id)) {
        return time;
      }
    }
    return null;
  }

  public List<Time> getAll() {
    return this.times;
  }
}
