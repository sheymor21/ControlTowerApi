package com.sheymor.controltower.Repositories;

import com.sheymor.controltower.Entities.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirplaneRepository extends JpaRepository<Airplane, String> {
    Optional<Airplane> findByCode(String code);
    void deleteByCode(String code);
}
