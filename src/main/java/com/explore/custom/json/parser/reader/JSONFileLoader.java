package com.explore.custom.json.parser.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.explore.custom.json.parser.exception.ResourceLoaderException;
import com.explore.custom.json.parser.ireader.IResourceLoader;

public class JSONFileLoader implements IResourceLoader<JSONArray> {
	/* Fully classified name of the resource */
	private String resource;

	public JSONFileLoader(String resource) {
		this.resource = resource;
	}

	@Override
	public JSONArray getDataFromResource() throws ResourceLoaderException {
		try {
			return parseJSON();
		} catch (ResourceLoaderException resourceLoaderException) {
			throw resourceLoaderException;
		}
	}

	private JSONArray parseJSON() throws ResourceLoaderException {
		try {
			JSONParser jsonParser = new JSONParser();
			return (JSONArray) jsonParser.parse(new FileReader(new File(resource)));
		} catch (FileNotFoundException fileNotFoundException) {
			throw new ResourceLoaderException(fileNotFoundException.getMessage(), fileNotFoundException);
		} catch (IOException ioException) {
			throw new ResourceLoaderException(ioException.getMessage(), ioException);
		} catch (ParseException parseException) {
			throw new ResourceLoaderException(parseException.getMessage(), parseException);
		}
	}
}
