package com.jspiders.user_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.user_app.repository.UserRepository;

import com.jspiders.user_app.entity.User;

@Repository
public class UserDao {
	@Autowired
	private UserRepository userRepository;

	public User registerUser(User user) {
		User user2 = userRepository.save(user);
		return user2;
		
	}

	public Optional<User> getId(int id) {
		Optional<User> optional = userRepository.findById(id);
		return optional;
		
	}
	
	public List<User> getAllUser() {
		List<User> optional = userRepository.findAll();
		return optional;
		 
	}

	public User updateUser(User user, int userId) {
		Optional<User> optional = userRepository.findById(userId);
		if(optional.isPresent()) {
			user.setUserId(userId);
			return userRepository.save(user);
		}
		else {
			throw new IllegalArgumentException("Invalid User Id");
		}
	}
	
	public String deleteUser(int userId) {
		Optional<User>  optional = userRepository.findById(userId);
		if(optional.isPresent()) {
			userRepository.delete(optional.get());
			return "User id deleted successfully";
		}
		else {
			throw new IllegalArgumentException("Invalid User Id");
		}
	}
	
	public String deleteAll() {
		
			userRepository.deleteAll();
			return "All id deleted successfully";
		
	}
}
