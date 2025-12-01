package com.perfume.PerfumeCollection.Controller;

import java.util.HashMap;
import java.util.Map;

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

@CrossOrigin(origins = "")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/new-user")
	public ResponseEntity<Map<String, String>> addNewUser(@RequestBody User user) {

	    User existingUser = userService.findByEmail(user.getEmail().toLowerCase());

	    if (existingUser!= null) {
	        return ResponseEntity.status(HttpStatus.CONFLICT)
	                .body(Map.of("message", "Email already exists"));
	    }

	    // Email does not exist, save new user
	    userService.addNewUser(user);
	    return ResponseEntity.ok(Map.of("message", "User added successfully"));
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) {
	    User existingUser = userService.getUser(user.getEmail(), user.getPassword());

	    if (existingUser != null) {
	        // Create a structured JSON response
	        Map<String, Object> response = new HashMap<>();
	        response.put("userId", existingUser.getUid());
	        response.put("name", existingUser.getName());
	        response.put("email", existingUser.getEmail());
	        response.put("message", "Login successful!");

	        return ResponseEntity.ok(response);
	    } else {
	        // Return error message with status 401 (Unauthorized)
	        Map<String, String> error = new HashMap<>();
	        error.put("error", "Invalid email or password!");
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
	    }
	}

}

