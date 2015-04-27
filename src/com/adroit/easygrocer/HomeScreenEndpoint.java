package com.adroit.easygrocer;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JPACursorHelper;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;

@Api(name = "homescreenendpoint", namespace = @ApiNamespace(ownerDomain = "adroit.com", ownerName = "adroit.com", packagePath = "easygrocer"))
public class HomeScreenEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
//	@SuppressWarnings({ "unchecked", "unused" })
//	@ApiMethod(name = "listHomeScreen")
//	public CollectionResponse<HomeScreen> listHomeScreen(
//			@Nullable @Named("cursor") String cursorString,
//			@Nullable @Named("limit") Integer limit) {
//
//		return CollectionResponse.<HomeScreen> builder().setItems(null)
//				.setNextPageToken(cursorString).build();
//	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getHomeScreen")
	public HomeScreen getHomeScreen() {
		HomeScreen homescreen = null;

		return homescreen;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param homescreen the entity to be inserted.
	 * @return The inserted entity.
	 */
//	@ApiMethod(name = "insertHomeScreen")
//	public HomeScreen insertHomeScreen(@Named HomeScreen homescreen) {
//
//		return new HomeScreen();
//	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param homescreen the entity to be updated.
	 * @return The updated entity.
	 */
//	@ApiMethod(name = "updateHomeScreen")
//	public HomeScreen updateHomeScreen(@Named HomeScreen homescreen) {
//
//		return homescreen;
//	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeHomeScreen")
	public void removeHomeScreen(@Named("id") Long id) {

	}

}
