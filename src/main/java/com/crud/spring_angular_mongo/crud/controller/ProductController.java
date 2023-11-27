package com.crud.spring_angular_mongo.crud.controller;


import com.crud.spring_angular_mongo.crud.dto.ProductDto;
import com.crud.spring_angular_mongo.crud.entity.Product;
import com.crud.spring_angular_mongo.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    // Guardando un Producto
    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody ProductDto dto) {
        return ResponseEntity.ok(productService.saveProduct(dto));
    }

    // Actualizando un Producto
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody ProductDto dto) {
        return ResponseEntity.ok(productService.updateProduct(id, dto));
    }

    // Eliminar Producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

}
