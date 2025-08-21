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
		structure.setMessage("User Record created successfully");
		structure.setStatusCode(200);
		return structure;
		
	}

	public ResponseStructure<Optional<User>> getId(@RequestParam int userId) {
		Optional<User> optional = userDao.getId(userId);
		if(optional.isPresent()) {
			ResponseStructure<Optional<User>> structure = new ResponseStructure<Optional<User>>();
			structure.setData(optional);
			structure.setTimeStamp(LocalDateTime.now());
			structure.setMessage("User Record found successfully");
			structure.setStatusCode(200);
			return structure;
		}
		else {
			throw new IllegalArgumentException("Invalid Id");
		}
		
	}
	
	public ResponseStructure<List<User>> getAllUser() {
		List<User> optional = userDao.getAllUser();
		ResponseStructure<List<User>> structure = new ResponseStructure<List<User>>();
		structure.setData(optional);
		structure.setTimeStamp(LocalDateTime.now());
		structure.setMessage("User Record found successfully");
		structure.setStatusCode(200);
		return structure;
		
	}

	public ResponseStructure<User> updateUser(User user, int id) {
		User user2 = userDao.updateUser(user, id);
		ResponseStructure<User> structure = new ResponseStructure<User>();
		structure.setData(user2);
		structure.setTimeStamp(LocalDateTime.now());
		structure.setMessage("User Record updated successfully");
		structure.setStatusCode(200);
		return structure;
	}

	public ResponseStructure<String> deleteUser(int id) {
		String message = userDao.deleteUser(id);
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(message);
		structure.setTimeStamp(LocalDateTime.now());
		structure.setMessage("User Record deleted successfully");
		structure.setStatusCode(200);
		return structure;
	}

	public String deleteAll() {
		String message = userDao.deleteAll();
		return message;
	}
	
	public ResponseStructure<Page<User>> getUserByPage(int pageNo) {
		Page<User> page = userDao.getUserByPage(pageNo);
		ResponseStructure<Page<User>> structure = new ResponseStructure<Page<User>>();
		structure.setData(page);
		structure.setTimeStamp(LocalDateTime.now());
		structure.setMessage("User Record Found successfully");
		structure.setStatusCode(200);
		return structure;
	}
}