package com.adroit.easygrocer;

import javax.persistence.Entity;

@Entity
public class Product {

	enum Type {
		discounted,
		populer
	}
	public static String undefinedConst = "undefined"; 
	public Product() {
		setId(undefinedConst);
		setName(undefinedConst);
		setImage(undefinedConst);
		setBrand(undefinedConst);
		setCategory(undefinedConst);
		setDescription(undefinedConst);
		setOriginalPrice(-1);
		setDiscountPrice(-1);
		isVeg = false;
		setProducWeight(-1);
		setDiscountPercentage(-1);
		setSubCategoryId(-1);
		setNutritionalValue(undefinedConst);
		setProductSoldNo(-1);
		setType(Type.discounted);
	}
	
	private String id;
	
	private String name;
	
	private String image;
	
	
	private String brand;
	
	private String category;
	
	private String description;
	
	private long originalPrice;
	
	private long discountPrice;
	
	private boolean isVeg;
	
	private long producWeight;
	
	private long discountPercentage;
	
	private long subCategoryId;
	
	private String nutritionalValue;
	
	private long productSoldNo;
	
	private Type type; 

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

	public long getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(long originalPrice) {
		this.originalPrice = originalPrice;
	}

	public long getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(long discountPrice) {
		this.discountPrice = discountPrice;
	}

	public boolean isVeg() {
		return isVeg;
	}

	public void setVeg(boolean isVeg) {
		this.isVeg = isVeg;
	}

	public long getProducWeight() {
		return producWeight;
	}

	public void setProducWeight(long producWeight) {
		this.producWeight = producWeight;
	}

	public long getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(long discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public long getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getNutritionalValue() {
		return nutritionalValue;
	}

	public void setNutritionalValue(String nutritionalValue) {
		this.nutritionalValue = nutritionalValue;
	}

	public long getProductSoldNo() {
		return productSoldNo;
	}

	public void setProductSoldNo(long productSoldNo) {
		this.productSoldNo = productSoldNo;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}
	
}
