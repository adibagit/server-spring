package com.springboot.SolutionNinjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SolutionNinjas.model.User;
import com.springboot.SolutionNinjas.repository.UserRepository;

@Service
public class UserService{

	@Autowired
	private UserRepository userRepo;

	public List<User> getUsers() {
		return userRepo.findAll();
	}

	public User insertUser(User user) {
		return userRepo.save(user);
	}

	public User getOneUser(int userId) {
		Optional<User> u = userRepo.findById(userId);
		if(u.isPresent())
			return u.get();
		System.out.println("User not found for id: "+userId);
		return null;
	}

	public void deleteUser(int userId) {
		userRepo.deleteById(userId);
	}
	
	public User updateUser(User user) {
		return userRepo.save(user);
	}

}
