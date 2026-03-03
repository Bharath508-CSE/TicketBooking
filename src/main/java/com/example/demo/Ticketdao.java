package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Ticketdao extends JpaRepository<Ticket, Long> {
	Ticket findByPnr(String pnr);
}
