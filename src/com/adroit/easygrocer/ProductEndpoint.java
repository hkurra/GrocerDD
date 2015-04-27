package com.adroit.easygrocer;

import com.adroit.easygrocer.EMF;
import com.adroit.easygrocer.Product.Type;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.QueryResultList;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.appengine.datanucleus.query.JPACursorHelper;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	 */
	@ApiMethod(name = "getProduct")
	public Product getProduct(@Named("id") Long id) {
		Product product = null;

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
		if (product.getId()== null || product.getId().isEmpty()) {
			return null;
		}
		  
		  if(product.getId() != null) {
			  p.setId(product.getId());
		  }
		  if(product.getName() != null) {
			  p.setName(product.getName());
		  }
		  if(product.getImage() != null) {
			  p.setImage(product.getImage());
		  }
		  if(product.getBrand() != null) {
			  p.setBrand(product.getBrand());
		  }
		  if(product.getCategory() != null) {
			  p.setCategory(product.getCategory());
		  }
		  if(product.getDescription() != null) {
			  p.setDescription(product.getDescription());
		  }
		  if(product.getOriginalPrice() != 0) {
			  p.setOriginalPrice(product.getOriginalPrice());
		  }
		  if(product.getDiscountPrice() != 0 ) {
			  p.setDiscountPrice(product.getDiscountPrice());
		  }
		  if(product.getProducWeight() != 0) {
			  p.setProducWeight(product.getProducWeight());
		  }
		  if(product.getDiscountPercentage() != 0) {
			  p.setDiscountPercentage(product.getDiscountPercentage());
		  }
		  if(product.getSubCategoryId() != 0) {
			  p.setSubCategoryId(product.getSubCategoryId());
		  }
		  if(product.getNutritionalValue() != null ) {
			  p.setNutritionalValue(product.getNutritionalValue());
		  }
		  if(product.getType() != null ) {
			  p.setType(product.getType());
		  }
		  if(product.getProductSoldNo() != 0 ) {
			  p.setProductSoldNo(product.getProductSoldNo());
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
	 */
	@ApiMethod(name = "updateProduct")
	public Product updateProduct(Product product) {

		return product;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeProduct")
	public void removeProduct(@Named("id") Long id) {
	}

}
