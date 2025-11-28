package com.perfume.PerfumeCollection.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfume.PerfumeCollection.Model.Perfume;
import com.perfume.PerfumeCollection.Repository.PerfumeRepo;

@Service
public class PerfumeService {

	@Autowired
	private PerfumeRepo perfumeRepo;
	
	//adding new perfume data to database
	public String addData(List<Perfume> perfumeObj) {
		perfumeRepo.saveAll(perfumeObj);
		return "data added from service layer";
	}
	
    //fetching data by gender
	public List<Perfume> getDataByGender(String gender) {
		return perfumeRepo.findByGenderIgnoreCase(gender);
	}
	
	//fetch data by perfume name
	public List<Perfume> getByPerfumeName(String pName){
		return perfumeRepo.findByNameContainingIgnoreCase(pName);
	}
	
	//fetch perfume's name
	public List<Perfume> getPerfumeName(String name){
		return perfumeRepo.findByNameContainingIgnoreCase(name);
	}

}
