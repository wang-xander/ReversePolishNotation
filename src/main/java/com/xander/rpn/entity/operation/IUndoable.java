package com.xander.rpn.entity.operation;

import com.xander.rpn.entity.stack.HistoryStack;

public interface IUndoable {
	public void saveHistory();

	public void undo();

	public static HistoryStack historyStack = new HistoryStack();

}
