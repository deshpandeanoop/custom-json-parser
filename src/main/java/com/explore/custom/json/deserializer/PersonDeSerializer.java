package com.explore.custom.json.deserializer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.explore.custom.json.annotation.JSONField;
import com.explore.custom.json.ideserializer.IDeserializable;
import com.explore.custom.json.iparser.IJSONParser;
import com.explore.custom.json.parser.data.Person;
import com.explore.custom.json.parser.exception.AnnotationProccessorException;
import com.explore.custom.json.parser.exception.DeSerializeException;
import com.explore.custom.json.parser.exception.ResourceLoaderException;
import com.explore.custom.json.parser.ireader.IResourceLoader;
import com.explore.custom.json.parser.reader.JSONFileLoader;
import com.explore.custom.json.util.ApplicationConstants;

public class PersonDeSerializer implements IDeserializable<Person> {
	private IResourceLoader<JSONArray> jsonResourceLoader = new JSONFileLoader(ApplicationConstants.JSON_RESOURCE_FILE);

	@Override
	public List<Person> getDeserializedObjects() throws DeSerializeException {
		try {
			JSONArray personJSONArray = jsonResourceLoader.getDataFromResource();
			if (null == personJSONArray || personJSONArray.size() < 1) {
				return null;
			}
			List<Person> persons = new ArrayList<>();
			IJSONParser<Person> personJSONParser = json -> parserJSON(json);
			for (Object obj : personJSONArray) {
				JSONObject json = (JSONObject) obj;
				persons.add(personJSONParser.parseJSON(json));
			}
			return persons;
		} catch (ResourceLoaderException resourceLoaderException) {
			throw new DeSerializeException(resourceLoaderException.getMessage(), resourceLoaderException);
		} catch (AnnotationProccessorException annotationProccessorException) {
			throw new DeSerializeException(annotationProccessorException.getMessage(), annotationProccessorException);
		}
	}

	@SuppressWarnings("rawtypes")
	private Person parserJSON(JSONObject json) throws AnnotationProccessorException {
		try {
			Person person = new Person();
			Class personClass = person.getClass();
			Field[] fields = personClass.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				JSONField jsonAnnotation = field.getAnnotation(JSONField.class);
				field.set(person, json.get(jsonAnnotation.key()));
			}
			return person;
		} catch (IllegalAccessException illegalAccessException) {
			throw new AnnotationProccessorException(illegalAccessException.getMessage(), illegalAccessException);
		}
	}
}
