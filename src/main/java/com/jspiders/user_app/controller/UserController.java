package com.jspiders.user_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.user_app.entity.User;
import com.jspiders.user_app.response.ResponseStructure;
import com.jspiders.user_app.service.UserService;
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService; 
	
	@PostMapping("/register") // ? : Predictor
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		ResponseStructure<User> structure = userService.registerUser(user);

		return new ResponseEntity<>(structure , HttpStatus.CREATED);
	}
	
	@GetMapping("/getUser") // GetMapping does not supports body. Get Mapping gives Request Header and Request line.
	public ResponseStructure<Optional<User>> getId(@RequestParam int userId) {
		ResponseStructure<Optional<User>> optional = userService.getId(userId);
		return optional;
	}
	
	@GetMapping("/getAll")
	public ResponseStructure<List<User>> getAllUser() {
		ResponseStructure<List<User>> optional = userService.getAllUser();
		return optional;		
	}
	
	@PutMapping("/update")
	public ResponseStructure<User> updateUser(@RequestBody User user,@RequestParam int id ) {
		ResponseStructure<User> user2 = userService.updateUser(user, id);
		return user2;
	}
	
	@DeleteMapping("/delete")
	public ResponseStructure<String> deleteUser(@RequestParam int id ) {
		ResponseStructure<String> message = userService.deleteUser(id);
		return message;
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		String message = userService.deleteAll();
		return message;
	}
	@GetMapping("getUserPage")
	public ResponseStructure<Page<User>> getUserByPage(@RequestParam int pageNo) {
		return userService.getUserByPage(pageNo);
	}
	

}