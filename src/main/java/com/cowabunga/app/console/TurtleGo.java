package com.cowabunga.app.console;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.cowabunga.common.Coordinate;
import com.cowabunga.common.Direction;
import com.cowabunga.common.LocationRegistry;
import com.cowabunga.entity.Turtle;
import com.cowabunga.entity.util.impl.LocationRegistryUtilImpl;
import com.cowabunga.entity.util.impl.ObstacleUtilImpl;
import com.cowabunga.entity.util.impl.TurtleUtilImpl;

public class TurtleGo {

	private static final int INPUT_BUFFER = 1024;

	public static void main(String[] args) {
		final int N;
		try {
			N = Integer.parseInt(args[0]);
		} catch (NumberFormatException nfEx) {
			throw new RuntimeException("Please specify an integer value for 'N' as the first command line argument.",
					nfEx);
		}

		System.out.println("Turtle Go!");
		if (args.length >= 2) {
			System.setIn(new ByteArrayInputStream(args[1].getBytes()));
		} else {
			System.out.println("Please enter the sequence with [f, l, r]:");
		}

		final LocationRegistry LOC_REG = new LocationRegistry(1, 1, N, N);
		final Turtle TURTLE = new Turtle(LOC_REG, Direction.NORTH, new Coordinate(1, 1));

		LOC_REG.takeLocation(TURTLE.getCurrentLocation(), TURTLE);

		new ObstacleUtilImpl().generateObstacles(N, 1, 1, N, N, LOC_REG);

		final BufferedReader BUF_RDR = new BufferedReader(new InputStreamReader(System.in), INPUT_BUFFER);
		try {
			new TurtleUtilImpl().readInputAndMoveTurtle(LOC_REG, TURTLE, BUF_RDR);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		System.out.println("TURTLE (x,y facing_direction):");
		System.out.println(TURTLE.getCurrentLocation() + " " + TURTLE.getFacingDirection().getDirectionValue());

		System.out.println("Location Registry Entries (x,y entity):");
		new LocationRegistryUtilImpl().printLocationRegistryEntries(LOC_REG, System.out);
	}

}
