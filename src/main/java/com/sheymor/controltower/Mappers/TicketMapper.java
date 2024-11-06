package com.sheymor.controltower.Mappers;

import com.sheymor.controltower.Dto.Ticket.FlightTicketAddDTO;
import com.sheymor.controltower.Entities.Flight;
import com.sheymor.controltower.Entities.FlightTicket;
import com.sheymor.controltower.Entities.Passenger;

public abstract class TicketMapper {
    public static FlightTicket ToModel(FlightTicketAddDTO flightTicketAddDTO){
        FlightTicket ticket = new FlightTicket();
        Flight flight = new Flight();
        Passenger passenger = new Passenger();
        flight.setFlightId(flightTicketAddDTO.flightId());
        passenger.setPassengerId(flightTicketAddDTO.passengerId());
        ticket.setPassenger(passenger);
        ticket.setFlight(flight);
        ticket.setBoarded(false);
        ticket.setCabinClass(flightTicketAddDTO.cabinClass());
        return ticket;

    }
}
