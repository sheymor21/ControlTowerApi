package com.sheymor.controltower.Services;

import com.sheymor.controltower.Dto.Airplane.AirportChangeDTO;
import com.sheymor.controltower.Dto.Airplane.AirplaneAddDTO;
import com.sheymor.controltower.Dto.Airplane.AirplaneGetDTO;
import com.sheymor.controltower.Entities.Airplane;
import com.sheymor.controltower.Entities.Airport;
import com.sheymor.controltower.Mappers.AirplaneMapper;
import com.sheymor.controltower.Repositories.AirplaneRepository;
import com.sheymor.controltower.Repositories.AirportRepository;
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

    @Transactional
    public void save(AirplaneAddDTO dto) {
        Optional<Airport> optionalAirport = airportRepository.findByCode(dto.airportCode());
        if (optionalAirport.isPresent()) {
            Airplane airplane = AirplaneMapper.toAirplane(dto);
            airplane.setAirport(optionalAirport.get());
            airplaneRepository.save(airplane);
        } else {
            throw new RuntimeException("incorrect airport code");
        }
    }

    public Iterable<AirplaneGetDTO> findAll() {
        return AirplaneMapper.toGetAirplaneDTO(airplaneRepository.findAll());
    }

    @Transactional
    public void changeAirport(AirportChangeDTO dto) {
        Optional<Airport> optionalAirport = airportRepository.findByCode(dto.airplaneCode());
        Optional<Airplane> optionalAirplane = airplaneRepository.findByCode(dto.airplaneCode());
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
