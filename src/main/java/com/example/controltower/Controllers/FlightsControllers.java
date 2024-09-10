package com.example.controltower.Controllers;

import com.example.controltower.Dto.Flight.CreateFlightDTO;
import com.example.controltower.Dto.Flight.GetFlightsDTO;
import com.example.controltower.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Flights")
public class FlightsControllers {

    private final FlightService flightService;

    @Autowired
    public FlightsControllers(FlightService flightService) {
        this.flightService = flightService;

    }

    @PostMapping
    public void createFlight(CreateFlightDTO dto) {
        flightService.save(dto);
    }

    @GetMapping("/Airport/{code}")
    public Iterable<GetFlightsDTO> findByAirport(@PathVariable String code) {
        return flightService.findByAirport(code);
    }

    @GetMapping("/Airplane/{code}")
    public Iterable<GetFlightsDTO> findByAirplane(@PathVariable String code) {
        return flightService.findByAirplane(code);
    }
}
