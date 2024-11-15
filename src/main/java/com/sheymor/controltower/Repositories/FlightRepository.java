package com.sheymor.controltower.Repositories;

import com.sheymor.controltower.Entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends JpaRepository<Flight, String> {

    @Query("select a.passengerCapacity from Flight f inner join Airplane a on f.airplane.airplaneId = a.airplaneId where f.flightId = :flightId")
    Integer getPassengerLimitByFlightId(String flightId);

    @Query("select f from Flight f where f.airplaneCode = :airplaneCode")
    Iterable<Flight> findByAirplaneCode(@Param("airplaneCode") String airplaneCode);

    @Query("select f from Flight f where f.airportHomeCode = :airportHomeCode or f.airportDestinationCode = :airportHomeCode")
    Iterable<Flight> findByAirportHomeCode(@Param("airportHomeCode") String airportHomeCode);
}
