package com.perfume.PerfumeCollection.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfume.PerfumeCollection.Model.Cart;
import com.perfume.PerfumeCollection.Repository.CartRepo;
import com.perfume.PerfumeCollection.Service.CartService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartRepo cartRepo;

	 @PostMapping("/addToCart")
	    public ResponseEntity<Map<String, String>> addToCart(@RequestBody Cart cart) {
	        cartService.addToCart(cart);

	        Map<String, String> response = new HashMap<>();
	        response.put("message", "Item added to cart successfully!");

	        return ResponseEntity.ok(response);
	  }
	 
	 @GetMapping("/getProdsByUserid/{id}")
	 	public List<Cart> getProductsByUserId(@PathVariable int id){
		 	return cartService.getProductsByUserId(id);
	 	}
	 
	 // ✅ Update quantity manually
	 @PutMapping("/{cartId}")
	    public ResponseEntity<Cart> updateCartItem(@PathVariable int cartId, @RequestBody Cart cart) {
	        Cart updated = cartService.updateCartItem(cartId, cart);
	        return ResponseEntity.ok(updated);
	    }
	 
	 @DeleteMapping("/deletePerfumeByCartid/{id}")
	 public ResponseEntity<Map<String, String>> deletePerfumeByCartId(@PathVariable int id) {
	     cartService.deletePerfumeByCartId(id);
	     Map<String, String> response = new HashMap<>();
	     response.put("message", "Item deleted successfully!");
	     return ResponseEntity.ok(response);
	 }
	 
	 @DeleteMapping("/clear/{uid}")
	   public ResponseEntity<String> clearCart(@PathVariable  int uid){
		 List<Cart> items = cartRepo.findByUid(uid);
	 	   cartRepo.deleteAll(items);
		   return ResponseEntity.ok("Cart cleared successfully");
	   }	 
}
