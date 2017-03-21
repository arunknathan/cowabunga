package com.cowabunga.hello;

import static org.junit.Assert.fail;

import org.junit.Test;

public class HelloWorldTest {

	@Test
	public void testMain() {
		try {
			HelloWorld.main(null);
		} catch (Exception ex) {
			fail("HelloWorld main method did not execute completely - an Exception was thrown.");
		}
	}

}
