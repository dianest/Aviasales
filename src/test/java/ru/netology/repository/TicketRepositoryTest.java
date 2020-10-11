package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class TicketRepositoryTest {

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
    void findAll() {
        TicketRepository repository = new TicketRepository();
        repository.add(first);
        repository.add(third);
        repository.add(sixth);
        repository.add(ninth);
        Ticket[] expected = new Ticket[]{first, third, sixth, ninth};
        assertArrayEquals(expected, repository.findAll());
    }


    @Test
    void save() {
        TicketRepository repository = new TicketRepository();
        repository.add(eleventh);
        Ticket[] expected = new Ticket[]{eleventh};
        assertArrayEquals(expected, repository.findAll());
    }


    @Test
    void findById() {
        TicketRepository repository = new TicketRepository();
        repository.add(first);
        repository.add(third);
        repository.add(sixth);
        repository.add(ninth);
        repository.add(eleventh);

        assertEquals(ninth, repository.findById(9));
        assertNull(repository.findById(2));
    }


    @Test
    void removeById() {
        TicketRepository repository = new TicketRepository();
        repository.add(first);
        repository.add(third);
        repository.add(sixth);
        repository.add(ninth);
        repository.add(eleventh);

        Ticket[] expected = new Ticket[]{first, third, ninth, eleventh};
        repository.removeById(6);

        assertArrayEquals(expected, repository.findAll());

        Assertions.assertThrows(IllegalStateException.class, () -> {
            repository.removeById(2);
        });
    }


    @Test
    void removeAll() {
        TicketRepository repository = new TicketRepository();
        repository.add(first);
        repository.add(third);
        repository.add(sixth);
        repository.add(ninth);
        repository.add(eleventh);

        Ticket[] expected = new Ticket[0];

        repository.removeAll();

        assertArrayEquals(expected, repository.findAll());
    }
}