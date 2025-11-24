package com.perfume.PerfumeCollection.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.perfume.PerfumeCollection.Model.User;
import com.perfume.PerfumeCollection.Repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	public String addNewUser(User user) {
		String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepo.save(user);
		return "user added successfully from service laye";
	}
	
	public User getUser(String email, String rawPassword) {
        User user = userRepo.findByEmail(email);
        if (user != null && passwordEncoder.matches(rawPassword, user.getPassword())) {
            return user;
        }
        return null;
    }
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	 public User findByEmail(String email) {
	    return userRepo.findByEmail(email);
	 }

	 public boolean emailExists(String email) {
	    return userRepo.findByEmail(email)!= null;
	 }

}
