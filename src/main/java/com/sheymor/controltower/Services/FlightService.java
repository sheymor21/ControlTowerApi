package com.sheymor.controltower.Services;

import com.sheymor.controltower.Dto.Flight.FlightStatusDTO;
import com.sheymor.controltower.Dto.Flight.FlightAddDTO;
import com.sheymor.controltower.Dto.Flight.FlightsGetDTO;
import com.sheymor.controltower.Dto.Flight.FlightUpdateDTO;
import com.sheymor.controltower.Entities.Airplane;
import com.sheymor.controltower.Entities.Airport;
import com.sheymor.controltower.Entities.Flight;
import com.sheymor.controltower.Mappers.FlightMapper;
import com.sheymor.controltower.Repositories.AirplaneRepository;
import com.sheymor.controltower.Repositories.AirportRepository;
import com.sheymor.controltower.Repositories.FlightRepository;
import jakarta.transaction.Transactional;
import org.apache.commons.validator.routines.DateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public void save(FlightAddDTO dto) {

        Flight flight = FlightMapper.toFlights(dto);
        Optional<Airplane> optionalAirplane = airplaneRepository.findByCode(dto.airplaneCode());
        Optional<Airport> optionalAirport = airportRepository.findByCode(dto.airportHomeCode());
        Optional<Airport> optionalAirportDestination = airportRepository.findByCode(dto.airportDestinationCode());

        if (optionalAirplane.isPresent() && optionalAirport.isPresent() && optionalAirportDestination.isPresent()) {

            flight.setAirplane(optionalAirplane.get());
            flight.setAirport(optionalAirport.get());
            flight.setStatus(Flight.Status.WAITING);
            flightRepository.save(flight);
        }

    }

    public Iterable<FlightsGetDTO> findByAirport(String code) {
        List<FlightsGetDTO> flightsDTOS = new ArrayList<>();
        Iterable<Flight> flights = flightRepository.findByAirportHomeCode(code);
        for (Flight f : flights) {
            flightsDTOS.add(FlightMapper.toGetFlightDTO(f));
        }
        return flightsDTOS;
    }

    public Iterable<FlightsGetDTO> findByAirplane(String code) {
        List<FlightsGetDTO> flightsDTOS = new ArrayList<>();
        Iterable<Flight> flights = flightRepository.findByAirplaneCode(code);
        for (Flight f : flights) {

            flightsDTOS.add(FlightMapper.toGetFlightDTO(f));
        }
        return flightsDTOS;
    }

    @Transactional
    public void changeStatus(FlightStatusDTO dto) {
        Optional<Flight> flights = flightRepository.findById(dto.flightId());
        if (flights.isPresent()) {
            Flight flight = flights.get();
            flight.setStatus(Flight.Status.valueOf(dto.status().toUpperCase()));
            flightRepository.save(flight);
        } else {
            throw new RuntimeException("incorrect flight id");
        }
    }

    @Transactional
    public void updateByFlightId(String flightId, FlightUpdateDTO dto) {
        Optional<Flight> optionalFlights = flightRepository.findById(flightId);
        if (optionalFlights.isPresent()) {
            Flight flight = optionalFlights.get();
            Optional<Airport> optionalAirport = airportRepository.findByCode(dto.airportHomeCode());
            Optional<Airport> optionalAirportDestination = airportRepository.findByCode(dto.airportDestinationCode());
            Optional<Airplane> optionalAirplane = airplaneRepository.findByCode(dto.airplaneCode());

            if (optionalAirplane.isPresent() && optionalAirport.isPresent() && optionalAirportDestination.isPresent()) {
                DateValidator dateValidator = DateValidator.getInstance();
                String pattern = "yyyy/MM/dd-HH:mm";
                TimeZone timezone = TimeZone.getTimeZone("UTC");
                Date departureTime = dateValidator.validate(dto.departureTime(), pattern, timezone);
                Date arrivalTime = dateValidator.validate(dto.arrivalTime(), pattern, timezone);
                flight.setAirportHomeCode(dto.airportHomeCode());
                flight.setAirportDestinationCode(dto.airportDestinationCode());
                flight.setAirplaneCode(dto.airplaneCode());
                flight.setAirport(optionalAirport.get());
                flight.setAirplane(optionalAirplane.get());
                flight.setArrivalTime(arrivalTime);
                flight.setDepartureTime(departureTime);
                flightRepository.save(flight);
            }
        }
    }
}
