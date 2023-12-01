package com.crud.spring_angular_mongo.security.controller;

import com.crud.spring_angular_mongo.global.dto.MessageDto;
import com.crud.spring_angular_mongo.global.exceptions.AttributeException;
import com.crud.spring_angular_mongo.security.dto.UserDto;
import com.crud.spring_angular_mongo.security.entity.UserEntity;
import com.crud.spring_angular_mongo.security.service.UserEntityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserEntityService userEntityService;

    // Creando al usuario
    @PostMapping("/create")
    public ResponseEntity<MessageDto> createUser(@Valid @RequestBody UserDto dto) throws AttributeException {
        UserEntity userEntity =  userEntityService.createUser(dto);
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, "User " + userEntity.getUsername() + " has been created"));
    }

}
