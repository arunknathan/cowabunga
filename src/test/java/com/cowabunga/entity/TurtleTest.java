package com.cowabunga.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.cowabunga.common.Coordinate;
import com.cowabunga.common.Direction;
import com.cowabunga.common.LocationRegistry;
import com.cowabunga.common.Step;

public class TurtleTest {

    @Test
    public void testObstacleInWay() {
        final int N = 10;
        final LocationRegistry LOC_REG = new LocationRegistry(1, 1, N, N);
        final Turtle TURTLE = new Turtle(LOC_REG, Direction.NORTH, new Coordinate(1, 1));
        LOC_REG.takeLocation(TURTLE.getCurrentLocation(), TURTLE);

        final Obstacle OBSTACLE = new Obstacle();
        LOC_REG.takeLocation(new Coordinate(2, 2), OBSTACLE);

        TURTLE.move(Step.FORWARD);
        TURTLE.move(Step.RIGHT);
        TURTLE.move(Step.FORWARD);
        TURTLE.move(Step.RIGHT);
        TURTLE.move(Step.FORWARD);
        TURTLE.move(Step.LEFT);
        TURTLE.move(Step.FORWARD);

        assertEquals(new Coordinate(3, 5), TURTLE.getCurrentLocation());
        assertEquals(Direction.NORTH, TURTLE.getFacingDirection());
    }

}
