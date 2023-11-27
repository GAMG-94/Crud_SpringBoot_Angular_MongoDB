package com.crud.spring_angular_mongo.global.dto;

import org.springframework.http.HttpStatus;

public class MessageDto {

    private HttpStatus httpStatus;
    private String message;

    public MessageDto() {
    }

    public MessageDto(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
