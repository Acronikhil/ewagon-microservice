package com.ewagon.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ewagon.userservice.entity.Users;
import com.ewagon.userservice.exception.UserNotFoundByEmailException;
import com.ewagon.userservice.service.UserService;
import com.ewagon.userservice.to.UserTo;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/default")
	public String defaultMethod() {
		return "hello from user controller";
	}

//	create
	@PostMapping("/")
	public ResponseEntity<UserTo> createUser(@RequestBody UserTo userTo) {
		userService.createUser(userTo);
		return new ResponseEntity<UserTo>(userTo, HttpStatus.CREATED);
	}

//	read
	@GetMapping("/")
	public List<Users> getAllUsers() {
		return userService.getAllUser();
	}

	@GetMapping("/email/")
	public Users getUserByEmail(@RequestParam(value = "email") String email) throws UserNotFoundByEmailException {
		return userService.getUserByEmail(email);
	}

//	update
	@PutMapping("/")
	public ResponseEntity<UserTo> updateUser(@RequestParam(value = "email") String email, @RequestBody UserTo userTo)
			throws UserNotFoundByEmailException {
		userService.updateUser(email, userTo);
		return new ResponseEntity<UserTo>(userTo, HttpStatus.OK);
	}

//	delete
	@DeleteMapping("/")
	public String deleteUserByEmail(@RequestParam(value = "email") String email) throws UserNotFoundByEmailException {
		return userService.deleteUser(email);
	}
}
