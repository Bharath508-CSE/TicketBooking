package com.example.demo;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    private Ticketdao ticketdao;

    public Ticket saveTicket(Ticket ticket) {
        return ticketdao.save(ticket);
    }

    // FIND ticket by PNR
    public Ticket getByPnr(String pnr) {
        return ticketdao.findByPnr(pnr);
    }
}
