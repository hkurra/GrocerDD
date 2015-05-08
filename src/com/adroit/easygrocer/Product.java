package com.adroit.easygrocer;

import javax.persistence.Entity;

import util.ServiceConstant;

@Entity
public class Product {


	public static String undefinedConst = "undefined"; 
	public Product() {
		setProduct_id(undefinedConst);
		setProduct_name(undefinedConst);
		setProduct_image(undefinedConst);
		setProduct_brand(undefinedConst);
		setProduct_category(undefinedConst);
		setDescription(undefinedConst);
		setOriginal_price(-1);
		setDiscounted_price(-1);
		is_veg = false;
		setProduct_weight(-1);
		setDiscount_percentage(-1);
		setSubCategoryId(undefinedConst);
		setNutritional_value(undefinedConst);
		setProduct_sold_number(-1);
		setType(ServiceConstant.Type.discounted);
		setIs_deleted(false);
	}
	
	private String product_id;
	
	private String product_name;
	
	private String product_image;
	
	
	private String product_brand;
	
	private String product_category;
	
	private String description;
	
	private long original_price;
	
	private long discounted_price;
	
	private boolean is_veg;
	
	private boolean is_deleted;
	
	private long product_weight;
	
	private long discount_percentage;
	
	private String product_subcategory;
	
	private String nutritional_value;
	
	private long product_sold_number;
	
	private ServiceConstant.Type  type; 

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String id) {
		this.product_id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String name) {
		this.product_name = name;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String image) {
		this.product_image = image;
	}

	public String getProduct_brand() {
		return product_brand;
	}

	public void setProduct_brand(String brand) {
		this.product_brand = brand;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String category) {
		this.product_category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getOriginal_price() {
		return original_price;
	}

	public void setOriginal_price(long originalPrice) {
		this.original_price = originalPrice;
	}

	public long getDiscounted_price() {
		return discounted_price;
	}

	public void setDiscounted_price(long discountPrice) {
		this.discounted_price = discountPrice;
	}

	public boolean getIs_veg() {
		return is_veg;
	}

	public void setIs_veg(boolean isVeg) {
		this.is_veg = isVeg;
	}

	public long getProduct_weightt() {
		return product_weight;
	}

	public void setProduct_weight(long producWeight) {
		this.product_weight = producWeight;
	}

	public long getDiscount_percentage() {
		return discount_percentage;
	}

	public void setDiscount_percentage(long discountPercentage) {
		this.discount_percentage = discountPercentage;
	}

	public String getProduct_subcategory() {
		return product_subcategory;
	}

	public void setSubCategoryId(String subCategoryId) {
		this.product_subcategory = subCategoryId;
	}

	public String getNutritional_value() {
		return nutritional_value;
	}

	public void setNutritional_value(String nutritionalValue) {
		this.nutritional_value = nutritionalValue;
	}

	public long getProduct_sold_number() {
		return product_sold_number;
	}

	public void setProduct_sold_number(long productSoldNo) {
		this.product_sold_number = productSoldNo;
	}

	/**
	 * @return the type
	 */
	public ServiceConstant.Type getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(ServiceConstant.Type  type) {
		this.type = type;
	}

	public boolean getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	
}
