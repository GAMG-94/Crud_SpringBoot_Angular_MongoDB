package com.crud.spring_angular_mongo.security.service;

import com.crud.spring_angular_mongo.global.exceptions.AttributeException;
import com.crud.spring_angular_mongo.security.dto.UserDto;
import com.crud.spring_angular_mongo.security.entity.UserEntity;
import com.crud.spring_angular_mongo.security.enums.RoleEnum;
import com.crud.spring_angular_mongo.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserEntityService{

    @Autowired
    UserRepository userRepository;

    public UserEntity createUser(UserDto dto) throws AttributeException {
        if(userRepository.existByUsername(dto.getUsername()))
            throw new AttributeException("User name already in use");
        if (userRepository.existByEmail(dto.getEmail()))
            throw new AttributeException("Email already in use");
        int id = autoIncrement();
        List<RoleEnum> roles = dto.getRoles().stream().map(RoleEnum::valueOf).collect(Collectors.toList());
        UserEntity userEntity = new UserEntity(id, dto.getUsername(),dto.getPassword(), dto.getEmail(), roles);
        return userRepository.save(userEntity);
    }

    // Método privado de Autoincrementar el Id
    private int autoIncrement() {
        List<UserEntity> users = userRepository.findAll();
        return users.isEmpty()? 1 : users.stream().max(Comparator.comparing(UserEntity::getId)).get().getId() + 1;
    }

}
