package com.xander.rpn.entity.operation;

import com.xander.rpn.common.OperationErrors;
import com.xander.rpn.common.SymbolConstants;
import com.xander.rpn.entity.operation.impl.*;
import com.xander.rpn.entity.stack.NumberStack;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public interface IOperation {
	public OperationErrors doOperation();

	public OperationErrors validateArgument();

}
