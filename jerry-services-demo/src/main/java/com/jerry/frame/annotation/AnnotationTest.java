package com.jerry.frame.annotation;

@ValidateAnnotationInterface(validateClass = "com.jerry.frame.annotation.ValidateInstance1")
public class AnnotationTest {
	@NullCheck(value = true, checkMethod = "checkNull")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	

}