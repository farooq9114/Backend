package com.perfume.PerfumeCollection.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfume.PerfumeCollection.Model.Combos;

@Repository
public interface CombosRepo extends JpaRepository<Combos, Integer> {
	
	List<Combos> findByGenderIgnoreCase(String gender);
	
	List<Combos> findByNameContainingIgnoreCase(String name);
}
