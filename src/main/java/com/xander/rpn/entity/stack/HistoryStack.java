package com.xander.rpn.entity.stack;

import com.xander.rpn.entity.operation.IUndoable;

import java.util.Stack;

public class HistoryStack {
	private Stack<IUndoable> stack;

	public HistoryStack() {
		this.stack = new Stack<IUndoable>();
	}

	public synchronized void pushOperation(IUndoable operation) {
		this.stack.push(operation);
	}

	public synchronized IUndoable popOperation() {
		return this.stack.pop();
	}
}
