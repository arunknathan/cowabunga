package com.cowabunga.entity;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.cowabunga.common.Coordinate;
import com.cowabunga.common.Direction;
import com.cowabunga.common.LocationRegistry;
import com.cowabunga.common.MoveStep;

@RunWith(JUnit4.class)
public class TurtleGoTest {

	@Test
	public void testObstacleInWay() {
		final int N = 10;
		final LocationRegistry LOC_REG = new LocationRegistry(1, 1, N, N);
		final Turtle TURTLE = new Turtle(LOC_REG, Direction.NORTH, new Coordinate(1, 1));
		LOC_REG.takeLocation(TURTLE.getCurrentLocation(), TURTLE);

		final Obstacle OBSTACLE = new Obstacle();
		LOC_REG.takeLocation(new Coordinate(2, 2), OBSTACLE);

		TURTLE.move(MoveStep.FORWARD);
		TURTLE.move(MoveStep.RIGHT);
		TURTLE.move(MoveStep.FORWARD);
		TURTLE.move(MoveStep.RIGHT);
		TURTLE.move(MoveStep.FORWARD);
		TURTLE.move(MoveStep.LEFT);
		TURTLE.move(MoveStep.FORWARD);

		if (!TURTLE.getCurrentLocation().equals(new Coordinate(3, 5))
				|| !TURTLE.getFacingDirection().equals(Direction.NORTH)) {
			fail("The Turtle should have been at (3,5) facing North.");
		}
	}

}
