package com.crud.spring_angular_mongo.crud.repository;

import com.crud.spring_angular_mongo.crud.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends MongoRepository<Product, Integer> {

    boolean existsByName(String name);

    Optional<Product> findByName(String name);

}
