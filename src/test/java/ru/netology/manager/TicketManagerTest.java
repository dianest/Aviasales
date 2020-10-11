package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class TicketManagerTest {
  @Mock
  private TicketRepository repository;
  @InjectMocks
  private TicketManager manager = new TicketManager(repository);

  Ticket first = new Ticket(1, 199, "AMS", "LED", 165);
  Ticket second = new Ticket(2, 180, "AMS", "DME", 120);
  Ticket third = new Ticket(3, 190, "DME", "LED", 65);
  Ticket fourth = new Ticket(4, 220, "PMI", "LED", 200);
  Ticket fifth = new Ticket(5, 40, "AMS", "LED", 60);
  Ticket sixth = new Ticket(6, 90, "LYS", "TXL", 40);
  Ticket seventh = new Ticket(7, 400, "AMS", "LCA", 260);
  Ticket eighth = new Ticket(8, 300, "DME", "HOR", 170);
  Ticket ninth = new Ticket(9, 800, "AMS", "LED", 800);
  Ticket tenth = new Ticket(10, 180, "MEL", "MIA", 300);
  Ticket eleventh = new Ticket(11, 199, "AMS", "LED", 330);

  @Test
  public void addTicket() {
    Ticket[] returned = new Ticket[]{first, second, third};
    doReturn(returned).when(repository).findAll();
    doNothing().when(repository).add(first);

    manager.add(first);

    Ticket[] expected = new Ticket[]{first};
    assertArrayEquals(expected, manager.findAll("AMS", "LED"));
  }

  @Test
  public void findAllEmpty(){
    Ticket[] returned = new Ticket[]{};
    doReturn(returned).when(repository).findAll();
    Ticket[] expected = new Ticket[]{};
    assertArrayEquals(expected, manager.findAll("NEW", "OLD"));
  }


  @Test
  public void findAllNone(){
    Ticket[] returned = new Ticket[]{fifth, second, third, eighth};
    doReturn(returned).when(repository).findAll();
    Ticket[] expected = new Ticket[]{};
    assertArrayEquals(expected, manager.findAll("NEW", "OLD"));
  }

  @Test
  public void findAllOne(){
    Ticket[] returned = new Ticket[]{fifth, second, third, eighth};
    doReturn(returned).when(repository).findAll();
    Ticket[] expected = new Ticket[]{third};
    assertArrayEquals(expected, manager.findAll("DME", "LED"));
  }

  @Test
  public void findAllSeveral(){
    Ticket[] returned = new Ticket[]{first, second, fifth, ninth, tenth, eleventh};
    doReturn(returned).when(repository).findAll();
    Ticket[] expected = new Ticket[]{fifth, first, eleventh, ninth};
    assertArrayEquals(expected, manager.findAll("AMS", "LED"));
  }

}