package com.xander.rpn.entity.operation.impl;

import com.xander.rpn.common.OperationErrors;
import com.xander.rpn.common.SymbolConstants;
import com.xander.rpn.entity.stack.NumberStack;
import com.xander.rpn.entity.operation.AbstractTwoArgumentsOperation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class DivisionOperation extends AbstractTwoArgumentsOperation {

	@Override
	public void process() {
		this.result = new BigDecimal(this.firstArgument.doubleValue(), STACK_MATH_CONTECT);
		this.result = this.result.divide(this.secondArgument, STACK_MATH_CONTECT);
	}

	@Override
	public String getSymbol() {
		return SymbolConstants.DIVIDE;
	}

	@Override
	public OperationErrors validateArgument() {
		OperationErrors error = super.validateArgument();
		if (!error.equals(OperationErrors.NO_ERROR)) {
			return error;
		}
		if (super.numberStack.getSecond().equals(new BigDecimal(0))) {
			return OperationErrors.DIVISION_BY_ZERO;
		}
		return OperationErrors.NO_ERROR;
	}
}
