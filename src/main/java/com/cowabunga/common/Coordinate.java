package com.cowabunga.common;

import java.util.Objects;

/**
 * Defines the coordinate that can be used for storing location information.
 *
 * @author arunk
 */
public class Coordinate {

    public final int x;
    public final int y;

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
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

}
