package com.xander.rpn.entity.operation;

import com.xander.rpn.common.SymbolConstants;
import com.xander.rpn.entity.operation.impl.*;
import com.xander.rpn.entity.stack.NumberStack;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public abstract class AbstractStackedOperation implements IOperation {
	public AbstractStackedOperation() {
	}

	protected static NumberStack numberStack = new NumberStack();

	public static NumberStack getNumberStack() {
		return numberStack;
	}

	abstract public void process();

	abstract public String getSymbol();

	public static boolean isNumeric(String argument) {
		Pattern pattern = Pattern.compile("[0-9.]*");
		return pattern.matcher(argument).matches();
	}

	public static AbstractStackedOperation getOperation(String argument) {
		if (argument == null || argument.trim().equals("")) {
			return new ErrorOperation();

		} else if (isNumeric(argument)) {
			BigDecimal numberArgument = new BigDecimal(argument);
			return new NumberStorageOperation(numberArgument);

		} else if (SymbolConstants.SQUARE.equals(argument)) {
			return new SquareOperation();

		} else if (SymbolConstants.UNDO.equals(argument)) {
			return new UndoOperation(AbstractNumericOperation.getHistoryStack());

		} else if (SymbolConstants.CLEAR.equals(argument)) {
			return new ClearanceOperation();

		} else if (SymbolConstants.PLUS.equals(argument)) {
			return new AdditionOperation();

		} else if (SymbolConstants.SUBSTRACT.equals(argument)) {
			return new SubtractionOperation();

		} else if (SymbolConstants.MUTIPLY.equals(argument)) {
			return new MultiplicationOperation();

		} else if (SymbolConstants.DIVIDE.equals(argument)) {
			return new DivisionOperation();
		}
		return new ErrorOperation();
	}
}
