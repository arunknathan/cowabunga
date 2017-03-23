package com.cowabunga.entity.util;

import java.io.PrintStream;

import com.cowabunga.common.LocationRegistry;

/**
 * Declaration for any Util Class implementation for {@link LocationRegistry}
 * 
 * @author arunk
 *
 */
public interface LocationRegistryUtil {
	/**
	 * None of the input parameters are null.
	 * 
	 * @param lOC_REG
	 *            {@link LocationRegistry}
	 * @param out
	 *            {@link PrintStream}
	 */
	void printLocationRegistryEntries(final LocationRegistry lOC_REG, final PrintStream out);
}
