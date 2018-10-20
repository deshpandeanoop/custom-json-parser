package com.explore.custom.json.parser.ireader;

import com.explore.custom.json.parser.exception.ResourceLoaderException;

public interface IResourceLoader<T> {
	public T getDataFromResource() throws ResourceLoaderException;
}
