package com.study.bind;

import java.lang.reflect.Method;
import java.sql.Date;
import java.util.Set;

import javax.servlet.ServletRequest;

public class ServletRequestDataBinder {
	public static Object bind(ServletRequest request, Class<?> dataType, String dataName) throws Exception{
		if(isPrimitiveType(dataType)) {
			return createValueObject(dataType, request.getParameter(dataName));
		}
		
		Set<String> paramNames = request.getParameterMap().keySet();
		Object dataObject = dataType.getDeclaredConstructor().newInstance();
		Method m = null;
		
		for(String paramName : paramNames) {
			m = findSetter(dataType, paramName);
			if(m!=null) {
				m.invoke(dataObject, createValueObject(m.getParameterTypes()[0],request.getParameter(paramName)));
			}
		}
		return dataObject;
	}


	


	private static boolean isPrimitiveType(Class<?> type) {
		// TODO Auto-generated method stub
		if(type.getName().equals("int") || type == Integer.class ||
		   type.getName().equals("long") || type == Long.class ||
		   type.getName().equals("float") || type == Float.class ||
		   type.getName().equals("double") || type == Double.class ||
		   type.getName().equals("boolean") || type == Boolean.class ||
		   type == Date.class || type == String.class) {
		   return true;
		}else {
			return false;	
		}
		
	}
	
	private static Object createValueObject(Class<?> dType, String val) {
		// TODO Auto-generated method stub
		String type = dType.getName();

		if(type.equals("int") || dType == Integer.class) {
			return Integer.valueOf(val);
			//return new Integer(val);
		} else if(type.equals("float") || dType == Float.class) {
			return Float.valueOf(val);
			//return new Float(val);
		} else if(type.equals("double") || dType == Double.class) {
			return Double.valueOf(val);
			//return new Double(val);
		} else if(type.equals("long") || dType == Long.class) {
			return Long.valueOf(val);
			//return new Long(val);
		} else if(type.equals("boolean") || dType == Boolean.class) {
			return Boolean.valueOf(val);
			//return new Boolean(val);
		} else if(dType == Date.class) {
			return Date.valueOf(val);
		}else {
			return val;
		}
	}
	
	private static Method findSetter(Class<?> type, String name) {
		// TODO Auto-generated method stub
		Method[] methods = type.getMethods();
		
		String propName = null;
		for(Method m : methods) {
			if(!m.getName().startsWith("set")) continue;
			propName = m.getName().substring(3);
			if(propName.toLowerCase().equals(name.toLowerCase())) {
				return m;
			}
		}
		return null;
	}
}
