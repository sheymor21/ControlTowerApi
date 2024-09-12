package com.sheymor.controltower.Controllers;

import com.sheymor.controltower.Dto.Airplane.ChangeAirportDTO;
import com.sheymor.controltower.Dto.Airplane.CreateAirplaneDTO;
import com.sheymor.controltower.Dto.Airplane.GetAirplaneDTO;
import com.sheymor.controltower.Services.AirplaneService;
import com.sheymor.controltower.Validations.Customs.ValidAirplaneCodePresent;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Airplanes")
@Validated
public class AirplaneController {

    private final AirplaneService airplaneService;

    @Autowired
    public AirplaneController(AirplaneService airplaneService) {

        this.airplaneService = airplaneService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> createAirplane(@Valid @RequestBody CreateAirplaneDTO dto) {
        airplaneService.save(dto);
        return new ResponseEntity<>("Airplane created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/ChangeAirport")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> changeAirport(@Valid @RequestBody ChangeAirportDTO dto) {
        airplaneService.changeAirport(dto);
        return new ResponseEntity<>("Change successfully", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<GetAirplaneDTO>> getAllAirplanes() {
        return new ResponseEntity<>(airplaneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteAirplane(@PathVariable("code") @Valid @ValidAirplaneCodePresent String code) {
        airplaneService.deleteAirplane(code);
        return new ResponseEntity<>("Airplane deleted successfully", HttpStatus.OK);
    }
}
