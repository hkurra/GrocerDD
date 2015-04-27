package com.adroit.easygrocer;

import com.adroit.easygrocer.EMF;
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

@Api(name = "categoryendpoint", namespace = @ApiNamespace(ownerDomain = "adroit.com", ownerName = "adroit.com", packagePath = "easygrocer"))
public class CategoryEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listCategory")
	public CollectionResponse<Category> listCategory(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		if (limit == null || limit == 0) {
			  limit = 100;
		  }
		  
	    List<Category> execute = new ArrayList<Category>();
	    
	    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		com.google.appengine.api.datastore.Query q = new com.google.appengine.api.datastore.Query(ServiceConstant.CATEGORY_ENTITY);
		
		FetchOptions fetchOptions = FetchOptions.Builder.withLimit(limit);
		
		if (cursorString != null) {
		      fetchOptions.startCursor(Cursor.fromWebSafeString(cursorString));
		    }
		
		PreparedQuery pq = datastore.prepare(q);
		QueryResultList<Entity> results = pq.asQueryResultList(fetchOptions);

		Cursor  cursor = results.getCursor();//toWebSafeString();
		execute  = productUtility.entitiesToCategory(results);
		String cursorString1 = cursor != null && execute.size() == limit? cursor.toWebSafeString() : null;
		

	    return CollectionResponse.<Category>builder()
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
	@ApiMethod(name = "getCategory")
	public Category getCategory(@Named("id") String id) throws Exception {

		Category product = null;
		if(id == null || id.isEmpty()) {
			   throw new Exception("Invalid id");
		  }
	    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	    Key k = KeyFactory.createKey(ServiceConstant.CATEGORY_ENTITY, id);
	    
	    Filter keyFilter = new FilterPredicate(Entity.KEY_RESERVED_PROPERTY, FilterOperator.EQUAL,k);
	    com.google.appengine.api.datastore.Query q = new com.google.appengine.api.datastore.Query(ServiceConstant.CATEGORY_ENTITY);
	    q.setFilter(keyFilter);
	    List<Entity> greetings = datastore.prepare(q).asList(FetchOptions.Builder.withLimit(1));
	    
		for (Entity greeting : greetings) {
			product = productUtility.entityToCategory(greeting);
		}
		
	    return product;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param category the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertCategory")
	public Category insertCategory(Category category) {

		List<Entity> categories = new ArrayList<Entity>();
		Category p = new Category();
		if (category.getId()== null || category.getId().isEmpty()) {
			return null;
		}
		  
		  if(category.getId() != null) {
			  p.setId(category.getId());
		  }
		  if(category.getName() != null) {
			  p.setName(category.getName());
		  }
		  if(category.getImageURL() != null) {
			  p.setImageURL(category.getImageURL());
		  }
		  
		  categories.add(productUtility.categoryToEntity(p));
		  if(category.getSubCategory() != null && category.getSubCategory().size() >0) {
			  for (Category cc: category.getSubCategory()) {
				  cc.setParentCategoryID(category.getId());
				  categories.add(productUtility.categoryToEntity(cc));
			  }
		  }
		  
		  
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(categories);
		
		return p;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param category the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateCategory")
	public Category updateCategory(Category category) {

		Category p = new Category();
		if (category.getId()== null || category.getId().isEmpty()) {
			return null;
		}
		  
		  if(category.getId() != null && !category.getId().equals(Product.undefinedConst)) {
			  p.setId(category.getId());
		  }
		  if(category.getName() != null && !category.getName().equals(Product.undefinedConst)) {
			  p.setName(category.getName());
		  }
		  if(category.getImageURL() != null && !category.getImageURL().equals(Product.undefinedConst)) {
			  p.setImageURL(category.getImageURL());
		  }
		  
		  if(category.getSubCategory() != null && category.getSubCategory().size() >0) {
			  p.getSubCategory().addAll(category.getSubCategory());
		  }
		  
		  
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(productUtility.categoryToEntity(p));
		
		return p;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeCategory")
	public void removeCategory(@Named("id") Long id) {

	}

}
