package com.xander.rpn.common;

public enum OperationErrors {
	NO_ERROR(""),
	INSUCIENT_PARAMETERS("insucient parameters"),
	ILLEGAL_PARAMETERS("illegal error"),
	DIVISION_BY_ZERO("division by zero");

	private String value;

	private OperationErrors(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
