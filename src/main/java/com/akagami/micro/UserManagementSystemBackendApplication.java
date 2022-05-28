package com.akagami.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.akagami.micro.domain.User;

@SpringBootApplication
@ComponentScan
@EnableMongoRepositories(basePackages = "com.akagami.micro.repositories")
public class UserManagementSystemBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementSystemBackendApplication.class, args);
		
	}

}
