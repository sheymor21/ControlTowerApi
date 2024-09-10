package com.example.controltower.Repositories;

import com.example.controltower.Entities.Airport;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport, String> {
    @Transactional
    void deleteByCode(String code);

    Optional<Airport> findByCode(String code);

}
