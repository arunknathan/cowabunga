package com.cowabunga.common;

public enum MoveStep {
	FORWARD('f'), LEFT('l'), RIGHT('r');

	private final char step;

	private MoveStep(char step) {
		this.step = step;
	}

	public char getStepValue() {
		return step;
	}

	public static MoveStep toMoveStep(final char ch) {
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
