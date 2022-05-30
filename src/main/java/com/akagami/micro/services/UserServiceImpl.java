package com.akagami.micro.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akagami.micro.domain.UserEntity;
import com.akagami.micro.models.User;
import com.akagami.micro.repositories.UserEntityRepository;
import com.akagami.micro.utils.HelperUtils;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserEntityRepository repo;

	@Override
	public User saveUser(User user) {
		UserEntity userEntity = new UserEntity();
		Iterable<String> props = new ArrayList<String>(Arrays.asList("firstName", "lastName", "emailId"));
		HelperUtils.copyProperties(user, userEntity, props);
		userEntity = repo.save(userEntity);
		return user;
	}
	@Override
	public List<User> getAllUsers() {
		List<UserEntity> userEntities = repo.findAll();
		List<User> users = userEntities.stream().map( 
				userEntity -> new User(
				userEntity.getId(), 
				userEntity.getFirstName(), 
				userEntity.getLastName(), 
				userEntity.getEmailId()) )
				.collect(Collectors.toList());
		return users;
	}
	@Override
	public User getUserById(String id) {
		UserEntity userEntity = repo.findById(id).get();
		User user = new User();
		Iterable<String> props = new ArrayList<String>(Arrays.asList("id","firstName", "lastName", "emailId"));
		HelperUtils.copyProperties(userEntity, user, props);
		//BeanUtils.copyProperties(userEntity, user);
		return user;
	}
	@Override
	public boolean deleteUser(String id) {
		UserEntity userEntity = repo.findById(id).get();
		repo.delete(userEntity);
		return true;
	}
	@Override
	public User updateUser(String id, User user) {
		UserEntity userEntity = repo.findById(id).get();
		Iterable<String> props = new ArrayList<String>(Arrays.asList("firstName", "lastName", "emailId"));
		HelperUtils.copyProperties(user, userEntity, props);
		repo.save(userEntity);
		return user;
	}

}
