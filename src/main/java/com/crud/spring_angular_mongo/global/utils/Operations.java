package com.crud.spring_angular_mongo.global.utils;

public class Operations {

    public static String trimBrackets (String message) {
        return message.replaceAll("[\\[\\]]", "");
    }

}
