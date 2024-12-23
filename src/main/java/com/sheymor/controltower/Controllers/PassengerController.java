package com.sheymor.controltower.Controllers;

import com.sheymor.controltower.Dto.Passenger.PassengerAddDTO;
import com.sheymor.controltower.Dto.Passenger.PassengerGetDTO;
import com.sheymor.controltower.Dto.Passenger.PassengerUpdateDTO;
import com.sheymor.controltower.Services.PassengerService;
import com.sheymor.controltower.Validations.Annotations.ValidFlightId;
import com.sheymor.controltower.Validations.Annotations.ValidPassengerId;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Passenger")
@Tag(name = "Passenger Controller")
@Validated
public class PassengerController {
    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {

        this.passengerService = passengerService;
    }

    @PostMapping
    public ResponseEntity<String> createPassenger(@RequestBody PassengerAddDTO passenger) {
        passengerService.save(passenger);
        return new ResponseEntity<>("Passenger created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{passengerId}")
    public ResponseEntity<String> updatePassenger(@PathVariable  @ValidPassengerId String passengerId, @RequestBody PassengerUpdateDTO passenger) {
        passengerService.updateByPassengerId(passengerId, passenger);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<Iterable<PassengerGetDTO>> getPassengersByFlight(@PathVariable @ValidFlightId String flightId) {
        Iterable<PassengerGetDTO> all = passengerService.findByFlight(flightId);
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<PassengerGetDTO>> getPassengers(){
        return new ResponseEntity<>(passengerService.findAll(),HttpStatus.OK);
    }
}
