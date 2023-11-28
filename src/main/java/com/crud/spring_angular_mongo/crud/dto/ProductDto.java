package com.crud.spring_angular_mongo.crud.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductDto {

    @NotBlank(message = "Product name is mandatory")
    private String name;

    @Min(value = 1, message = "Product price is mandatory")
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
