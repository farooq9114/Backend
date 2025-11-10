package com.perfume.PerfumeCollection.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfume.PerfumeCollection.Model.User;
import com.perfume.PerfumeCollection.Repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public String addNewUser(User user) {
		userRepo.save(user);
		return "user added successfully from service laye";
	}
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	 public Optional<User> findByEmail(String email) {
	        return userRepo.findByEmail(email);
	    }

	 public boolean emailExists(String email) {
	        return userRepo.findByEmail(email).isPresent();
	 }

}
