package com.example.controltower.Services;

import com.example.controltower.Dto.Airports.CreateAirportDTO;
import com.example.controltower.Dto.Airports.UpdateAirportDTO;
import com.example.controltower.Entities.Airport;
import com.example.controltower.Mappers.AirportMapper;
import com.example.controltower.Repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public void save(CreateAirportDTO dto) {
        airportRepository.save(AirportMapper.ToAirport(dto));
    }

    public Iterable<Airport> findAll() {
        return airportRepository.findAll();
    }

    public void deleteByCode(String code) {
        airportRepository.deleteByCode(code);
    }

    public void updateByAirport(String code, UpdateAirportDTO dto) {
        Optional<Airport> optionalAirport = airportRepository.findByCode(code);
        if (optionalAirport.isPresent()) {
            Airport airport = optionalAirport.get();
            airport.setAirportName(dto.getName());
            airport.setCode(code);
            airport.setAirportCity(dto.getCity());
            airport.setAirportCountry(dto.getCountry());
            airportRepository.save(airport);
        } else {
            throw new RuntimeException("incorrect code");
        }
    }


}
