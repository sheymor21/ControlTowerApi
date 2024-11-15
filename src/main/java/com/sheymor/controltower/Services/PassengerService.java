package com.sheymor.controltower.Services;

import com.sheymor.controltower.Dto.Passenger.PassengerAddDTO;
import com.sheymor.controltower.Dto.Passenger.PassengerGetDTO;
import com.sheymor.controltower.Dto.Passenger.PassengerUpdateDTO;
import com.sheymor.controltower.Entities.Passenger;
import com.sheymor.controltower.Mappers.PassengerMapper;
import com.sheymor.controltower.Repositories.PassengerRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PassengerService {
    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
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


    @Transactional
    public void updateByPassengerId(String passengerId, PassengerUpdateDTO dto) {
        var optionalPassenger = passengerRepository.findById(passengerId);
        if (optionalPassenger.isPresent()) {
            Passenger passenger = optionalPassenger.get();
            passenger.setFirstName(dto.firstName());
            passenger.setLastName(dto.lastName());
            passengerRepository.save(passenger);
        }

    }

}
