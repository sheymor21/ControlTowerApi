package com.example.controltower.Repositories;

import com.example.controltower.Entities.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flights, String> {
    Iterable<Flights> findByAirplaneCode(String code);

    Iterable<Flights> findByAirportHomeCode(String code);
}
