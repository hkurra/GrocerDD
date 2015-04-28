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
	
	private List<Category> subCategory;
	
	private String parentId ;
	
	public Category() {
		category_id = Product.undefinedConst;
		category_name = Product.undefinedConst;
		category_image = Product.undefinedConst;
		subCategory = new ArrayList<Category>();
		setParentCategoryID(Product.undefinedConst);
	}

	public String getId() {
		return category_id;
	}

	public void setId(String id) {
		category_id = id;
	}

	public String getName() {
		return category_name;
	}

	public void setName(String name) {
		this.category_name = name;
	}

	public String getImageURL() {
		return category_image;
	}

	public void setImageURL(String imageURL) {
		this.category_image = imageURL;
	}
	
	/**
	 * @return the subCategory
	 */
	public List<Category>  getSubCategory() {
		return subCategory;
	}

	/**
	 * @param subCategory the subCategory to set
	 */
	public void setSubCategory(List<Category>  subCategory) {
		this.subCategory = subCategory;
	}

	public String getParentCategoryID() {
		return parentId;
	}

	public void setParentCategoryID(String subCategoryID) {
		this.parentId = subCategoryID;
	}

	@Entity
	public class subCategory extends Category {
		
		private int subCategoryId;

		public int getSubCategoryId() {
			return subCategoryId;
		}

		public void setSubCategoryId(int subCategoryId) {
			this.subCategoryId = subCategoryId;
		}
	}
}
