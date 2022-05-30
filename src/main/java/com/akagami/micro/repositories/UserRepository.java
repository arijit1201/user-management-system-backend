package com.akagami.micro.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.akagami.micro.domain.UserTemplate;


public interface UserRepository extends MongoRepository<UserTemplate, String>{

	List<UserTemplate> findByCity(String city);
	@Query("{'college': ?1, 'city': ?0}")
	List<UserTemplate> findUsingCityAndCollege(String city, String college);
}
