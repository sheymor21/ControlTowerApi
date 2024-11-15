package com.sheymor.controltower.Controllers;

import com.sheymor.controltower.Dto.Ticket.TicketAddDTO;
import com.sheymor.controltower.Dto.Ticket.TicketGetDTO;
import com.sheymor.controltower.Services.TicketService;
import com.sheymor.controltower.Validations.Annotations.ValidPassengerId;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("Ticket")
@Tag(name = "Ticket Controller")
@Validated
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<String> createTicket(@Valid @RequestBody TicketAddDTO ticketAddDTO) {
        ticketService.AddPassengerToFlight(ticketAddDTO);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @GetMapping("/{passengerId}")
    public ResponseEntity<TicketGetDTO> getTicketByPassenger(@Valid @PathVariable @ValidPassengerId String passengerId) {
        Iterable<TicketGetDTO> ticketGetDTOS = ticketService.findTicketByPassengerId(passengerId);
        return new ResponseEntity<>(ticketGetDTOS.iterator().next(), HttpStatus.OK);
    }

    @PutMapping("/{ticketId}")
    public ResponseEntity<String> updateTicket(@Valid @PathVariable String ticketId) {
        ticketService.changeTicketStatus(ticketId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
