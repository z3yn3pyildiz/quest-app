package com.example.questApp.controllers;

import java.util.List;
import java.util.Optional;

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


@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserRepository _userRepository;
	public UserController(UserRepository userRepository) {
		this._userRepository=userRepository;
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return _userRepository.findAll();
	}
	
	@PostMapping
	public User createUser(@RequestBody User newUser) {
		return _userRepository.save(newUser);
	}
	
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable Long userId) {
		//custom exception
		return _userRepository.findById(userId).orElse(null);
	}
	
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId,@RequestBody User updateUser) {
		Optional<User> user= _userRepository.findById(userId);
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(updateUser.getUserName());
			foundUser.setPassWord((updateUser.getPassWord()));
			_userRepository.save(foundUser);
			return foundUser;
		}else {
			return null;
		}
	}
	
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		_userRepository.deleteById(userId);
	}
	

}
