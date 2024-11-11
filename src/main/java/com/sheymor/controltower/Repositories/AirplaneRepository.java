package com.sheymor.controltower.Repositories;

import com.sheymor.controltower.Entities.Airplane;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirplaneRepository extends JpaRepository<Airplane, String> {
    Optional<Airplane> findByCode(String code);
    @Transactional
    void deleteByCode(String code);
}
