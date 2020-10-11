package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ticket implements Comparable<Ticket>{
  private int id;
  private int cost;
  private String fromAirport;
  private String toAirport;
  private int flightTime;

  @Override
  public int compareTo(Ticket o) {
    if (this.cost > o.cost){
      return 1;
    } else if(this.cost < o.cost){
      return -1;
    } else {
      return 0;
    }
  }
}

