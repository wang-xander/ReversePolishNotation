package com.xander.rpn.entity.operation.impl;

import com.xander.rpn.common.OperationErrors;
import com.xander.rpn.entity.operation.AbstractNumericOperation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class NumberStorageOperation extends AbstractNumericOperation {
	public NumberStorageOperation(BigDecimal argument) {
		super();
		this.firstArgument = argument;
	}

	@Override
	public void process() {
		this.result = new BigDecimal(this.firstArgument.doubleValue(), STACK_MATH_CONTECT);
	}

	@Override
	protected void restoreArgumentsToStack() {
		super.numberStack.popNumber();
	}

	@Override
	public String getSymbol() {
		return this.firstArgument + "";
	}

	@Override
	public void prepareArgument() {

	}

	@Override
	public OperationErrors validateArgument() {
		return OperationErrors.NO_ERROR;
	}
}
