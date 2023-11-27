package com.crud.spring_angular_mongo.crud.service;

import com.crud.spring_angular_mongo.crud.dto.ProductDto;
import com.crud.spring_angular_mongo.crud.entity.Product;
import com.crud.spring_angular_mongo.crud.repository.IProductRepository;
import com.crud.spring_angular_mongo.global.exceptions.AttributeException;
import com.crud.spring_angular_mongo.global.exceptions.ResourceNotFoundException;
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
    public Product getProduct(Integer id) throws ResourceNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
    }

    // Obteniendo solo el Id
    public Product saveProduct(ProductDto dto) throws AttributeException {
        if (productRepository.existsByName(dto.getName()))
            throw new AttributeException("Name already in use");
        int id = autoIncrement();
        Product product = new Product(id, dto.getName(), dto.getPrice());
        return productRepository.save(product);
    }

    // Actualizando el Producto
    public Product updateProduct(Integer id, ProductDto dto) throws ResourceNotFoundException, AttributeException {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        if(productRepository.existsByName(dto.getName()) && productRepository.findByName(dto.getName()).get().getId() != id)
            throw new AttributeException("Name already in use");
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        return productRepository.save(product);
    }

    // Eliminando el Producto
    public Product deleteProduct(Integer id) throws ResourceNotFoundException {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));;
        productRepository.delete(product);
        return product;
    }

    // Método privado de Autoincrementar el Id
    private int autoIncrement() {
        List<Product> products = productRepository.findAll();
        return products.isEmpty()? 1 : products.stream().max(Comparator.comparing(Product::getId)).get().getId() + 1;
    }

}
