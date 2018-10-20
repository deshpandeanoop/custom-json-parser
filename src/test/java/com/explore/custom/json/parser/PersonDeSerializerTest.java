package com.explore.custom.json.parser;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.explore.custom.json.deserializer.PersonDeSerializer;
import com.explore.custom.json.ideserializer.IDeserializable;
import com.explore.custom.json.parser.data.Person;
import com.explore.custom.json.parser.exception.DeSerializeException;

public class PersonDeSerializerTest {
	private IDeserializable<Person> personDeSerializer = new PersonDeSerializer();

	@Test
	public void test() throws DeSerializeException {
		List<Person> persons = personDeSerializer.getDeserializedObjects();
		assertEquals(6, persons.size());
	}
}
