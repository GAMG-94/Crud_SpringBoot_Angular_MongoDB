package com.crud.spring_angular_mongo.crud.controller;


import com.crud.spring_angular_mongo.crud.dto.ProductDto;
import com.crud.spring_angular_mongo.crud.entity.Product;
import com.crud.spring_angular_mongo.crud.service.ProductService;
import com.crud.spring_angular_mongo.global.dto.MessageDto;
import com.crud.spring_angular_mongo.global.exceptions.AttributeException;
import com.crud.spring_angular_mongo.global.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    // Listando los Productos
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    // Listando por Id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    // Guardando un Producto
    @PostMapping
    public ResponseEntity<MessageDto> saveProduct(@Valid @RequestBody ProductDto dto) throws AttributeException {
        Product product = productService.saveProduct(dto);
        String message = "Product " + product.getName() + " has been saved";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    // Actualizando un Producto
    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> updateProduct(@PathVariable("id") Integer id, @Valid @RequestBody ProductDto dto) throws ResourceNotFoundException, AttributeException {
        Product product = productService.updateProduct(id, dto);
        String message = "Product " + product.getName() + " has been updated";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    // Eliminar Producto
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> deleteProduct(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        Product product = productService.deleteProduct(id);
        String message = "Product " + product.getName() + " has been deleted";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

}
