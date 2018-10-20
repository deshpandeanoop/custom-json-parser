package com.explore.custom.json.parser.data;

import com.explore.custom.json.annotation.JSONField;


public class Person {
@JSONField(key="personId")
private long id;
@JSONField(key="personName")
private String name;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
