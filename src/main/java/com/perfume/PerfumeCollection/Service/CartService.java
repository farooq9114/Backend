package com.perfume.PerfumeCollection.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfume.PerfumeCollection.Model.Cart;
import com.perfume.PerfumeCollection.Repository.CartRepo;

@Service
public class CartService {
	
	@Autowired
    private CartRepo cartRepo;

    public Cart addToCart(Cart cart) {
        return cartRepo.save(cart);
    }
    
    public List<Cart> getProductsByUserId(int id){
    	return cartRepo.findByUid(id);
    }
    
    public Optional<Cart> deletePerfumeByCartId(int cartId) {
    	cartRepo.deleteById(cartId);
		return null;
    }
    
    // ✅ Update quantity manually
    public Cart updateCartItem(int cartId, Cart updatedItem) {
        Cart existing = cartRepo.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        existing.setQuantity(updatedItem.getQuantity());
        return cartRepo.save(existing);
    }
    
}

