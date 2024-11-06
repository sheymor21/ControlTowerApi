package com.sheymor.controltower.Repositories;

import com.sheymor.controltower.Entities.FlightTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<FlightTicket, Integer> {
}
