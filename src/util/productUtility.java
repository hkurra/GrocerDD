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
		
		Entity entity = new Entity(ServiceConstant.PRODUCT_ENTITY, product.getProduct_id());
		try {

			entity.setProperty(ServiceConstant.P_NAME, product.getProduct_name());
			entity.setProperty(ServiceConstant.P_IMAGE_URL, product.getProduct_image());
			entity.setProperty(ServiceConstant.P_BRAND, product.getProduct_brand());
			entity.setProperty(ServiceConstant.P_CATEGORY, product.getProduct_category());

			entity.setProperty(ServiceConstant.P_DESCRIPTION, product.getDescription());
			entity.setProperty(ServiceConstant.ORIGINAL_PRICE, product.getOriginal_price());
			entity.setProperty(ServiceConstant.DISCOUNT_PRICE, product.getDiscounted_price());
			entity.setProperty(ServiceConstant.IS_VEG, product.getIs_veg());
			entity.setProperty(ServiceConstant.PRODUCT_WEIGHT, product.getProduct_weightt());
			entity.setProperty(ServiceConstant.DISCOUNT_PERCENTAGE, product.getDiscount_percentage());
			entity.setProperty(ServiceConstant.SUB_CATEGORY_ID, product.getProduct_subcategory());
			entity.setProperty(ServiceConstant.NUTRITIONAL_VALUE, product.getNutritional_value());
			entity.setProperty(ServiceConstant.P_SOLD_NUMBER, product.getProduct_sold_number());
			entity.setProperty(ServiceConstant.P_TYPE, product.getType().toString());
			entity.setProperty(ServiceConstant.P_IS_DELETED, product.getIs_deleted());
			
		} catch (Exception e) {
			//TODO mail this problem

		}
		return entity;
	}
	
	
	public static Product entityToProduct(Entity entity) {
		
		String articleID = entity.getKey().getName();
		Product product = new Product();
		product.setProduct_id(articleID);
		product.setProduct_name(entity.getProperty(ServiceConstant.P_NAME).toString());
		product.setProduct_image(entity.getProperty(ServiceConstant.P_IMAGE_URL).toString());
		product.setProduct_brand(entity.getProperty(ServiceConstant.P_BRAND).toString());
		product.setProduct_category(entity.getProperty(ServiceConstant.P_CATEGORY).toString());

		product.setDescription(entity.getProperty(ServiceConstant.P_DESCRIPTION).toString());
		product.setOriginal_price((long) entity.getProperty(ServiceConstant.ORIGINAL_PRICE));
		product.setDiscounted_price((long)entity.getProperty(ServiceConstant.DISCOUNT_PRICE));
		product.setIs_veg((boolean)entity.getProperty(ServiceConstant.IS_VEG));
		product.setProduct_weight((long)entity.getProperty(ServiceConstant.PRODUCT_WEIGHT));
		product.setDiscount_percentage((long)entity.getProperty(ServiceConstant.DISCOUNT_PERCENTAGE));
		product.setSubCategoryId(entity.getProperty(ServiceConstant.SUB_CATEGORY_ID).toString());
		product.setNutritional_value(entity.getProperty(ServiceConstant.NUTRITIONAL_VALUE).toString());
		product.setProduct_sold_number((long)entity.getProperty(ServiceConstant.P_SOLD_NUMBER));
		product.setType(ServiceConstant.Type.valueOf(entity.getProperty(ServiceConstant.P_TYPE).toString()));
		
		Object isDeleted = entity.getProperty(ServiceConstant.P_IS_DELETED);
		
		if (isDeleted != null) {
			product.setIs_deleted((boolean)isDeleted);
		}
		
		
		
		return product;
	}
	public static Entity categoryToEntity(Category product) {
		
		Entity entity = new Entity(ServiceConstant.CATEGORY_ENTITY, product.getCategory_id());
		try {

			entity.setProperty(ServiceConstant.CATEGORY_NAME, product.getCategory_name());
			entity.setProperty(ServiceConstant.CATEGORY_ID, product.getCategory_id());
			entity.setProperty(ServiceConstant.C_IMAGE_URL, product.getCategory_image());
			entity.setProperty(ServiceConstant.C_PARENT_ID, product.getParent_Id());
			
		}
		
		catch (Exception e) {
			
		}
		return entity;
	}
	public static Category entityToCategory(Entity entity) {
		
		String articleID = entity.getKey().getName();
		Category product = new Category();
		product.setCategory_name(entity.getProperty(ServiceConstant.CATEGORY_NAME).toString());
		product.setCategory_id(entity.getProperty(ServiceConstant.CATEGORY_ID).toString());
		product.setCategory_image(entity.getProperty(ServiceConstant.C_IMAGE_URL).toString());
		product.setParent_Id(entity.getProperty(ServiceConstant.C_PARENT_ID).toString());

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
