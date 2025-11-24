package com.perfume.PerfumeCollection.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfume.PerfumeCollection.Model.Combos;
import com.perfume.PerfumeCollection.Repository.CombosRepo;

@Service
public class ComboService {
	
	@Autowired
	private CombosRepo combosRepo;
	
	public List<Combos> getAllCombos(){
		return combosRepo.findAll();
	}
	
	//fetching data by gender
	public List<Combos> getDataByGender(String gender) {
		return combosRepo.findByGenderIgnoreCase(gender);
	}
		
	//fetch data by perfume name
	public List<Combos> getByPerfumeName(String name){
		return combosRepo.findByNameContainingIgnoreCase(name);
	}
		
	//fetch perfume's name
	public List<Combos> getPerfumeName(String name){
		return combosRepo.findByNameContainingIgnoreCase(name);
	}
	
}
