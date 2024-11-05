package com.sheymor.controltower.Controllers;

import com.sheymor.controltower.Dto.Airports.AirportAddDTO;
import com.sheymor.controltower.Dto.Airports.AirportGetDTO;
import com.sheymor.controltower.Dto.Airports.AirportUpdateDTO;
import com.sheymor.controltower.Services.AirportService;
import com.sheymor.controltower.Validations.Customs.ValidAirportCodePresent;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Airports")
@Tag(name = "Airport Controller")
public class AirportController {
    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportRepository) {
        this.airportService = airportRepository;
    }

    @PostMapping
    public ResponseEntity<String> addAirport(@Valid @RequestBody AirportAddDTO airport) {
        airportService.save(airport);
        return new ResponseEntity<>("Airport added successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<AirportGetDTO>> getAllAirports() {
        Iterable<AirportGetDTO> airports = airportService.findAll();
        return new ResponseEntity<>(airports, HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteAirport(@PathVariable @ValidAirportCodePresent String code) {
        airportService.deleteByCode(code);
        return new ResponseEntity<>("Airport deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<String> updateAirport(@PathVariable @ValidAirportCodePresent String code, @RequestBody @Valid AirportUpdateDTO dto) {
        airportService.updateByAirport(code, dto);
        return new ResponseEntity<>("Airport updated successfully", HttpStatus.OK);
    }
}
