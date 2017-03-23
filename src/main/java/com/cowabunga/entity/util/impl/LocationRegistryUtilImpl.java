package com.cowabunga.entity.util.impl;

import java.io.PrintStream;
import java.util.Map;

import com.cowabunga.common.Coordinate;
import com.cowabunga.common.LocationRegistry;
import com.cowabunga.entity.Entity;
import com.cowabunga.entity.util.LocationRegistryUtil;

public class LocationRegistryUtilImpl implements LocationRegistryUtil {

	@Override
	public void printLocationRegistryEntries(LocationRegistry lOC_REG, PrintStream out) {
		Map<Coordinate, Entity> entityLocMap = lOC_REG.getUnmodifiableObstacleLocationMap();
		for (Coordinate coordinate : entityLocMap.keySet()) {
			out.println(coordinate + " " + entityLocMap.get(coordinate).getClass().getSimpleName());
		}
	}

}
