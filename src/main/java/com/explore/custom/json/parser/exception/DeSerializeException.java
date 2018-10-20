package com.explore.custom.json.parser.exception;

@SuppressWarnings("serial")
public class DeSerializeException extends Exception {
	public DeSerializeException(String message) {
		super(message);
	}

	public DeSerializeException(String message, Exception exception) {
		super(message, exception);
	}
}
