package com.explore.custom.json.iparser;

import org.json.simple.JSONObject;

import com.explore.custom.json.parser.exception.AnnotationProccessorException;

@FunctionalInterface
public interface IJSONParser<T> {
	public T parseJSON(JSONObject json) throws AnnotationProccessorException;
}
