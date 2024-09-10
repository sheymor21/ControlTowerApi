package com.example.controltower.Services;

import com.example.controltower.Dto.Flight.CreateFlightDTO;
import com.example.controltower.Dto.Flight.GetFlightsDTO;
import com.example.controltower.Entities.Flights;
import com.example.controltower.Mappers.FlightMapper;
import com.example.controltower.Repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void save(CreateFlightDTO dto) {

        flightRepository.save(FlightMapper.toFlights(dto));
    }

    public Iterable<GetFlightsDTO> findByAirport(String code) {
        List<GetFlightsDTO> flightsDTOS = new ArrayList<>();
        Iterable<Flights> flights = flightRepository.findByAirportHomeCode(code);
        for (Flights f : flights) {
            flightsDTOS.add(FlightMapper.toGetFlightDTO(f));
        }
        return flightsDTOS;
    }

    public Iterable<GetFlightsDTO> findByAirplane(String code) {
        List<GetFlightsDTO> flightsDTOS = new ArrayList<>();
        Iterable<Flights> flights = flightRepository.findByAirplaneCode(code);
        for (Flights f : flights) {
            flightsDTOS.add(FlightMapper.toGetFlightDTO(f));
        }
        return flightsDTOS;
    }
}
