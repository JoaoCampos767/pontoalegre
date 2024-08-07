package com.pontoalegre.pontoalegre.services;

import com.pontoalegre.pontoalegre.dtos.UserRecordDto;
import com.pontoalegre.pontoalegre.models.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    UserModel saveUser(UserRecordDto userRecordDto);

    List<UserModel> getAllUser();

    Optional<UserModel> getOneUser(UUID id);

    UserModel updateUser(UUID id, UserRecordDto userRecordDto);

    void deleteUser(UUID id);
}
