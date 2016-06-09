package com.adroit.easygrocer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import util.productUtility;

import com.google.appengine.api.appidentity.AppIdentityServicePb.PublicCertificate;

@Entity
public class Category {

	private String category_id;

	private String category_name;

	private String category_image;
	
	private List<Category> sub_Category;
	
	private String parentId ;
	
	public Category() {
		category_id = Product.undefinedConst;
		category_name = Product.undefinedConst;
		category_image = Product.undefinedConst;
		sub_Category = new ArrayList<Category>();
		parentId = (Product.undefinedConst);
	}
	
	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	
	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	public String getCategory_image() {
		return category_image;
	}

	public void setCategory_image(String category_image) {
		this.category_image = category_image;
	}

	public List<Category> getSub_Category() {
		return sub_Category;
	}

	public void setSub_Category(List<Category> subCategory) {
		this.sub_Category = subCategory;
	}

	public String getParent_Id() {
		return parentId;
	}

	public void setParent_Id(String parentId) {
		this.parentId = parentId;
	}
}
