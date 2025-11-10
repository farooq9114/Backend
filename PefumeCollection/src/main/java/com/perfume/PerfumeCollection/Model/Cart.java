package com.perfume.PerfumeCollection.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartid;

    private int uid;
    private int pid;
    private String name;
    private String description;
    private String gender;
    private double price;
    private String imageurl;
    private int quantity;
    
    public Cart() {}
    
    public Cart(int uid, int pid, String name, String description, String gender, double price, String imageurl, int quantity) {
		super();
		this.uid = uid;
		this.pid = pid;
		this.name = name;
		this.description = description;
		this.gender = gender; 
		this.price = price;
		this.imageurl = imageurl;
		this.quantity = quantity;
	}
    
	// Getters and Setters
    public int getCartId() { return cartid; }
    public void setCartId(int cartId) { this.cartid = cartId; }

    public int getuId() { return uid; }
    public void setuId(int uId) { this.uid = uId; }

    public int getpId() { return pid; }
    public void setpId(int pId) { this.pid = pId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getImageUrl() { return imageurl; }
    public void setImageUrl(String imageUrl) { this.imageurl = imageUrl; }

	public int getQuantity() { return quantity; }
	public void setQuantity(int quantity) { this.quantity = quantity; }
    
    
}
