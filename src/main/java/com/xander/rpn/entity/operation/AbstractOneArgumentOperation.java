package com.xander.rpn.entity.operation;

import com.xander.rpn.common.InvalidArgumentException;
import com.xander.rpn.common.OperationErrors;
import com.xander.rpn.entity.stack.NumberStack;

import java.math.BigDecimal;

public abstract class AbstractOneArgumentOperation extends AbstractNumericOperation {
	public AbstractOneArgumentOperation() {
		super();
	}

	protected BigDecimal firstArgument;
	protected BigDecimal result;

	@Override
	public void prepareArgument() {
		this.firstArgument = super.numberStack.popNumber();
	}

	@Override
	public void storeResult() {
		this.numberStack.pushNumber(result);
	}

	@Override
	protected void restoreArgumentsToStack() {
		super.numberStack.popNumber();
		super.numberStack.pushNumber(this.firstArgument);
	}

	@Override
	public OperationErrors validateArgument() {
		if(super.numberStack.getFirst() == null){
			return OperationErrors.INSUCIENT_PARAMETERS;
		}
		return OperationErrors.NO_ERROR;
	}
}
