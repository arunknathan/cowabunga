package com.cowabunga.entity.util.impl;

import java.util.Random;

import com.cowabunga.common.Coordinate;
import com.cowabunga.common.LocationRegistry;
import com.cowabunga.entity.Obstacle;
import com.cowabunga.entity.util.ObstacleUtil;

/**
 * An Implemenation of Util class for {@link Obstacle} as per declaration in
 * {@link ObstacleUtil}.
 * 
 * @author arunk
 *
 */
public class ObstacleUtilImpl implements ObstacleUtil {

	@Override
	public void generateObstacles(final int OBSTACLE_COUNT, final int MIN_X, final int MIN_Y, final int MAX_X, final int MAX_Y,
			final LocationRegistry LOC_REG) {
		final Random RND_NUM_GEN = new Random();
		Coordinate coordinate;
		final Obstacle OBSTACLE = new Obstacle();
		for (int i = 0; i < OBSTACLE_COUNT; i++) {
			coordinate = new Coordinate(MIN_X + RND_NUM_GEN.nextInt(MAX_X - MIN_X - 1),
					MIN_Y + RND_NUM_GEN.nextInt(MAX_Y - MIN_Y - 1));
			if (!LOC_REG.takeLocation(coordinate, OBSTACLE)) {
				i--;
			}
		}
	}

}
