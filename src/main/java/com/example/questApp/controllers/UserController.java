package com.example.questApp.controllers;

import java.util.List;
import java.util.Optional;

import com.example.questApp.services.UserService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.questApp.entities.User;

import com.example.questApp.repos.UserRepository;


@Data
@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService _userService;
	public UserController(UserService userService) {
		this._userService=userService;
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return _userService.GetAllUsers();
	}
	
	@PostMapping
	public User createUser(@RequestBody User newUser) {
		return _userService.SaveUser(newUser);
	}
	
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable Long userId) {
		//custom exception
		return _userService.FindUserById(userId);
	}
	
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId,@RequestBody User updateUser) {
         return  _userService.UpdateUser(userId,updateUser);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		_userService.DeleteUserById(userId);
	}
	

}
