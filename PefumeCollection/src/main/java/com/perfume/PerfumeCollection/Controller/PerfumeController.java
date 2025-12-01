package com.perfume.PerfumeCollection.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.perfume.PerfumeCollection.Model.Perfume;
import com.perfume.PerfumeCollection.Repository.PerfumeRepo;
import com.perfume.PerfumeCollection.Service.PerfumeService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/perfume")
public class PerfumeController {

	@Autowired
	private PerfumeRepo perfumeRepo;
	
	@Autowired
	private PerfumeService perfumeService;
	
	@GetMapping("/getAll")
	public List<Perfume> getAll() {
		return perfumeRepo.findAll();
	}
	
	@GetMapping("/getByGender/{gender}")
	public List<Perfume> getDataByGender(@PathVariable String gender){
		return perfumeService.getDataByGender(gender);
	}
	
	@GetMapping("/perfume/{pName}")
	public List<Perfume> getByPerfumeName(@PathVariable String pName){
		return perfumeService.getByPerfumeName(pName);
	}
	
	@GetMapping("/getperfumename/")
	public List<Perfume> getPerfumeName(@RequestParam String name){
		return perfumeService.getPerfumeName(name);
	}


}
