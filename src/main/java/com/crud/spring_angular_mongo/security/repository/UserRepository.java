package com.crud.spring_angular_mongo.security.repository;

import com.crud.spring_angular_mongo.security.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, Integer> {

    boolean existByUsername(String username);

    boolean existByEmail(String email);
}
