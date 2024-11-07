package com.sheymor.controltower.Controllers;

import com.sheymor.controltower.Dto.Ticket.FlightTicketAddDTO;
import com.sheymor.controltower.Services.PassengerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Ticket")
@Tag(name = "Ticket Controller")
public class TicketController {
    private final PassengerService passengerService;

    public TicketController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping
    public ResponseEntity<String> CreateTicket(@Valid @RequestBody FlightTicketAddDTO flightTicketAddDTO) {
        passengerService.AddPassengerToFlight(flightTicketAddDTO);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }
}
