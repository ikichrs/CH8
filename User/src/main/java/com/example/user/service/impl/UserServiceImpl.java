package com.example.user.service.impl;

import com.example.user.model.UserEntity;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public List<UserEntity> findalluser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Long userid) {
        return userRepository.findById((userid));
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity updateUser(Long id,UserEntity userEntity) {
        UserEntity userEntityFINDID=userRepository.findById((id)).get();
        userEntityFINDID.setUserid(userEntity.getUserid());
        userEntityFINDID.setUsername(userEntity.getUsername());
        userEntityFINDID.setPassword(userEntity.getPassword());
        userEntityFINDID.setEmail(userEntity.getEmail());

        return userRepository.save(userEntityFINDID);
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById((id));
        return "User Has Been Deleted";
    }
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

}
