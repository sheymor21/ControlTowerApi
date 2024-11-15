package com.sheymor.controltower.Mappers;

import com.sheymor.controltower.Dto.Ticket.TicketAddDTO;
import com.sheymor.controltower.Dto.Ticket.TicketGetDTO;
import com.sheymor.controltower.Entities.Flight;
import com.sheymor.controltower.Entities.FlightTicket;
import com.sheymor.controltower.Entities.Passenger;

import java.util.ArrayList;
import java.util.List;

public abstract class TicketMapper {
    public static FlightTicket ToModel(TicketAddDTO ticketAddDTO) {
        FlightTicket ticket = new FlightTicket();
        Flight flight = new Flight();
        Passenger passenger = new Passenger();
        flight.setFlightId(ticketAddDTO.flightId());
        passenger.setPassengerId(ticketAddDTO.passengerId());
        ticket.setPassenger(passenger);
        ticket.setFlight(flight);
        ticket.setBoarded(false);
        ticket.setCabinClass(ticketAddDTO.cabinClass());
        return ticket;

    }

    public static Iterable<TicketGetDTO> ToDto(Iterable<FlightTicket> tickets) {
        List<TicketGetDTO> ticketGetDTOS = new ArrayList<>();
        for (FlightTicket ticket : tickets) {
            ticketGetDTOS.add(ToGetDTO(ticket));
        }
        return ticketGetDTOS;
    }

    public static TicketGetDTO ToGetDTO(FlightTicket ticket) {
        return new TicketGetDTO(
                ticket.getId(),
                ticket.getBoarded(),
                ticket.getCabinClass().name().toLowerCase()
        );
    }
}
