package com.xander.rpn.entity.operation;

import com.xander.rpn.common.InvalidArgumentException;
import com.xander.rpn.common.OperationErrors;
import com.xander.rpn.entity.stack.NumberStack;

import java.math.BigDecimal;

public abstract class AbstractTwoArgumentsOperation extends AbstractNumericOperation {

	protected BigDecimal secondArgument;

	@Override
	public void prepareArgument() {
		this.secondArgument = super.numberStack.popNumber();
		super.firstArgument = super.numberStack.popNumber();
	}

	@Override
	protected void restoreArgumentsToStack() {
		super.numberStack.popNumber();
		super.numberStack.pushNumber(this.firstArgument);
		super.numberStack.pushNumber(this.secondArgument);
	}

	@Override
	public OperationErrors validateArgument() {
		if (super.numberStack.getFirst() == null) {
			return OperationErrors.INSUCIENT_PARAMETERS;
		}
		if (super.numberStack.getSecond() == null) {
			return OperationErrors.INSUCIENT_PARAMETERS;
		}
		return OperationErrors.NO_ERROR;
	}

}
