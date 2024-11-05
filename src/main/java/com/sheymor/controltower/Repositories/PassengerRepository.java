package com.sheymor.controltower.Repositories;

import com.sheymor.controltower.Entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PassengerRepository extends JpaRepository<Passenger, String> {

    @Query("select p from Passenger p inner join FlightTicket f on p.passengerId = f.passenger.passengerId where f.flight.flightId = :flightId")
    Iterable<Passenger> findByFlightId(@Param("flightId") String flightId);
}
