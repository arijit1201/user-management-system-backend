package com.akagami.micro.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import com.akagami.micro.domain.UserEntity;


public interface UserEntityRepository extends MongoRepository<UserEntity, String>{

	
}
