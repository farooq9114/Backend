package com.perfume.PerfumeCollection.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Combos {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int cid;
	 
	 private String name;
	 private String description;
	 private String gender;
	 private double price;
	 private String imageurl;
	
	 public Combos() {}
	 
	public Combos(String name, String description, String gender, double price, String imageurl) {
		super();
		this.name = name;
		this.description = description;
		this.gender = gender;
		this.price = price;
		this.imageurl = imageurl;
	}
	
	public int getId() {
		return cid;
	}
	public void setId(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	 
	 
	 
}
