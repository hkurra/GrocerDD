package util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.adroit.easygrocer.Category;
import com.adroit.easygrocer.Product;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;


public class productUtility {

	public static Entity productToEntity(Product product) {
		
		Entity entity = new Entity(ServiceConstant.PRODUCT_ENTITY, product.getId());
		try {

			entity.setProperty(ServiceConstant.P_NAME, product.getName());
			entity.setProperty(ServiceConstant.P_IMAGE_URL, product.getImage());
			entity.setProperty(ServiceConstant.P_BRAND, product.getBrand());
			entity.setProperty(ServiceConstant.P_CATEGORY, product.getCategory());

			entity.setProperty(ServiceConstant.P_DESCRIPTION, product.getDescription());
			entity.setProperty(ServiceConstant.ORIGINAL_PRICE, product.getOriginalPrice());
			entity.setProperty(ServiceConstant.DISCOUNT_PRICE, product.getDiscountPrice());
			entity.setProperty(ServiceConstant.IS_VEG, product.isVeg());
			entity.setProperty(ServiceConstant.PRODUCT_WEIGHT, product.getProducWeight());
			entity.setProperty(ServiceConstant.DISCOUNT_PERCENTAGE, product.getDiscountPercentage());
			entity.setProperty(ServiceConstant.SUB_CATEGORY_ID, product.getSubCategoryId());
			entity.setProperty(ServiceConstant.NUTRITIONAL_VALUE, product.getNutritionalValue());
			entity.setProperty(ServiceConstant.P_SOLD_NUMBER, product.getProductSoldNo());
			
		} catch (Exception e) {
			//TODO mail this problem

		}
		return entity;
	}
	
	
	public static Product entityToProduct(Entity entity) {
		
		String articleID = entity.getKey().getName();
		Product product = new Product();
		product.setName(entity.getProperty(ServiceConstant.P_NAME).toString());
		product.setImage(entity.getProperty(ServiceConstant.P_IMAGE_URL).toString());
		product.setBrand(entity.getProperty(ServiceConstant.P_BRAND).toString());
		product.setCategory(entity.getProperty(ServiceConstant.P_CATEGORY).toString());

		product.setDescription(entity.getProperty(ServiceConstant.P_DESCRIPTION).toString());
		product.setOriginalPrice((long) entity.getProperty(ServiceConstant.ORIGINAL_PRICE));
		product.setDiscountPrice((long)entity.getProperty(ServiceConstant.DISCOUNT_PRICE));
		product.setVeg((boolean)entity.getProperty(ServiceConstant.IS_VEG));
		product.setProducWeight((long)entity.getProperty(ServiceConstant.PRODUCT_WEIGHT));
		product.setDiscountPercentage((long)entity.getProperty(ServiceConstant.DISCOUNT_PERCENTAGE));
		product.setSubCategoryId((long)entity.getProperty(ServiceConstant.SUB_CATEGORY_ID));
		product.setNutritionalValue(entity.getProperty(ServiceConstant.NUTRITIONAL_VALUE).toString());
		product.setProductSoldNo((long)entity.getProperty(ServiceConstant.P_SOLD_NUMBER));
		
		return product;
	}
	public static Entity categoryToEntity(Category product) {
		
		Entity entity = new Entity(ServiceConstant.CATEGORY_ENTITY, product.getId());
		try {

			entity.setProperty(ServiceConstant.CATEGORY_NAME, product.getName());
			entity.setProperty(ServiceConstant.CATEGORY_ID, product.getId());
			entity.setProperty(ServiceConstant.C_IMAGE_URL, product.getImageURL());
		}
		
		catch (Exception e) {
			
		}
		return entity;
	}
	public static Category entityToCategory(Entity entity) {
		
		String articleID = entity.getKey().getName();
		Category product = new Category();
		product.setName(entity.getProperty(ServiceConstant.CATEGORY_NAME).toString());
		product.setId(entity.getProperty(ServiceConstant.CATEGORY_ID).toString());
		product.setImageURL(entity.getProperty(ServiceConstant.C_IMAGE_URL).toString());

		return product;
	}
	
	public static List<Entity> productsToEntities(List<Product> products) {

		List<Entity> entityList = new ArrayList<Entity>();

		for(Product edArticle : products) {
			Entity entity = productToEntity(edArticle);
			entityList.add(entity);
		}

		return entityList;
	}
	
	public static List<Product> entitiesToProducts(List<Entity> entities) {

		
		List<Product> articleList = new ArrayList<Product>();

		for(Entity edArticle : entities) {
			articleList.add(entityToProduct(edArticle));
		}

		return articleList;
	}
	
	public static List<Entity> CategoriesToEntities(List<Category> products) {

		List<Entity> entityList = new ArrayList<Entity>();

		for(Category edArticle : products) {
			Entity entity = categoryToEntity(edArticle);
			entityList.add(entity);
		}

		return entityList;
	}
	
	public static List<Category> entitiesToCategory(List<Entity> entities) {

		List<Category> articleList = new ArrayList<Category>();

		for(Entity edArticle : entities) {
			articleList.add(entityToCategory(edArticle));
		}

		return articleList;
	}
}
