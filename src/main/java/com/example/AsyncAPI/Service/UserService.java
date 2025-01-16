package com.example.AsyncAPI.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AsyncAPI.Entity.UserEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

	private final UsersRepository userRepository;
	

	// save
	public UserEntity saveUser(UserEntity user) {
		if (userRepository.existsById(user.getId())) {
			throw new RuntimeException("User Record already Exist");
		} else {
			return userRepository.save(user);
		}
	}

	// all users
	public List<UserEntity> listAllUsers() {
		return userRepository.findAll();
	}

	// user by id
	public UserEntity userById(int id) {
		UserEntity user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User ID not found"));
		return user;
	}
}
