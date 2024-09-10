package com.sheymor.controltower.Services;

import com.sheymor.controltower.Dto.Airports.CreateAirportDTO;
import com.sheymor.controltower.Dto.Airports.UpdateAirportDTO;
import com.sheymor.controltower.Entities.Airport;
import com.sheymor.controltower.Mappers.AirportMapper;
import com.sheymor.controltower.Repositories.AirportRepository;
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
