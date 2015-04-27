package com.adroit.easygrocer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import util.productUtility;

import com.google.appengine.api.appidentity.AppIdentityServicePb.PublicCertificate;

@Entity
public class Category {

	private String Id;
	
	private String name;
	
	private String imageURL;
	
	private List<Category> subCategory;
	
	private String parentId ;
	
	public Category() {
		Id = Product.undefinedConst;
		name = Product.undefinedConst;
		imageURL = Product.undefinedConst;
		subCategory = new ArrayList<Category>();
		setParentCategoryID(Product.undefinedConst);
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
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
