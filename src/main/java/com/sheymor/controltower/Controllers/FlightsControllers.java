package com.sheymor.controltower.Controllers;

import com.sheymor.controltower.Dto.Flight.ChangeStatusDTO;
import com.sheymor.controltower.Dto.Flight.CreateFlightDTO;
import com.sheymor.controltower.Dto.Flight.GetFlightsDTO;
import com.sheymor.controltower.Services.FlightService;
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
    public void createFlight(@RequestBody CreateFlightDTO dto) {
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

    @PutMapping("/ChangeStatus")
    public void changeStatus(@RequestBody ChangeStatusDTO dto) {
        flightService.changeStatus(dto);
    }
}
