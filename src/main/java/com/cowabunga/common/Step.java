package com.cowabunga.common;

public enum Step {
	FORWARD('f'), LEFT('l'), RIGHT('r');

	private final char step;

	private Step(char step) {
		this.step = step;
	}

	public char getStepValue() {
		return step;
	}

	public static Step get(final char ch) {
		switch (ch) {
		case 'l':
			return LEFT;
		case 'r':
			return RIGHT;
		case 'f':
			return FORWARD;
		}
		return null;
	}

}
