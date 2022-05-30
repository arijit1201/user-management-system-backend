package com.akagami.micro.services;

import java.util.List;


import com.akagami.micro.models.User;

public interface UserService {

	User saveUser(User user);

	List<User> getAllUsers();

	User getUserById(String id);

	boolean deleteUser(String id);

	User updateUser(String id, User user);

}
