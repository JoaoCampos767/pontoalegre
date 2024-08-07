package com.pontoalegre.pontoalegre.services.impl;

import com.pontoalegre.pontoalegre.dtos.UserRecordDto;
import com.pontoalegre.pontoalegre.models.UserModel;
import com.pontoalegre.pontoalegre.repositories.UserRepository;
import com.pontoalegre.pontoalegre.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel saveUser(UserRecordDto userRecordDto) {
        var userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDto, userModel);
        return userRepository.save(userModel);
    }

    @Override
    public List<UserModel> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserModel> getOneUser(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public UserModel updateUser(UUID id, UserRecordDto userRecordDto) {
        Optional<UserModel> userO = userRepository.findById(id);
        if(userO.isPresent()) {
            var userModel = new UserModel();
            BeanUtils.copyProperties(userRecordDto, userModel);
            return userRepository.save(userModel);
        }
        return null;
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
