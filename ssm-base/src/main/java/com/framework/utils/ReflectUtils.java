package com.framework.utils;

import java.lang.reflect.Method;

public class ReflectUtils {

	@SuppressWarnings("rawtypes")
	public static Method getMethod(Object obj, String methodName, Class...clz){
    	try {
			return obj.getClass().getMethod(methodName,clz);
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	return null;
    }
    
	public static Object invokeMethod(Method method ,Object obj, Object...params){
    	try {
			return method.invoke(obj, params);
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	return null;
    }
	
	@SuppressWarnings("rawtypes")
	public static Object execMethod(Object obj, String methodName, Class paramTypes[], Object params[]){
    	try {
    		Method method = getMethod(obj, methodName, paramTypes);
			return method.invoke(obj, params);
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	return null;
    }
	
	@SuppressWarnings("rawtypes")
	public static Class[] getInterfaces(Object obj){
		return obj.getClass().getInterfaces();
	}
}
