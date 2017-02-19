package com.jerry.frame.annotation;

import java.lang.reflect.InvocationTargetException;

public  class TestAnnotation {

	
	
	public static void main(String []args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, InstantiationException{
		
		AnnotationTest annotationTest = new AnnotationTest();
		
		AnnotationValidateUtil.validate(annotationTest);
	}
	
	
}
