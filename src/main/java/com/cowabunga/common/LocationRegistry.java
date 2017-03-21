package com.cowabunga.common;

import java.util.HashMap;

import com.cowabunga.entity.Entity;

/**
 * Definition of a registry that holds location specific information on whether
 * there is any entity in a particular coordinate.
 * 
 * @author arunk
 *
 */
public class LocationRegistry {

	private HashMap<Coordinate, Entity> obstacleLocationMap = new HashMap<>();

	private int minX, minY, maxX, maxY;

	public LocationRegistry(int minX, int minY, int maxX, int maxY) {
		super();
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
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

}