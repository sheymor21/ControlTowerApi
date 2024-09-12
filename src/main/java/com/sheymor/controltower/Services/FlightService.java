package com.sheymor.controltower.Services;

import com.sheymor.controltower.Dto.Flight.ChangeStatusDTO;
import com.sheymor.controltower.Dto.Flight.CreateFlightDTO;
import com.sheymor.controltower.Dto.Flight.GetFlightsDTO;
import com.sheymor.controltower.Dto.Flight.UpdateFlightsDTO;
import com.sheymor.controltower.Entities.Airplane;
import com.sheymor.controltower.Entities.Airport;
import com.sheymor.controltower.Entities.Flights;
import com.sheymor.controltower.Mappers.FlightMapper;
import com.sheymor.controltower.Repositories.AirplaneRepository;
import com.sheymor.controltower.Repositories.AirportRepository;
import com.sheymor.controltower.Repositories.FlightRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;
    private final AirplaneRepository airplaneRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository, AirportRepository airportRepository, AirplaneRepository airplaneRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
        this.airplaneRepository = airplaneRepository;
    }

    @Transactional
    public void save(CreateFlightDTO dto) {

        Flights flight = FlightMapper.toFlights(dto);
        Optional<Airplane> optionalAirplane = airplaneRepository.findByCode(dto.getAirplaneCode());
        Optional<Airport> optionalAirport = airportRepository.findByCode(dto.getAirportHomeCode());
        Optional<Airport> optionalAirportDestination = airportRepository.findByCode(dto.getAirportDestinationCode());

        if (optionalAirplane.isPresent() && optionalAirport.isPresent() && optionalAirportDestination.isPresent()) {

            flight.setAirplane(optionalAirplane.get());
            flight.setAirport(optionalAirport.get());
            flight.setStatus(ChangeStatusDTO.Status.WAITING.toString());
            flightRepository.save(flight);
        }

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

    @Transactional
    public void changeStatus(ChangeStatusDTO dto) {
        Optional<Flights> flights = flightRepository.findById(dto.getFlightId());
        if (flights.isPresent()) {
            Flights flight = flights.get();
            flight.setStatus(dto.getStatus());
            flightRepository.save(flight);
        } else {
            throw new RuntimeException("incorrect flight id");
        }
    }

    @Transactional
    public void updateByFlight(String flightId, UpdateFlightsDTO dto) {
        Optional<Flights> optionalFlights = flightRepository.findById(flightId);
        if (optionalFlights.isPresent()) {
            Flights flight = optionalFlights.get();
            Optional<Airport> optionalAirport = airportRepository.findByCode(dto.getAirportHomeCode());
            Optional<Airport> optionalAirportDestination = airportRepository.findByCode(dto.getAirportDestinationCode());
            Optional<Airplane> optionalAirplane = airplaneRepository.findByCode(dto.getAirplaneCode());

            if (optionalAirplane.isPresent() && optionalAirport.isPresent() && optionalAirportDestination.isPresent()) {

                flight.setAirportHomeCode(dto.getAirportHomeCode());
                flight.setAirportDestinationCode(dto.getAirportDestinationCode());
                flight.setAirplaneCode(dto.getAirplaneCode());
                flight.setAirport(optionalAirport.get());
                flight.setAirplane(optionalAirplane.get());
                flight.setArrivalTime(dto.getArrivalTime());
                flight.setDepartureTime(dto.getDepartureTime());
                flightRepository.save(flight);
            }
        }
    }
}
