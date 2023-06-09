package com.springboot.SolutionNinjas.service;

import java.util.List;
import java.util.Optional;

import com.springboot.SolutionNinjas.exception.ResourceNotFoundException;
import com.springboot.SolutionNinjas.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SolutionNinjas.model.User;
import com.springboot.SolutionNinjas.repository.UserRepository;

@Service
public class UserService{

	@Autowired
	private UserRepository userRepo;

	public List<User> getUsers() {
		try {
			return userRepo.findAll();
		} catch (Exception e) {
			throw new UserNotFoundException("Unable to retrieve users: " + e.getMessage(), e);
		}

	}

	public User insertUser(User user) {
		return userRepo.save(user);
	}

	public User getOneUser(int userId) {
		Optional<User> u = Optional.ofNullable(userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId)));
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

	public String getRole(String email){ return userRepo.getUserRole(email); }

	public Boolean userExist(String email){ return  userRepo.userExist(email);}

	public List<User> getUsersByEmailId(String emailid) {
		try {
			return userRepo.findAllByEmailid(emailid);
		} catch (Exception e) {
			throw new UserNotFoundException("No user found for this email ID" + e.getMessage(), e);
		}
	}

	public List<User> getUsersByRole(String role) {
		try {
			return userRepo.findAllByUsertype(role);
		} catch (Exception e) {
			throw new UserNotFoundException("No user found for this email ID" + e.getMessage(), e);
		}
	}
}
