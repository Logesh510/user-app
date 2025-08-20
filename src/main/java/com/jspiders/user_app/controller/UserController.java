package com.jspiders.user_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.user_app.entity.User;
import com.jspiders.user_app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {


	@Autowired
	private UserService userService; 
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		User user2 = userService.registerUser(user);
		return user2;
	}
	
	@GetMapping("/getUser") // GetMapping does not supports body. Get Mapping gives Request Header and Request line.
	public Optional<User> getId(@RequestParam int userId) {
		Optional<User> optional = userService.getId(userId);
		return optional;
	}
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@PutMapping("/update")//localhost:8080/user/update?userId=id
	public User updateUser(@RequestBody User user, @RequestParam int userId){
		User user2 = userService.updateUser(user, userId);
		return user2;
	}
	
	@DeleteMapping("/delete")//localhost:8080/user/update?userId=id
	public String deleteUser(@RequestParam int userId){
		String message = userService.deleteUser(userId);
		return message;
	}
	
	@DeleteMapping("/deleteAll")//localhost:8080/user/update?userId=id
	public String deleteAll(){
		String message = userService.deleteAll();
		return message;
	}
}