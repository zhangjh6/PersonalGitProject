package com.jerry.frame.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;

import com.jerry.frame.exception.BusinessException;

public class ValidateInstance {

	public void checkNull(Object instance) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		Class clazz = instance.getClass();

		Field[] fields = clazz.getDeclaredFields();
		for(Field field:fields){
			NullCheck nullCheck = field.getAnnotation(NullCheck.class);
			if(nullCheck.value()){
				String filedName = field.getName();
				Method method = clazz.getMethod("get"+ StringUtils.capitalize(filedName), new Class[]{});
				Object object = method.invoke(instance, new Object[]{});
				if(object==null){
					
					throw new BusinessException(clazz.getName() +"的属性" +filedName+"不允许为空",null );
				}
			}
			
		}
		
	}
}
