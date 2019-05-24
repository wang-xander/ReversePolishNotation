package com.xander.rpn.entity.operation.impl;

import com.xander.rpn.common.SymbolConstants;
import com.xander.rpn.entity.stack.NumberStack;
import com.xander.rpn.entity.operation.AbstractOneArgumentOperation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class SquareOperation extends AbstractOneArgumentOperation {
	@Override
	public void process() {
		this.result = new BigDecimal(this.firstArgument.doubleValue(), STACK_MATH_CONTECT);
		this.result = this.result.multiply(this.firstArgument, STACK_MATH_CONTECT);
	}

	@Override
	public String getSymbol() {
		return SymbolConstants.SQUARE;
	}

}
