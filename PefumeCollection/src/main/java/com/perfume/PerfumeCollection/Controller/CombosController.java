package com.perfume.PerfumeCollection.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.perfume.PerfumeCollection.Model.Combos;
import com.perfume.PerfumeCollection.Service.ComboService;

@RestController
@RequestMapping("/combos")
@CrossOrigin(origins = "*")
public class CombosController {

	@Autowired
	private ComboService comboService;
	
	@GetMapping("/getAllCombos")
	public List<Combos> getAllCombos(){
		return comboService.getAllCombos();
	}
	
	@GetMapping("/getComboByGender/{gender}")
	public List<Combos> getDataByGender(@PathVariable String gender){
		return comboService.getDataByGender(gender);
	}
	
	@GetMapping("/perfume/{name}")
	public List<Combos> getByPerfumeName(@PathVariable String name){
		return comboService.getByPerfumeName(name);
	}
	
	@GetMapping("/getperfumename/")
	public List<Combos> getPerfumeName(@RequestParam String name){
		return comboService.getPerfumeName(name);
	}
	
}
