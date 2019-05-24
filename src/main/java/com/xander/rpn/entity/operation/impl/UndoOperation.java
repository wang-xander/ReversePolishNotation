package com.xander.rpn.entity.operation.impl;

import com.xander.rpn.common.SymbolConstants;
import com.xander.rpn.entity.operation.AbstractNonnumericOperation;
import com.xander.rpn.entity.operation.IOperation;
import com.xander.rpn.entity.operation.IUndoable;
import com.xander.rpn.entity.stack.HistoryStack;
import com.xander.rpn.entity.stack.NumberStack;

import java.math.BigDecimal;

public class UndoOperation extends AbstractNonnumericOperation {
	private HistoryStack historyStack;
	public UndoOperation(HistoryStack historyStack) {
		super();
		this.historyStack = historyStack;
	}

	@Override
	public void process() {
		IUndoable operation = this.historyStack.popOperation();
		operation.undo();
	}

	@Override
	public String getSymbol() {
		return SymbolConstants.UNDO;
	}
}
