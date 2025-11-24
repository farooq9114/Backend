package com.perfume.PerfumeCollection.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfume.PerfumeCollection.Model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>  {

	List<Cart> findByUid(int id);
	
}
