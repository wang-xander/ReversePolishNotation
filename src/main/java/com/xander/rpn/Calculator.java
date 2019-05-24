package com.xander.rpn;

import com.xander.rpn.common.OperationErrors;
import com.xander.rpn.entity.operation.AbstractStackedOperation;
import com.xander.rpn.entity.stack.NumberStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Calculator {
	public Calculator() {
	}

	public void printResult() {
		AbstractStackedOperation.getNumberStack().print();
	}

	public void doCalculation(String input) {
		String executedInput = "";
		StringTokenizer tokenizer = new StringTokenizer(input, " ");
		String next = "";
		AbstractStackedOperation operation = null;
		while (tokenizer.hasMoreTokens()) {
			next = tokenizer.nextToken();
			operation = AbstractStackedOperation.getOperation(next);
			OperationErrors error = operation.doOperation();
			if (!OperationErrors.NO_ERROR.equals(error)) {
				System.out.println("operator " + next + "(position: " + (executedInput.length() + 1) + "):" + error.getValue());
			}
			executedInput = executedInput + next + " ";
		}
	}

	public static void main(String[] a) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Calculator calculator = new Calculator();
			String str = null;
			while (true) {
//				System.out.println("Enter your RPN:");
				str = br.readLine();
				calculator.doCalculation(str);
				calculator.printResult();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
