package com.perfume.PerfumeCollection.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfume.PerfumeCollection.Model.Perfume;

@Repository
public interface PerfumeRepo extends JpaRepository<Perfume, Integer>{

	List<Perfume> findByGenderIgnoreCase(String gender);
	
	List<Perfume> findByNameContainingIgnoreCase(String name);
		
}
