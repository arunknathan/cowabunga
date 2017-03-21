package com.cowabunga.entity;

import com.cowabunga.common.Direction;

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

}
