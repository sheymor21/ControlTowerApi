package com.sheymor.controltower.Validations;

import com.sheymor.controltower.Repositories.FlightRepository;
import com.sheymor.controltower.Repositories.TicketRepository;
import com.sheymor.controltower.Validations.Annotations.ValidPassengerLimit;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class PassengerLimitValidation implements ConstraintValidator<ValidPassengerLimit, String> {

    private final TicketRepository ticketRepository;
    private final FlightRepository flightRepository;

    @Autowired
    public PassengerLimitValidation(TicketRepository ticketRepository, FlightRepository flightRepository) {
        this.ticketRepository = ticketRepository;
        this.flightRepository = flightRepository;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        var ticketCount = ticketRepository.countFlightTicketByFlight_FlightId(s);
        var passengerLimit = flightRepository.getPassengerLimitByFlightId(s);
        return ticketCount < passengerLimit;
    }
}
