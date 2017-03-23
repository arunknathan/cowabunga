package com.cowabunga.entity.util;

import java.io.BufferedReader;
import java.io.IOException;

import com.cowabunga.common.LocationRegistry;
import com.cowabunga.entity.Turtle;

/**
 * Declaration for any Util Class implementation for {@link Turtle}
 * 
 * @author arunk
 *
 */
public interface TurtleUtil {
	/**
	 * <b>Assumptions:</b><br>
	 * LOC_REG already has an entry in it for TURTLE.<br>
	 * None of the input parameters are null.
	 * 
	 * @param LOC_REG
	 *            {@link LocationRegistry}
	 * @param TURTLE
	 *            {@link Turtle}
	 * @param BUF_RDR
	 *            {@link BufferedReader}
	 * @throws IOException
	 */
	void readInputAndMoveTurtle(final LocationRegistry LOC_REG, final Turtle TURTLE, final BufferedReader BUF_RDR)
			throws IOException;
}
