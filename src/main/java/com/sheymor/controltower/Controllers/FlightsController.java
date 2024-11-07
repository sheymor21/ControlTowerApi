package com.sheymor.controltower.Controllers;

import com.sheymor.controltower.Dto.Flight.FlightStatusDTO;
import com.sheymor.controltower.Dto.Flight.FlightAddDTO;
import com.sheymor.controltower.Dto.Flight.FlightsGetDTO;
import com.sheymor.controltower.Dto.Flight.FlightUpdateDTO;
import com.sheymor.controltower.Services.FlightService;
import com.sheymor.controltower.Validations.Customs.ValidAirplaneCodePresent;
import com.sheymor.controltower.Validations.Customs.ValidAirportCodePresent;
import com.sheymor.controltower.Validations.Customs.ValidFlightId;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Flights")
@Tag(name = "Flights Controller")
@Validated()
public class FlightsController {

    private final FlightService flightService;

    @Autowired
    public FlightsController(FlightService flightService) {
        this.flightService = flightService;

    }

    @PostMapping
    public ResponseEntity<String> createFlight(@RequestBody @Valid FlightAddDTO dto) {
        flightService.save(dto);
        return new ResponseEntity<>("Flight created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/Airport/{airportCode}")
    public ResponseEntity<Iterable<FlightsGetDTO>> findByAirport(@PathVariable @ValidAirportCodePresent String airportCode) {
        return new ResponseEntity<>(flightService.findByAirport(airportCode), HttpStatus.OK);
    }

    @GetMapping("/Airplane/{airplaneCode}")
    public ResponseEntity<Iterable<FlightsGetDTO>> findByAirplane(@PathVariable @ValidAirplaneCodePresent String airplaneCode) {
        return new ResponseEntity<>(flightService.findByAirplane(airplaneCode), HttpStatus.OK);
    }

    @PutMapping("/ChangeStatus")
    public ResponseEntity<String> changeStatus(@RequestBody @Valid FlightStatusDTO dto) {
        flightService.changeStatus(dto);
        return new ResponseEntity<>("Change successfully", HttpStatus.OK);
    }

    @PutMapping("/{flightId}")
    public ResponseEntity<String> updateFlight(@PathVariable @ValidFlightId String flightId, @RequestBody @Valid FlightUpdateDTO dto) {
        flightService.updateByFlightId(flightId, dto);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
