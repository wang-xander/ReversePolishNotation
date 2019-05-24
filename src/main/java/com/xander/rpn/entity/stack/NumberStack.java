package com.xander.rpn.entity.stack;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.Stack;

public class NumberStack {
	public static MathContext DISPLAY_MATH_CONTECT = new MathContext(10, RoundingMode.HALF_UP);

	private Stack<BigDecimal> stack = new Stack<BigDecimal>();

	public synchronized void pushNumber(BigDecimal argument) {
		this.stack.push(argument);
	}

	public synchronized BigDecimal popNumber() {
		if (this.stack.empty()) {
			return null;
		}
		return this.stack.pop();
	}

	public synchronized BigDecimal getFirst() {
		if (this.stack.size() < 1) {
			return null;
		}
		return this.stack.get(this.stack.size() - 1);
	}

	public synchronized BigDecimal getSecond() {
		if (this.stack.size() < 2) {
			return null;
		}
		return this.stack.get(this.stack.size() - 2);
	}

	public synchronized BigDecimal[] clear() {
		BigDecimal[] trash = new BigDecimal[this.stack.size()];
		this.stack.copyInto(trash);
		this.stack.clear();
		return trash;
	}

	public synchronized void print() {
		System.out.print("stack: ");
		Iterator<BigDecimal> it = this.stack.iterator();
		while (it.hasNext()) {
			BigDecimal next = it.next();
			BigDecimal newNext = new BigDecimal(next.toString(), DISPLAY_MATH_CONTECT);
			System.out.print(newNext.toString() + " ");
		}
		System.out.println();
	}
}
