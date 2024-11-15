package com.sheymor.controltower.Services;

import com.sheymor.controltower.Dto.Ticket.TicketAddDTO;
import com.sheymor.controltower.Dto.Ticket.TicketGetDTO;
import com.sheymor.controltower.Entities.FlightTicket;
import com.sheymor.controltower.Mappers.TicketMapper;
import com.sheymor.controltower.Repositories.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void AddPassengerToFlight(TicketAddDTO ticketAddDTO) {
        FlightTicket ticket = TicketMapper.ToModel(ticketAddDTO);
        ticketRepository.save(ticket);
    }

    public Iterable<TicketGetDTO> findTicketByPassengerId(String passengerId) {
        Iterable<FlightTicket> tickets = ticketRepository.findByPassengerId(passengerId);
        return TicketMapper.ToDto(tickets);
    }

    public void changeTicketStatus(String ticketId) {
        ticketRepository.updateFlightTicketStatus(ticketId,true);
    }
}
