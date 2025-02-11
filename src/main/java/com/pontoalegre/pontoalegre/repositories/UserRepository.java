package com.pontoalegre.pontoalegre.repositories;

import com.pontoalegre.pontoalegre.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
