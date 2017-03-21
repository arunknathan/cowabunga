package com.cowabunga.app.console;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.cowabunga.app.console.TurtleGo;

public class TurtleGoTest {

	@Test
	public void testMain() {
		try {
			TurtleGo.main(null);
		} catch (Exception ex) {
			fail("HelloWorld main method did not execute completely - an Exception was thrown.");
		}
	}

}
