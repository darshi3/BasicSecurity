package com.example.AsyncAPI.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AsyncAPI.Entity.UserEntity;
import com.example.AsyncAPI.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	@GetMapping("/info")
	public String info() {
		return "Hello friends";
	}

	@PostMapping("/add")
	ResponseEntity<?> addUser(@RequestBody UserEntity user) {
		return ResponseEntity.ok(userService.saveUser(user));
	}
	
	@GetMapping("/all")
	List<UserEntity> allUsers() {
		return userService.listAllUsers();
	}

	@GetMapping("/userid/{id}")
	ResponseEntity<?> getuserById(@PathVariable int id) {
			return ResponseEntity.status(200).body(userService.userById(id));
	}
}
