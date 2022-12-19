package com.example.user.service;

import com.example.user.model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> findalluser();
    Optional<UserEntity> findById(Long id);
    UserEntity saveUser(UserEntity userEntity);
    UserEntity updateUser(Long id,UserEntity userEntity);
    String deleteUser(Long id);

}
