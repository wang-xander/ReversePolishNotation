package com.xander.rpn.entity.operation;

import com.xander.rpn.common.OperationErrors;
import com.xander.rpn.entity.stack.NumberStack;

public abstract class AbstractNonnumericOperation extends AbstractStackedOperation {
	public AbstractNonnumericOperation() {
		super();
	}

	@Override
	public OperationErrors doOperation() {
		this.process();
		return OperationErrors.NO_ERROR;
	}

	@Override
	public OperationErrors validateArgument() {
		return OperationErrors.NO_ERROR;
	}
}
