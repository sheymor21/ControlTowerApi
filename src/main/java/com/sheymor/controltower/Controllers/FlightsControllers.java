package com.sheymor.controltower.Controllers;

import com.sheymor.controltower.Dto.Flight.ChangeStatusDTO;
import com.sheymor.controltower.Dto.Flight.CreateFlightDTO;
import com.sheymor.controltower.Dto.Flight.GetFlightsDTO;
import com.sheymor.controltower.Dto.Flight.UpdateFlightsDTO;
import com.sheymor.controltower.Services.FlightService;
import com.sheymor.controltower.Validations.Customs.ValidAirplaneCodePresent;
import com.sheymor.controltower.Validations.Customs.ValidAirportCodePresent;
import com.sheymor.controltower.Validations.Customs.ValidFlightId;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Flights")
@Validated
public class FlightsControllers {

    private final FlightService flightService;

    @Autowired
    public FlightsControllers(FlightService flightService) {
        this.flightService = flightService;

    }

    @PostMapping
    public ResponseEntity<String> createFlight(@RequestBody @Valid CreateFlightDTO dto) {
        flightService.save(dto);
        return new ResponseEntity<>("Flight created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/Airport/{code}")
    public ResponseEntity<Iterable<GetFlightsDTO>> findByAirport(@PathVariable @ValidAirportCodePresent String code) {
        return new ResponseEntity<>(flightService.findByAirport(code), HttpStatus.OK);
    }

    @GetMapping("/Airplane/{code}")
    public ResponseEntity<Iterable<GetFlightsDTO>> findByAirplane(@PathVariable @ValidAirplaneCodePresent String code) {
        return new ResponseEntity<>(flightService.findByAirplane(code), HttpStatus.OK);
    }

    @PutMapping("/ChangeStatus")
    public ResponseEntity<String> changeStatus(@RequestBody @Valid ChangeStatusDTO dto) {
        flightService.changeStatus(dto);
        return new ResponseEntity<>("Change successfully", HttpStatus.OK);
    }

    @PutMapping("/{flightId}")
    public ResponseEntity<String> updateFlight(@PathVariable @ValidFlightId String flightId, @RequestBody @Valid UpdateFlightsDTO dto) {
        flightService.updateByFlight(flightId, dto);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
