package com.xander.rpn.entity.operation.impl;

import com.xander.rpn.common.InvalidArgumentException;
import com.xander.rpn.common.OperationErrors;
import com.xander.rpn.common.SymbolConstants;
import com.xander.rpn.entity.operation.AbstractNonnumericOperation;

public class ErrorOperation extends AbstractNonnumericOperation {
	@Override
	public void process() {
	}

	@Override
	public OperationErrors doOperation() {
		return OperationErrors.ILLEGAL_PARAMETERS;
	}

	@Override
	public String getSymbol() {
		return "Error";
	}

}
