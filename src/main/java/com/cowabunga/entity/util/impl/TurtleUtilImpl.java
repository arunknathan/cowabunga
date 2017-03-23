package com.cowabunga.entity.util.impl;

import java.io.BufferedReader;
import java.io.IOException;

import com.cowabunga.common.LocationRegistry;
import com.cowabunga.common.MoveStep;
import com.cowabunga.entity.Turtle;
import com.cowabunga.entity.util.TurtleUtil;

public class TurtleUtilImpl implements TurtleUtil {

	@Override
	public void readInputAndMoveTurtle(final LocationRegistry LOC_REG, final Turtle TURTLE,
			final BufferedReader BUF_RDR) throws IOException {
		char inputCh;
		boolean acceptableInput;
		do {
			inputCh = (char) BUF_RDR.read();
			acceptableInput = (inputCh == MoveStep.FORWARD.getStepValue() || inputCh == MoveStep.LEFT.getStepValue()
					|| inputCh == MoveStep.RIGHT.getStepValue());
			if (acceptableInput) {
				TURTLE.move(MoveStep.toMoveStep(inputCh));
			}
		} while (acceptableInput);
	}

}
