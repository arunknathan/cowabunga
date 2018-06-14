package com.cowabunga.entity;

import com.cowabunga.common.Coordinate;
import com.cowabunga.common.Direction;
import com.cowabunga.common.LocationRegistry;
import com.cowabunga.common.Step;

/**
 * Definition for a Turtle entity.
 * 
 * @author arunknathan
 *
 */
public class Turtle implements Entity {

	private Direction facingDirection;

	/**
	 * The direction the Turtle is facing.
	 * 
	 * @return {@link Direction}
	 */
	public Direction getFacingDirection() {
		return facingDirection;
	}

	private LocationRegistry locationRegistry;

	/**
	 * 
	 * @return {@link LocationRegistry} that the turtle uses for locomotion.
	 */
	public LocationRegistry getLocationRegistry() {
		return locationRegistry;
	}

	private Coordinate currentLocation;

	public Coordinate getCurrentLocation() {
		return currentLocation;
	}

	public Turtle(LocationRegistry locationRegistry, Direction facingDirection, Coordinate currentLocation) {
		super();
		this.facingDirection = facingDirection;
		this.locationRegistry = locationRegistry;
		this.currentLocation = currentLocation;
	}

	public synchronized boolean move(final Step STEP) {
		Coordinate temp = null;
		if ((STEP == Step.FORWARD && facingDirection == Direction.NORTH)
				|| (STEP == Step.RIGHT && facingDirection == Direction.WEST)
				|| (STEP == Step.LEFT && facingDirection == Direction.EAST)) {
			if (locationRegistry.moveToLocation(currentLocation,
					temp = new Coordinate(currentLocation.x, currentLocation.y + 1), this)) {
				currentLocation = temp;
				facingDirection = Direction.NORTH;
				return true;
			}
		} else if ((STEP == Step.FORWARD && facingDirection == Direction.EAST)
				|| (STEP == Step.RIGHT && facingDirection == Direction.NORTH)
				|| (STEP == Step.LEFT && facingDirection == Direction.SOUTH)) {
			if (locationRegistry.moveToLocation(currentLocation,
					temp = new Coordinate(currentLocation.x + 1, currentLocation.y), this)) {
				currentLocation = temp;
				facingDirection = Direction.EAST;
				return true;
			}
		} else if ((STEP == Step.FORWARD && facingDirection == Direction.WEST)
				|| (STEP == Step.RIGHT && facingDirection == Direction.SOUTH)
				|| (STEP == Step.LEFT && facingDirection == Direction.NORTH)) {
			if (locationRegistry.moveToLocation(currentLocation,
					temp = new Coordinate(currentLocation.x - 1, currentLocation.y), this)) {
				currentLocation = temp;
				facingDirection = Direction.WEST;
				return true;
			}
		} else {
			if (locationRegistry.moveToLocation(currentLocation,
					temp = new Coordinate(currentLocation.x, currentLocation.y - 1), this)) {
				currentLocation = temp;
				facingDirection = Direction.SOUTH;
				return true;
			}
		}
		return false;
	}

}
