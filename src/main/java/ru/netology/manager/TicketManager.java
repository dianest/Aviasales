package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketManager {
  private TicketRepository repository;

  public TicketManager(TicketRepository repository) {
    this.repository = repository;
  }

  public void add(Ticket item) {
    repository.add(item);
  }

  public Ticket[] findAll(String from, String to) {
    Ticket[] items = repository.findAll();
    List<Ticket> result = new ArrayList<>();
    for (Ticket ticket : items){
     if(ticket.getFromAirport().equals(from) && ticket.getToAirport().equals(to)){
       result.add(ticket);
     }
    }

    Collections.sort(result);
    Ticket[] resultArray = new Ticket[result.size()];
    result.toArray(resultArray);
    return resultArray;
  }
}
