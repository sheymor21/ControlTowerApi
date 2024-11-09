package com.sheymor.controltower.Controllers;

import com.sheymor.controltower.Dto.Airplane.AirportChangeDTO;
import com.sheymor.controltower.Dto.Airplane.AirplaneAddDTO;
import com.sheymor.controltower.Dto.Airplane.AirplaneGetDTO;
import com.sheymor.controltower.Services.AirplaneService;
import com.sheymor.controltower.Validations.Annotations.ValidAirplaneCodePresent;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Airplanes")
@Tag(name = "Airplane Controller")
public class AirplaneController {

    private final AirplaneService airplaneService;

    @Autowired
    public AirplaneController(AirplaneService airplaneService) {

        this.airplaneService = airplaneService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> createAirplane(@Valid @RequestBody AirplaneAddDTO dto) {
        airplaneService.save(dto);
        return new ResponseEntity<>("Airplane created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/ChangeAirport")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> changeAirport(@Valid @RequestBody AirportChangeDTO dto) {
        airplaneService.changeAirport(dto);
        return new ResponseEntity<>("Change successfully", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<AirplaneGetDTO>> getAllAirplanes() {
        return new ResponseEntity<>(airplaneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteAirplane(@PathVariable("code") @Valid @ValidAirplaneCodePresent String code) {
        airplaneService.deleteAirplane(code);
        return new ResponseEntity<>("Airplane deleted successfully", HttpStatus.OK);
    }
}
