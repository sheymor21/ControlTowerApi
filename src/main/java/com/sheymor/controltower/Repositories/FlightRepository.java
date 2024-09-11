package com.sheymor.controltower.Repositories;

import com.sheymor.controltower.Entities.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends JpaRepository<Flights, String> {
    @Query("select f from Flights f where f.airplaneCode = :airplaneCode")
    Iterable<Flights> findByAirplaneCode(@Param("airplaneCode") String airplaneCode);

    @Query("select f from Flights f where f.airportHomeCode = :airportHomeCode")
    Iterable<Flights> findByAirportHomeCode(@Param("airportHomeCode") String airportHomeCode);
}
