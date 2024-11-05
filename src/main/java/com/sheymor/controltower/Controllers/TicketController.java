package com.sheymor.controltower.Controllers;

import com.sheymor.controltower.Dto.Ticket.FlightTicketAddDTO;
import com.sheymor.controltower.Services.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Ticket")
@Validated
public class TicketController {
    private final PassengerService passengerService;

    public TicketController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping
    public ResponseEntity<String> CreateTicket(@RequestBody FlightTicketAddDTO flightTicketAddDTO){
        passengerService.AddPassengerToFlight(flightTicketAddDTO);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }
}
