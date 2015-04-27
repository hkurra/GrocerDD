package com.adroit.easygrocer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class HomeScreen {

	private List<Product> topProducts = new ArrayList<Product>();
	private List<Product> discountProducts = new ArrayList<Product>();
	private List<Category> categories = new ArrayList<Category>();
	private List<Product> bannerProducts = new ArrayList<Product>();
	
	public List<Product> getTopProducts() {
		return topProducts;
	}
	public void setTopProducts(List<Product> topProducts) {
		this.topProducts = topProducts;
	}
	public List<Product> getDiscountProducts() {
		return discountProducts;
	}
	public void setDiscountProducts(List<Product> discountProducts) {
		this.discountProducts = discountProducts;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	private List<Product> getBannerProducts() {
		return bannerProducts;
	}
	private void setBannerProducts(List<Product> bannerProducts) {
		this.bannerProducts = bannerProducts;
	}
	

	
}
