package com.cowabunga.app.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Map;
import java.util.Random;

import com.cowabunga.common.Coordinate;
import com.cowabunga.common.Direction;
import com.cowabunga.common.LocationRegistry;
import com.cowabunga.common.MoveStep;
import com.cowabunga.entity.Entity;
import com.cowabunga.entity.Obstacle;
import com.cowabunga.entity.Turtle;

public class TurtleGo {

	private static final int INPUT_BUFFER = 1024;

	public static void main(String[] args) {
		System.out.println("Turtle Go!");
		System.out.println("Please enter the sequence with [f, l, r]:");

		final int N;
		try {
			N = Integer.parseInt(args[0]);
		} catch (NumberFormatException nfEx) {
			throw new RuntimeException("Boundary value for location must be an integer.", nfEx);
		}

		final LocationRegistry LOC_REG = new LocationRegistry(1, 1, N, N);
		final Turtle TURTLE = new Turtle(LOC_REG, Direction.NORTH, new Coordinate(1, 1));

		LOC_REG.takeLocation(TURTLE.getCurrentLocation(), TURTLE);

		generateObstacles(N, N, N, LOC_REG);

		final BufferedReader BUF_RDR = new BufferedReader(new InputStreamReader(System.in), INPUT_BUFFER);
		try {
			readInputStreamAndPrintTurtleLocation(LOC_REG, TURTLE, BUF_RDR);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		System.out.println("TURTLE (x,y facing_direction):");
		System.out.println(TURTLE.getCurrentLocation() + " " + TURTLE.getFacingDirection().getDirectionValue());

		System.out.println(LOC_REG.getUnmodifiableObstacleLocationMap().keySet().size());
		printLocationRegistryEntries(LOC_REG, System.out);
	}

	private static void printLocationRegistryEntries(LocationRegistry lOC_REG, PrintStream out) {
		Map<Coordinate, Entity> entityLocMap = lOC_REG.getUnmodifiableObstacleLocationMap();
		for (Coordinate coordinate : entityLocMap.keySet()) {
				System.out.println(coordinate + " " + entityLocMap.get(coordinate).getClass().getSimpleName());
		}
	}

	public static void readInputStreamAndPrintTurtleLocation(final LocationRegistry LOC_REG, final Turtle TURTLE,
			final BufferedReader BUF_RDR) throws IOException {
		char inputCh;
		do {
			inputCh = (char) BUF_RDR.read();
			TURTLE.move(MoveStep.toMoveStep(inputCh));
		} while (inputCh == MoveStep.FORWARD.getStepValue() || inputCh == MoveStep.LEFT.getStepValue()
				|| inputCh == MoveStep.RIGHT.getStepValue());
	}

	public static void generateObstacles(final int OBSTACLE_COUNT, final int MAX_X, final int MAX_Y,
			LocationRegistry locationRegistry) {
		final Random RND_NUM_GEN = new Random();
		Coordinate coordinate;
		final Obstacle OBSTACLE = new Obstacle();
		for (int i = 0; i < OBSTACLE_COUNT; i++) {
			coordinate = new Coordinate(1 + RND_NUM_GEN.nextInt(MAX_X - 1), 1 + RND_NUM_GEN.nextInt(MAX_Y - 1));
			if (!locationRegistry.takeLocation(coordinate, OBSTACLE)) {
				i--;
			}
		}
	}

}
