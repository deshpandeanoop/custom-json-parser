package com.explore.custom.json.parser.exception;

@SuppressWarnings("serial")
public class AnnotationProccessorException extends Exception {
	public AnnotationProccessorException(String message) {
		super(message);
	}

	public AnnotationProccessorException(String message, Exception exception) {
		super(message, exception);
	}
}
