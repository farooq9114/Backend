package com.perfume.PerfumeCollection.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Perfume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String description;
	private String gender;
	private double price;
	private String imageurl;
	private boolean latestlaunch;
	
	public Perfume() {};
	
	public Perfume(String name, String description, String gender, double price, String imageurl,
			boolean latestlaunch) {
		super();
		this.name = name;
		this.description = description;
		this.gender = gender;
		this.price = price;
		this.imageurl = imageurl;
		this.latestlaunch = latestlaunch;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getImageUrl() {
		return imageurl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageurl = imageUrl;
	}
	public boolean isLatestLaunch() {
		return latestlaunch;
	}
	public void setLatestLaunch(boolean latestLaunch) {
		this.latestlaunch = latestLaunch;
	}

	@Override
	public String toString() {
		return "Perfume [id=" + id + ", name=" + name + ", description=" + description + ", gender=" + gender
				+ ", price=" + price + ", imageurl=" + imageurl + ", latestlaunch=" + latestlaunch + "]";
	}

}
