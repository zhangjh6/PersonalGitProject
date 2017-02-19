package com.jerry.frame.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;

import com.jerry.frame.exception.BusinessException;

public class AnnotationValidateUtil {
	
	public static void validate (Object instance) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, InstantiationException{
		try{
		Class clazz = instance.getClass();
		ValidateAnnotationInterface validateAnnotationInterface = (ValidateAnnotationInterface) clazz.getAnnotation(ValidateAnnotationInterface.class);
		Class<?> validateClazz = Class.forName(validateAnnotationInterface.validateClass());
		Field[] fields = clazz.getDeclaredFields();
		for(Field field:fields){
			Annotation[]annotations= field.getAnnotations();
			for(Annotation annotation:annotations){
				if(annotation instanceof NullCheck){
					NullCheck nullCheck =	(NullCheck)annotation ;
					Method method = validateClazz.getDeclaredMethod(nullCheck.checkMethod(), new Class[]{Object.class});
					if(method!=null){
						method.invoke(validateClazz.newInstance(), instance);
					}
					
				}
				
			}
		}
		}catch(Exception e ){
			
			Throwable throwable = e.getCause();
			if(throwable!=null&&throwable.getClass().equals(BusinessException.class) ){
				throw (BusinessException)throwable;
			}else{
				if(throwable!=null){
				throw new BusinessException("系统异常", throwable);
				}else{
				throw new BusinessException("系统异常", e);
				}
			}
			
		}
	}

}
