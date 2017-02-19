package com.jerry.frame.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

/**
 * 对象复制工具类
 * 
 * @author ZhangJunyong
 *
 */
public class ObjectCopyUtil {
	
	public static final Logger log = Logger.getLogger(ObjectCopyUtil.class);

	/**
	 * 复制整个对象的属性值到另外一个对象的对应的同名和同类型的属性，但名为sguid的属性不拷贝
	 * 
	 * @param vo
	 *            <Object> 源值对象
	 * @param target
	 *            <Object> 目标对象
	 * @param not_copy
	 *            <String> 用于指定不拷贝值的属性，可传多个属性名，之间用逗号隔开
	 * @param isCopyNull
	 *            <boolean> 是否拷贝NULL值
	 * @return void
	 */
	public static void copyObjValue(Object vo, Object target, String not_copy,
			boolean isCopyNull) {
	    ///如果原值为空，那么直接放回；
	    if(vo == null){
	        log.info("对象复制，入参为空");
	        return;
	    }
	    
		@SuppressWarnings("rawtypes")
		Class cls = vo.getClass();
		if(StringUtils.isEmpty(not_copy)){
		    not_copy = "serialVersionUID";
		} else {
		    not_copy = not_copy + ",serialVersionUID";
		}
		
		while (!cls.getName().equals("java.lang.Object")) {
			copyObjectValue(vo, target, cls, not_copy, isCopyNull);
			cls = cls.getSuperclass();
		}
	}

	@SuppressWarnings("rawtypes")
	private static void copyObjectValue(Object vo, Object target, Class cls,
			String not_copy, boolean isCopyNull) {
		int flag = 0;
		if (StringUtils.isNotBlank(not_copy)) {
			not_copy = "," + not_copy + ",";// 前后加逗号是为了后面能够准确的判断所包含的属性名称
		}

		try {
			String sname = "";
			Field[] fields = cls.getDeclaredFields();

			for (int i = 0; i < fields.length; i++) {
				sname = fields[i].getName();

				// 如果属性名存在于not_copy指的属性名范围中，则不拷贝访属性值
				if ((StringUtils.isNotBlank(not_copy) && not_copy.indexOf(","
						+ sname + ",") != -1))
					continue;
				///检查vo 是否有该属性的  PropertyDescriptor ;如果没有，或者读取方法为空，那么则继续；
				PropertyDescriptor descriptor = PropertyUtils.getPropertyDescriptor(vo, sname);
				if(descriptor == null || descriptor.getReadMethod() == null){
				    continue;
				}
				//BeanUtils.
				if ((fields[i].getType().toString().startsWith("class") || fields[i].getType().toString().startsWith("interface"))
						&& !fields[i].getType().getName().equals("java.lang.String")) { // 对象类型字段值拷贝
					try {
					    Object obj= BeanUtils.getProperty(vo, sname);
						if (isCopyNull == false && obj == null) {
							continue;
						}else if(null!=obj){
						    BeanUtils.setProperty(target, sname, MethodUtils
                                    .invokeMethod(vo, "get"
                                            + sname.substring(0, 1)
                                                    .toUpperCase()
                                            + sname.substring(1), null));
						}
					} catch (Exception ne) {
					    log.error(ne.getMessage(),ne);
						flag = 1;
						continue;
					}
				} else { // 基本类型字段值拷贝
					try {
						if (isCopyNull == false
								&& BeanUtils.getProperty(vo, sname) == null) {
							continue;
						} else {
							BeanUtils.setProperty(target, sname,
									BeanUtils.getProperty(vo, sname));
						}
					} catch (Exception ne) {
					    log.error(ne.getMessage(),ne);
						flag = 1;
						continue;
					}
				}
			}
		} catch (Exception e) {
			flag = 1;
			log.error(e.getMessage(),e);
		}

		if (flag == 1) {
			flag = 0;

		}
	}

}
