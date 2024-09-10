package com.sheymor.controltower.Services;

import com.sheymor.controltower.Dto.Flight.CreateFlightDTO;
import com.sheymor.controltower.Dto.Flight.GetFlightsDTO;
import com.sheymor.controltower.Entities.Flights;
import com.sheymor.controltower.Mappers.FlightMapper;
import com.sheymor.controltower.Repositories.FlightRepository;
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
