package com.crud.spring_angular_mongo.crud.service;

import com.crud.spring_angular_mongo.crud.dto.ProductDto;
import com.crud.spring_angular_mongo.crud.entity.Product;
import com.crud.spring_angular_mongo.crud.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    IProductRepository productRepository;

    // Obteniendo toda la lista
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    // Obteniendo solo el Id
    public Product getProduct(Integer id) {
        return productRepository.findById(id).get();
    }

    // Obteniendo solo el Id
    public Product saveProduct(ProductDto dto) {
        int id = autoIncrement();
        Product product = new Product(id, dto.getName(), dto.getPrice());
        return productRepository.save(product);
    }

    // Actualizando el Producto
    public Product updateProduct(Integer id, ProductDto dto) {
        Product product = productRepository.findById(id).get();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        return productRepository.save(product);
    }

    // Eliminando el Producto
    public Product deleteProduct(Integer id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
        return product;
    }

    // Método privado de Autoincrementar el Id
    private int autoIncrement() {
        List<Product> products = productRepository.findAll();
        return products.isEmpty()? 1 : products.stream().max(Comparator.comparing(Product::getId)).get().getId() + 1;
    }

}
