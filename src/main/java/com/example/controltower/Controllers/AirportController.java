package com.example.controltower.Controllers;

import com.example.controltower.Dto.Airports.CreateAirportDTO;
import com.example.controltower.Dto.Airports.UpdateAirportDTO;
import com.example.controltower.Entities.Airport;
import com.example.controltower.Mappers.AirportMapper;
import com.example.controltower.Services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Airports")
public class AirportController {
    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportRepository) {
        this.airportService = airportRepository;
    }

    @PostMapping
    public void addAirport(@RequestBody CreateAirportDTO airport) {
        airportService.save(airport);
    }

    @GetMapping
    public Iterable<Airport> getAllAirports() {
        return airportService.findAll();
    }

    @DeleteMapping("/{code}")
    public void deleteAirport(@PathVariable String code) {
        airportService.deleteByCode(code);
    }

    @PutMapping("/{code}")
    public void updateAirport(@PathVariable String code, @RequestBody UpdateAirportDTO dto) {
        airportService.updateByAirport(code, dto);
    }
}
