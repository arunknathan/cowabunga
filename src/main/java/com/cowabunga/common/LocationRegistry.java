package com.cowabunga.common;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.cowabunga.entity.Entity;

/**
 * Definition of a registry that holds location specific information on whether
 * there is any entity in a particular coordinate.
 * 
 * @author arunk
 *
 */
public class LocationRegistry {

	private Map<Coordinate, Entity> obstacleLocationMap = new ConcurrentHashMap<>();

	private int minX, minY, maxX, maxY;

	public LocationRegistry(int minX, int minY, int maxX, int maxY) {
		super();
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
	}

	private Map<Coordinate, Entity> unmodifiableObstacleLocationMap = Collections.unmodifiableMap(obstacleLocationMap);

	public Map<Coordinate, Entity> getUnmodifiableObstacleLocationMap() {
		return unmodifiableObstacleLocationMap;
	}

	/**
	 * Checks whether there is any obstacle in the given coordinate
	 * 
	 * @param coordinate
	 *            {@link Coordinate}
	 * @return true - if location is available for occupation <br>
	 *         false - otherwise
	 */
	public boolean isLocationAvailable(Coordinate coordinate) {
		if (coordinate.getX() < minX || coordinate.getX() > maxX || coordinate.getY() < minY
				|| coordinate.getY() > maxY) {
			return false;
		}
		return obstacleLocationMap.get(coordinate) == null;
	}

	/**
	 * Makes a record in the location registry for a given {@link Entity}
	 * against a given coordinate.
	 * 
	 * @param coordinate
	 *            {@link Coordinate}
	 * @param entity
	 *            {@link Entity}
	 * @return true - if location occupation was a success<br>
	 *         false - otherwise
	 */
	public boolean takeLocation(Coordinate coordinate, Entity entity) {
		if (isLocationAvailable(coordinate)) {
			obstacleLocationMap.put(coordinate, entity);
			return true;
		}
		return false;
	}

	/**
	 * Makes an entry in the location registry for the given entity for a new
	 * location.
	 * 
	 * @param current
	 *            {@link Coordinate}
	 * @param destination
	 *            {@link Coordinate}
	 * @param entity
	 *            {@link Entity}
	 * @return true - if location occupation was a success<br>
	 *         false - otherwise
	 */
	public boolean moveToLocation(Coordinate current, Coordinate destination, Entity entity) {
		if (isLocationAvailable(destination)) {
			obstacleLocationMap.remove(current);
			obstacleLocationMap.put(destination, entity);
			return true;
		}
		return false;
	}

}
