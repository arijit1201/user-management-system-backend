package com.akagami.micro.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.akagami.micro.domain.User;


public interface UserRepository extends MongoRepository<User, String>{

	List<User> findByCity(String city);
	@Query("{'college': ?1, 'city': ?0}")
	List<User> findUsingCityAndCollege(String city, String college);
}
