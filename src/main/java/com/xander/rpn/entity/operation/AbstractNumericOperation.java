package com.xander.rpn.entity.operation;

import com.xander.rpn.common.OperationErrors;
import com.xander.rpn.entity.stack.HistoryStack;
import com.xander.rpn.entity.stack.NumberStack;

import java.math.BigDecimal;

public abstract class AbstractNumericOperation extends AbstractStackedOperation implements INumeric, IUndoable {
	public AbstractNumericOperation() {
		super();
	}

	protected BigDecimal result;

	protected BigDecimal firstArgument;

	public static HistoryStack getHistoryStack() {
		return historyStack;
	}

	@Override
	public OperationErrors doOperation() {
		OperationErrors error = this.validateArgument();
		if (!OperationErrors.NO_ERROR.equals((error))) {
			return error;
		}
		this.prepareArgument();
		this.process();
		this.storeResult();
		this.saveHistory();
		return error;
	}

	@Override
	public void storeResult() {
		this.numberStack.pushNumber(result);
	}

	@Override
	public void saveHistory() {
		historyStack.pushOperation(this);
	}

	@Override
	public void undo() {
		this.restoreArgumentsToStack();
	}

	abstract protected void restoreArgumentsToStack();
}
