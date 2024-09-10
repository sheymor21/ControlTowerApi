package com.example.controltower.Controllers;

import com.example.controltower.Dto.Airplane.ChangeAirportDTO;
import com.example.controltower.Dto.Airplane.CreateAirplaneDTO;
import com.example.controltower.Dto.Airplane.GetAirplaneDTO;
import com.example.controltower.Services.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Airplanes")
public class AirplaneController {

    private final AirplaneService airplaneService;

    @Autowired
    public AirplaneController(AirplaneService airplaneService) {

        this.airplaneService = airplaneService;
    }

    @PostMapping
    public void createAirplane(@RequestBody CreateAirplaneDTO dto) {
        airplaneService.save(dto);
    }

    @PutMapping("/ChangeAirport")
    public void changeAirport(@RequestBody ChangeAirportDTO dto) {
        airplaneService.changeAirport(dto);
    }

    @GetMapping
    public Iterable<GetAirplaneDTO> getAllAirplanes() {
        return airplaneService.findAll();
    }

    @DeleteMapping("/{code}")
    public void deleteAirplane(@PathVariable String code) {
        airplaneService.deleteAirplane(code);
    }
}
