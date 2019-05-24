package com.xander.rpn.entity.operation.impl;

import com.xander.rpn.common.SymbolConstants;
import com.xander.rpn.entity.stack.NumberStack;
import com.xander.rpn.entity.operation.AbstractTwoArgumentsOperation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class AdditionOperation extends AbstractTwoArgumentsOperation {
	@Override
	public void process() {
		this.result = new BigDecimal(this.firstArgument.doubleValue(), STACK_MATH_CONTECT);
		this.result = this.result.add(this.secondArgument, STACK_MATH_CONTECT);
	}

	@Override
	public String getSymbol() {
		return SymbolConstants.PLUS;
	}

}
