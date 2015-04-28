package com.adroit.easygrocer;

import javax.persistence.Entity;

import util.ServiceConstant;

@Entity
public class Product {


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
		is_veg = false;
		setProducWeight(-1);
		setDiscountPercentage(-1);
		setSubCategoryId(undefinedConst);
		setNutritionalValue(undefinedConst);
		setProductSoldNo(-1);
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

	public String getId() {
		return product_id;
	}

	public void setId(String id) {
		this.product_id = id;
	}

	public String getName() {
		return product_name;
	}

	public void setName(String name) {
		this.product_name = name;
	}

	public String getImage() {
		return product_image;
	}

	public void setImage(String image) {
		this.product_image = image;
	}

	public String getBrand() {
		return product_brand;
	}

	public void setBrand(String brand) {
		this.product_brand = brand;
	}

	public String getCategory() {
		return product_category;
	}

	public void setCategory(String category) {
		this.product_category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getOriginalPrice() {
		return original_price;
	}

	public void setOriginalPrice(long originalPrice) {
		this.original_price = originalPrice;
	}

	public long getDiscountPrice() {
		return discounted_price;
	}

	public void setDiscountPrice(long discountPrice) {
		this.discounted_price = discountPrice;
	}

	public boolean isVeg() {
		return is_veg;
	}

	public void setVeg(boolean isVeg) {
		this.is_veg = isVeg;
	}

	public long getProducWeight() {
		return product_weight;
	}

	public void setProducWeight(long producWeight) {
		this.product_weight = producWeight;
	}

	public long getDiscountPercentage() {
		return discount_percentage;
	}

	public void setDiscountPercentage(long discountPercentage) {
		this.discount_percentage = discountPercentage;
	}

	public String getSubCategoryId() {
		return product_subcategory;
	}

	public void setSubCategoryId(String subCategoryId) {
		this.product_subcategory = subCategoryId;
	}

	public String getNutritionalValue() {
		return nutritional_value;
	}

	public void setNutritionalValue(String nutritionalValue) {
		this.nutritional_value = nutritionalValue;
	}

	public long getProductSoldNo() {
		return product_sold_number;
	}

	public void setProductSoldNo(long productSoldNo) {
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

	public boolean is_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	
}
