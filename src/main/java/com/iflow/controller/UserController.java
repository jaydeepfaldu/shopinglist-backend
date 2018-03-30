package com.iflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iflow.model.Users;
import com.iflow.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("users")
	public ResponseEntity<List<Users>> getUserAll() {
		List<Users> ul = userRepository.findAll();
		return new ResponseEntity<List<Users>>(ul, HttpStatus.OK);
	}

	@PostMapping("login")
	public ResponseEntity<Users> getLogin(@RequestBody Users user) {
		Users u = userRepository.findUserByAuth(user.getUsername(), user.getPassword());		
		return new ResponseEntity<Users>(u, HttpStatus.OK);
	}
	
}
