package com.explore.custom.json.parser.exception;

@SuppressWarnings("serial")
public class ResourceLoaderException extends Exception {
	public ResourceLoaderException(String message) {
		super(message);
	}

	public ResourceLoaderException(String message, Exception exception) {
		super(message, exception);
	}
	
}
