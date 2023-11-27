package com.crud.spring_angular_mongo.crud.dto;

public class ProductDto {

    private String name;
    private Long price;

    public ProductDto() {
    }

    public ProductDto(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
