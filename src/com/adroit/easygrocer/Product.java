package com.adroit.easygrocer;

import javax.persistence.Entity;

@Entity
public class Product {

	private String id;
	
	private String name;
	
	private String image;
	
	
	private String brand;
	
	private String category;
	
	private String description;
	
	private int originalPrice;
	
	private int discountPrice;
	
	private boolean isVeg;
	
	private int producWeight;
	
	private int discountPercentage;
	
	private int subCategoryId;
	
	private String nutritionalValue;
	
	private int productSoldNo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(int originalPrice) {
		this.originalPrice = originalPrice;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	public boolean isVeg() {
		return isVeg;
	}

	public void setVeg(boolean isVeg) {
		this.isVeg = isVeg;
	}

	public int getProducWeight() {
		return producWeight;
	}

	public void setProducWeight(int producWeight) {
		this.producWeight = producWeight;
	}

	public int getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getNutritionalValue() {
		return nutritionalValue;
	}

	public void setNutritionalValue(String nutritionalValue) {
		this.nutritionalValue = nutritionalValue;
	}

	public int getProductSoldNo() {
		return productSoldNo;
	}

	public void setProductSoldNo(int productSoldNo) {
		this.productSoldNo = productSoldNo;
	}
	
}
