package com.adroit.easygrocer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class HomeScreen {

	private List<Product> top_products = new ArrayList<Product>();
	private List<Product> discount_products = new ArrayList<Product>();
	private List<Category> categories = new ArrayList<Category>();
	private List<Product> banner_products = new ArrayList<Product>();
	
	public List<Product> getTopProducts() {
		return top_products;
	}
	public void setTop_products(List<Product> topProducts) {
		this.top_products = topProducts;
	}
	public List<Product> getDiscount_products() {
		return discount_products;
	}
	public void setDiscount_products(List<Product> discountProducts) {
		this.discount_products = discountProducts;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	private List<Product> getBanner_products() {
		return banner_products;
	}
	private void setBanner_products(List<Product> bannerProducts) {
		this.banner_products = bannerProducts;
	}
	

	
}
