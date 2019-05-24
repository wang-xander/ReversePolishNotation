package com.xander.rpn.entity.operation.impl;

import com.xander.rpn.common.SymbolConstants;
import com.xander.rpn.entity.operation.AbstractNonnumericOperation;
import com.xander.rpn.entity.operation.IUndoable;
import com.xander.rpn.entity.stack.NumberStack;

import java.math.BigDecimal;
import java.util.Stack;

public class ClearanceOperation extends AbstractNonnumericOperation implements IUndoable {
	private Stack<BigDecimal> trashStack = new Stack<BigDecimal>();

	@Override
	public void process() {
		BigDecimal[] trash = this.numberStack.clear();
		for (BigDecimal e : trash) {
			trashStack.push(e);
		}
		this.saveHistory();
	}

	@Override
	public String getSymbol() {
		return SymbolConstants.CLEAR;
	}

	@Override
	public void saveHistory() {
		historyStack.pushOperation(this);
	}

	@Override
	public void undo() {
		this.numberStack.clear();
		BigDecimal[] history = new BigDecimal[this.trashStack.size()];
		trashStack.copyInto(history);

		for (BigDecimal h : history) {
			this.numberStack.pushNumber(h);
		}
	}
}
