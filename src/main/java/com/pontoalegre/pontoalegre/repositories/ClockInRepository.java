package com.pontoalegre.pontoalegre.repositories;

import com.pontoalegre.pontoalegre.models.ClockInModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClockInRepository extends JpaRepository<ClockInModel, UUID> {
}
