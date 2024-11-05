package com.sheymor.controltower.Services;

import com.sheymor.controltower.Dto.Airports.AirportAddDTO;
import com.sheymor.controltower.Dto.Airports.AirportGetDTO;
import com.sheymor.controltower.Dto.Airports.AirportUpdateDTO;
import com.sheymor.controltower.Entities.Airport;
import com.sheymor.controltower.Mappers.AirportMapper;
import com.sheymor.controltower.Repositories.AirportRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Transactional
    public void save(AirportAddDTO dto) {
        Airport airport = AirportMapper.ToAirport(dto);
        airportRepository.save(airport);
    }

    public Iterable<AirportGetDTO> findAll() {
        Iterable<Airport> airports = airportRepository.findAll();
        return AirportMapper.toDTO(airports);
    }

    public void deleteByCode(String code) {
        airportRepository.deleteByCode(code);
    }

    public void updateByAirport(String code, AirportUpdateDTO dto) {
        Optional<Airport> optionalAirport = airportRepository.findByCode(code);
        if (optionalAirport.isPresent()) {
            Airport airport = optionalAirport.get();
            airport.setAirportName(dto.name());
            airport.setCode(code);
            airport.setAirportCity(dto.city());
            airport.setAirportCountry(dto.country());
            airportRepository.save(airport);
        } else {
            throw new RuntimeException("incorrect code");
        }
    }


}
