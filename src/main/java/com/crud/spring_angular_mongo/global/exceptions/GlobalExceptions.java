package com.crud.spring_angular_mongo.global.exceptions;

import com.crud.spring_angular_mongo.global.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<MessageDto> throwNotFoundException(ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDto(HttpStatus.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler(AttributeException.class)
    public ResponseEntity<MessageDto> throwAttributeException(AttributeException e) {
        return ResponseEntity.badRequest().body(new MessageDto(HttpStatus.BAD_REQUEST, e.getMessage()));
    }

}
