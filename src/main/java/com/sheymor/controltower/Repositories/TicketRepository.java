package com.sheymor.controltower.Repositories;

import com.sheymor.controltower.Entities.FlightTicket;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TicketRepository extends JpaRepository<FlightTicket, Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into flight_ticket(boarded,cabin_class,flight_id,passenger_id) values (false,:cabinClass,:flightId,:passengerId)", nativeQuery = true)
    void saveByIds(@Param("flightId") String flightId, @Param("passengerId") String passengerId, @Param("cabinClass") FlightTicket.CabinClass cabinClass);
}
