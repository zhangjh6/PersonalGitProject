package com.jerry.frame.util;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import com.jerry.frame.exception.BusinessException;

public class ExceptionValidateUtil {

	public static void validateNullVal(Class clazz,Object o ,String... waitValidateFields) {
		Logger logger = Logger.getLogger(clazz);
		String errorStr = buildNullValStr(clazz, o,waitValidateFields);
		if (errorStr != null) {
			logger.error("入参" + clazz.getName() + "," + errorStr);
          throw new BusinessException("入参" + clazz.getName() + "," + errorStr, null);
		}
	}

	public static String buildNullValStr(Class clazz, Object o,String... waitValidateFields ) {
		Logger logger = Logger.getLogger(clazz);
		String errorStr = "校验的入参属性：";
		String errorField = "";
		for (String field : waitValidateFields) {
			String methodName = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
			try {
				Method method = clazz.getDeclaredMethod(methodName, null);

				Object object = method.invoke(o, null);
				if (object == null) {
					errorField += field + "，";
				}
			} catch (Exception e) {
				logger.error("Field ：" + field + " 没有指定的getter方法！");

			}

		}
		if (errorField.length() == 0) {

			return null;
		} else {

			errorStr += errorField + "为空！";
			return errorStr;
		}
	}

}
