package com.example.controltower.Services;

import com.example.controltower.Dto.Airplane.ChangeAirportDTO;
import com.example.controltower.Dto.Airplane.CreateAirplaneDTO;
import com.example.controltower.Dto.Airplane.GetAirplaneDTO;
import com.example.controltower.Entities.Airplane;
import com.example.controltower.Entities.Airport;
import com.example.controltower.Mappers.AirplaneMapper;
import com.example.controltower.Repositories.AirplaneRepository;
import com.example.controltower.Repositories.AirportRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirplaneService {

    private final AirplaneRepository airplaneRepository;
    private final AirportRepository airportRepository;

    @Autowired
    public AirplaneService(AirplaneRepository airplaneRepository, AirportRepository airportRepository) {

        this.airplaneRepository = airplaneRepository;
        this.airportRepository = airportRepository;
    }

    public void save(CreateAirplaneDTO dto) {
        Optional<Airport> optionalAirport = airportRepository.findByCode(dto.getAirportCode());
        if (optionalAirport.isPresent()) {
            Airplane airplane = AirplaneMapper.toAirplane(dto);
            airplane.setAirport(optionalAirport.get());
            airplaneRepository.save(airplane);
        } else {
            throw new RuntimeException("incorrect airport code");
        }
    }

    public Iterable<GetAirplaneDTO> findAll() {
        return AirplaneMapper.toGetAirplaneDTO(airplaneRepository.findAll());
    }

    @Transactional
    public void changeAirport(ChangeAirportDTO dto) {
        Optional<Airport> optionalAirport = airportRepository.findByCode(dto.getAirportCode());
        Optional<Airplane> optionalAirplane = airplaneRepository.findByCode(dto.getAirplaneCode());
        if (optionalAirport.isPresent() && optionalAirplane.isPresent()) {
            optionalAirplane.get().setAirport(optionalAirport.get());
            airplaneRepository.save(optionalAirplane.get());
        } else {
            throw new RuntimeException("incorrect airport code");
        }

    }

    @Transactional
    public void deleteAirplane(String code) {
        airplaneRepository.deleteByCode(code);
    }
}
