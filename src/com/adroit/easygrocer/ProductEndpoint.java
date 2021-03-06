package com.adroit.easygrocer;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.QueryResultList;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;

import util.ServiceConstant;
import util.productUtility;


@Api(name = "productendpoint", namespace = @ApiNamespace(ownerDomain = "adroit.com", ownerName = "adroit.com", packagePath = "easygrocer"))
public class ProductEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listProduct")
	public CollectionResponse<Product> listProduct(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		  if (limit == null || limit == 0) {
			  limit = 100;
		  }
		  
	    List<Product> execute = new ArrayList<Product>();
	    
	    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		com.google.appengine.api.datastore.Query q = new com.google.appengine.api.datastore.Query(ServiceConstant.PRODUCT_ENTITY);
		
		FetchOptions fetchOptions = FetchOptions.Builder.withLimit(limit);
		
		if (cursorString != null) {
		      fetchOptions.startCursor(Cursor.fromWebSafeString(cursorString));
		    }
		
		PreparedQuery pq = datastore.prepare(q);
		QueryResultList<Entity> results = pq.asQueryResultList(fetchOptions);

		Cursor  cursor = results.getCursor();
		execute  = productUtility.entitiesToProducts(results);
		String cursorString1 = cursor != null && execute.size() == limit? cursor.toWebSafeString() : null;
		
	    return CollectionResponse.<Product>builder()
	      .setItems(execute)
	      .setNextPageToken(cursorString1)
	      .build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 * @throws Exception 
	 */
	@ApiMethod(name = "getProduct")
	public Product getProduct(@Named("id") String id) throws Exception {
		Product product = null;
		
		if(id == null || id.isEmpty()) {
			   throw new Exception("Invalid id");
		  }
	    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	    Key k = KeyFactory.createKey(ServiceConstant.PRODUCT_ENTITY, id);
	    
	    Filter keyFilter = new FilterPredicate(Entity.KEY_RESERVED_PROPERTY, FilterOperator.EQUAL,k);
	    com.google.appengine.api.datastore.Query q = new com.google.appengine.api.datastore.Query(ServiceConstant.PRODUCT_ENTITY);
	    q.setFilter(keyFilter);
	    List<Entity> greetings = datastore.prepare(q).asList(FetchOptions.Builder.withLimit(1));
	    
		for (Entity greeting : greetings) {
			product = productUtility.entityToProduct(greeting);
		}
		
		//ArticleUtility.determineCategorey(editorialarticle, true);
	    return product;

	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param product the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertProduct")
	public Product insertProduct(Product product) {

		Product p = new Product();
		if (product.getProduct_id()== null || product.getProduct_id().isEmpty()) {
			return null;
		}
		  
		  if(product.getProduct_id() != null) {
			  p.setProduct_id(product.getProduct_id());
		  }
		  if(product.getProduct_name() != null) {
			  p.setProduct_name(product.getProduct_name());
		  }
		  if(product.getProduct_image() != null) {
			  p.setProduct_image(product.getProduct_image());
		  }
		  if(product.getProduct_brand() != null) {
			  p.setProduct_brand(product.getProduct_brand());
		  }
		  if(product.getProduct_category() != null) {
			  p.setProduct_category(product.getProduct_category());
		  }
		  if(product.getDescription() != null) {
			  p.setDescription(product.getDescription());
		  }
		  if(product.getOriginal_price() != 0) {
			  p.setOriginal_price(product.getOriginal_price());
		  }
		  if(product.getDiscounted_price() != 0 ) {
			  p.setDiscounted_price(product.getDiscounted_price());
		  }
		  if(product.getProduct_weightt() != 0) {
			  p.setProduct_weight(product.getProduct_weightt());
		  }
		  if(product.getDiscount_percentage() != 0) {
			  p.setDiscount_percentage(product.getDiscount_percentage());
		  }
		  if(product.getProduct_subcategory() != null) {
			  p.setSubCategoryId(product.getProduct_subcategory());
		  }
		  if(product.getNutritional_value() != null ) {
			  p.setNutritional_value(product.getNutritional_value());
		  }
		  if(product.getType() != null ) {
			  p.setType(product.getType());
		  }
		  if(product.getProduct_sold_number() != 0 ) {
			  p.setProduct_sold_number(product.getProduct_sold_number());
		  }
		  
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(productUtility.productToEntity(p));
		
		return p;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param product the entity to be updated.
	 * @return The updated entity.
	 * @throws Exception 
	 */
	@ApiMethod(name = "updateProduct")
	public Product updateProduct(Product product) throws Exception {

		  DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		  
		  
		  Product p = getProduct(product.getProduct_id());
		  if(p == null) {throw new Exception("Entity Does Not Exist");}
		  
		  
		  if(product.getProduct_id() != null && !product.getProduct_id().equals(Product.undefinedConst)) {
			  p.setProduct_id(product.getProduct_id());
		  }
		  if(product.getProduct_name() != null && !product.getProduct_name().equals(Product.undefinedConst)) {
			  p.setProduct_name(product.getProduct_name());
		  }
		  if(product.getProduct_image() != null && !product.getProduct_image().equals(Product.undefinedConst)) {
			  p.setProduct_image(product.getProduct_image());
		  }
		  if(product.getProduct_brand() != null && !product.getProduct_brand().equals(Product.undefinedConst)) {
			  p.setProduct_brand(product.getProduct_brand());
		  }
		  if(product.getProduct_category() != null && !product.getProduct_category().equals(Product.undefinedConst)) {
			  p.setProduct_category(product.getProduct_category());
		  }
		  if(product.getDescription() != null && !product.getDescription().equals(Product.undefinedConst)) {
			  p.setDescription(product.getDescription());
		  }
		  if(product.getOriginal_price() != -1)  {
			  p.setOriginal_price(product.getOriginal_price());
		  }
		  if(product.getDiscounted_price() != -1) {
			  p.setDiscounted_price(product.getDiscounted_price());
		  }
		  if(product.getProduct_weightt() != -1) {
			  p.setProduct_weight(product.getProduct_weightt());
		  }
		  if(product.getDiscount_percentage() != -1) {
			  p.setDiscount_percentage(product.getDiscount_percentage());
		  }
		  if(product.getProduct_subcategory() != null && !product.getProduct_subcategory().equals(Product.undefinedConst)) {
			  p.setSubCategoryId(product.getProduct_subcategory());
		  }
		  if(product.getNutritional_value() != null && !product.getNutritional_value().equals(Product.undefinedConst)) {
			  p.setNutritional_value(product.getNutritional_value());
		  }
		  if(product.getType() != null && !product.getType().equals(Product.undefinedConst)) {
			  p.setType(product.getType());
		  }
		  if(product.getProduct_sold_number() != -1) {
			  p.setProduct_sold_number(product.getProduct_sold_number());
		  }
		  
		datastore.put(productUtility.productToEntity(p));
		
		return p;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeProduct")
	public void removeProduct(@Named("id") String id) {
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	    Key k = KeyFactory.createKey(ServiceConstant.PRODUCT_ENTITY, id);
	    datastore.delete(k);
	    
	}

}


