package com.perfume.PerfumeCollection.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfume.PerfumeCollection.Model.User;
import com.perfume.PerfumeCollection.Service.UserService;

@CrossOrigin(origins = "http://192.168.1.31:4200")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/new-user")
	public ResponseEntity<String> addNewUser(@RequestBody User user) {

	    Optional<User> existingUser = userService.findByEmail(user.getEmail());

	    if(existingUser.isPresent()) {
	        // Email already exists
	        return ResponseEntity.status(HttpStatus.CONFLICT)
	                .body("Email already exists");
	    }

	    // Email does not exist, save new user
	    userService.addNewUser(user);
	    return ResponseEntity.ok("User added successfully");
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) {
	    Optional<User> userOpt = userService.findByEmail(user.getEmail());

	    if (userOpt.isEmpty() || 
	        !userOpt.get().getPassword().equals(user.getPassword())) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                .body("Invalid email or password");
	    }

	    User loggedInUser = userOpt.get();
	    Map<String, Object> response = new HashMap<>();
	    response.put("message", "Login successful");
	    response.put("userId", loggedInUser.getUid());
	    response.put("name", loggedInUser.getName());
	    response.put("email", loggedInUser.getEmail());

	    return ResponseEntity.ok(response);
	}

}
