package com.cowabunga.common;

public enum Direction {
	NORTH('N'), SOUTH('S'), EAST('E'), WEST('W');

	private char direction;

	private Direction(final char direction) {
		this.direction = direction;
	}

	public char getDirectionValue() {
		return direction;
	}

}
