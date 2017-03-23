package com.cowabunga.entity.util;

import com.cowabunga.common.LocationRegistry;
import com.cowabunga.entity.Obstacle;

/**
 * Declaration for any Util Class implementation for {@link Obstacle}
 * 
 * @author arunk
 *
 */
public interface ObstacleUtil {
	/**
	 * 
	 * <b>Assumptions:</b><br>
	 * MIN_X < MAX_X <br>
	 * MIN_Y < MAX_Y <br>
	 * OBSTACLE_COUNT < ((MAX_X - MIN_X) * (MAX_Y - MIN_Y)) <br>
	 * None of the input parameters are null.
	 * 
	 * @param OBSTACLE_COUNT
	 * @param MIN_X
	 * @param MIN_Y
	 * @param MAX_X
	 * @param MAX_Y
	 * @param LOC_REG
	 *            {@link LocationRegistry}
	 */
	void generateObstacles(final int OBSTACLE_COUNT, final int MIN_X, final int MIN_Y, final int MAX_X, final int MAX_Y,
			final LocationRegistry LOC_REG);
}
