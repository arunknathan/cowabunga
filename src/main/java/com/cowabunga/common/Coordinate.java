package com.cowabunga.common;

/**
 * Defines the coordinate that can be used for storing location information.
 * 
 * @author arunk
 *
 */
public class Coordinate {

	private int x;
	private int y;

	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) throws ClassCastException {
		Coordinate c = (Coordinate) o;
		return c.x == x && c.y == y;
	}

	@Override
	public int hashCode() {
		return new Integer(x + "0" + y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
