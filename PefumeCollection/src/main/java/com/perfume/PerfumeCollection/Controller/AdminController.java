package com.perfume.PerfumeCollection.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfume.PerfumeCollection.Model.Perfume;
import com.perfume.PerfumeCollection.Model.User;
import com.perfume.PerfumeCollection.Service.PerfumeService;
import com.perfume.PerfumeCollection.Service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private PerfumeService perfumeService;
	
	@Autowired
	private UserService userService;;
	
	@PostMapping("/addData")
	public String addData(@RequestBody List<Perfume> perfume) {
		perfumeService.addData(perfume);
		return "data added successfully";
	}
	
	@GetMapping("/get-all-users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
}
