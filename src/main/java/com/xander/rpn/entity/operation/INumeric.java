package com.xander.rpn.entity.operation;

import java.math.MathContext;
import java.math.RoundingMode;

public interface INumeric {
	public static MathContext STACK_MATH_CONTECT = new MathContext(15, RoundingMode.HALF_UP);
	public void prepareArgument();
	public void storeResult();
}
