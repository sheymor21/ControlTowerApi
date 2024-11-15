package com.sheymor.controltower.Repositories;

import com.sheymor.controltower.Entities.FlightTicket;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TicketRepository extends JpaRepository<FlightTicket, String> {

    @Query("select f from FlightTicket f inner join Passenger p on f.passenger.passengerId = p.passengerId where p.passengerId = :passengerId")
    Iterable<FlightTicket> findByPassengerId(@Param("passengerId") String passengerId);

    Integer countFlightTicketByFlight_FlightId(String flightId);

    @Transactional
    @Modifying
    @Query("update FlightTicket f set f.boarded = :status where f.id = :ticketId")
    void updateFlightTicketStatus(@Param("ticketId") String ticketId, @Param("status") boolean status);
}
