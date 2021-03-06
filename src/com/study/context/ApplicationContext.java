package com.study.context;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.reflections.Reflections;

import com.study.annotation.Component;

public class ApplicationContext {
	Hashtable<String, Object> objTbl = new Hashtable<String, Object>();
	
	public Object getBean(String key) {
		return objTbl.get(key);
	}
	
	public void addBean(String name, Object obj) {
		objTbl.put(name, obj);
	}
	
//	private void prepareAnnotationObjs() throws InstantiationException, IllegalAccessException {
//		// TODO Auto-generated method stub
//		Reflections reflector = new Reflections("");
//		
//		Set<Class<?>> list = reflector.getTypesAnnotatedWith(Component.class);
//		String key = null;
//		for(Class<?> clazz : list) {
//			key = clazz.getAnnotation(Component.class).value();
//			objTbl.put(key, clazz.newInstance());
//		}
//	}
	
	public void prepareObjectsByAnnotation(String basePkg) throws Exception{
		Reflections reflector = new Reflections(basePkg);
		
		Set<Class<?>> list = reflector.getTypesAnnotatedWith(Component.class);
		String key = null;
		for(Class<?> clazz : list) {
			key = clazz.getAnnotation(Component.class).value();
			objTbl.put(key, clazz.getDeclaredConstructor().newInstance());
		}
	}

	public void prepareObjectsByProps(String propertiesPath) throws Exception {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.load(new FileReader(propertiesPath));
		
		Context ctx = new InitialContext();
		String key = null;
		String value = null;
		for(Object item : props.keySet()) {
			key = (String) item;
			value = props.getProperty(key);
			if(key.startsWith("jndi.")) {
				objTbl.put(key, ctx.lookup(value));
			}else {
				objTbl.put(key, Class.forName(value).getDeclaredConstructor().newInstance());
			}
		}
	}

	public void injectDependency() throws Exception{
		// TODO Auto-generated method stub
		for(String key : objTbl.keySet()) {
			if(!key.startsWith("jndi.")) {
				callSetter(objTbl.get(key));
			}
		}
	}

	private void callSetter(Object obj) throws Exception {
		// TODO Auto-generated method stub
		Object dependency = null;
		for(Method m : obj.getClass().getMethods()) {
			if(m.getName().startsWith("set")) {
				dependency = findObjectByType(m.getParameterTypes()[0]);
				if(dependency != null) {
					m.invoke(obj, dependency);
				}
			}
		}
	}

	private Object findObjectByType(Class<?> type) {
		// TODO Auto-generated method stub
		for(Object obj : objTbl.values()) {
			if(type.isInstance(obj)) {
				return obj;
			}
		}
		return null;
	}
}
