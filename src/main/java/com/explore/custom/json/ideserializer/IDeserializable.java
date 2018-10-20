package com.explore.custom.json.ideserializer;

import java.util.List;

import com.explore.custom.json.parser.exception.DeSerializeException;

public interface IDeserializable <T> {
List<T> getDeserializedObjects() throws DeSerializeException;
}
