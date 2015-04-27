package com.adroit.easygrocer;

import javax.persistence.Entity;

import util.productUtility;

import com.google.appengine.api.appidentity.AppIdentityServicePb.PublicCertificate;

@Entity
public class Category {

	private String Id;
	
	private String name;
	
	private String imageURL;
	
	public Category() {
		Id = Product.undefinedConst;
		name = Product.undefinedConst;
		imageURL = Product.undefinedConst;
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
