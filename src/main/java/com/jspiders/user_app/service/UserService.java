package com.jspiders.user_app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.user_app.dao.UserDao;
import com.jspiders.user_app.entity.User;
import com.jspiders.user_app.response.ResponseStructure;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public ResponseStructure<User> registerUser(User user) {
		User user2 = userDao.registerUser(user);
		ResponseStructure<User> structure = new ResponseStructure<User>();
		structure.setData(user2);
		structure.setTimeStamp(LocalDateTime.now());
		structure.setMessage("User Record created");
		structure.setStatusCode(201);
		return structure;
	}

	public Optional<User> getId(@RequestParam int userId) {
		Optional<User> optional = userDao.getId(userId);
		return optional;
	}

	public List<User> getAllUser() {
		List<User> optional = userDao.getAllUser();
		return optional;
	}

	public User updateUser(User user, int userId) {
		User user2 = userDao.updateUser(user, userId);
		return user2;
	}

	public String deleteUser(int userId) {
		String message = userDao.deleteUser(userId);
		return message;
	}

	public String deleteAll() {
		String message = userDao.deleteAll();
		return message;
	}

	public Page<User> getUserByPage(int pageNo) {
		Page<User> page = userDao.getUserByPage(pageNo);
		return page;
	}

}