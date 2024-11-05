package com.sheymor.controltower.Services;

import com.sheymor.controltower.Dto.Passenger.PassengerAddDTO;
import com.sheymor.controltower.Dto.Passenger.PassengerGetDTO;
import com.sheymor.controltower.Dto.Passenger.PassengerUpdateDTO;
import com.sheymor.controltower.Dto.Ticket.FlightTicketAddDTO;
import com.sheymor.controltower.Entities.Passenger;
import com.sheymor.controltower.Mappers.PassengerMapper;
import com.sheymor.controltower.Repositories.PassengerRepository;
import com.sheymor.controltower.Repositories.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PassengerService {
    private final PassengerRepository passengerRepository;
    private final TicketRepository ticketRepository;

    public PassengerService(PassengerRepository passengerRepository, TicketRepository ticketRepository) {
        this.passengerRepository = passengerRepository;
        this.ticketRepository = ticketRepository;
    }

    @Transactional
    public void save(PassengerAddDTO dto) {
        Passenger passenger = new Passenger(dto.firstName(), dto.lastName());
        passengerRepository.save(passenger);
    }

    public Iterable<PassengerGetDTO> findAll() {
        Iterable<Passenger> passengers = passengerRepository.findAll();
        return PassengerMapper.ToGetDTO(passengers);

    }

    public Iterable<PassengerGetDTO> findByFlight(String flightId) {
        Iterable<Passenger> passengers = passengerRepository.findByFlightId(flightId);
        return PassengerMapper.ToGetDTO(passengers);
    }

    public void AddPassengerToFlight(FlightTicketAddDTO flightTicketAddDTO) {
        ticketRepository.saveByIds(flightTicketAddDTO.flightId(), flightTicketAddDTO.passengerId(), flightTicketAddDTO.cabinClass());
    }

    @Transactional
    public void updateByPassengerId(String passengerId, PassengerUpdateDTO dto) {
        var optionalPassenger = passengerRepository.findById(passengerId);
        if (optionalPassenger.isPresent()) {
            var passenger = optionalPassenger.get();
            passenger.setFirstName(dto.firstName());
            passenger.setLastName(dto.lastName());
            passengerRepository.save(passenger);
        }

    }

}
