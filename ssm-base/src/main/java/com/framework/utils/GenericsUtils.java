package com.framework.utils;

import java.lang.reflect.Field;  
import java.lang.reflect.Method;  
import java.lang.reflect.ParameterizedType;  
import java.lang.reflect.Type;  
import java.util.ArrayList;  
import java.util.List;  
  
/** 
 * ���͹����� 
 *  
 * @author <a href="http://www.blogjava.net/lishunli/" 
 *         target="_jeecg">ShunLi</a> 
 * @notes Created on 2010-1-21<br> 
 *        Revision of last commit:$Revision: 1.1 $<br> 
 *        Author of last commit:$Author: ghp $<br> 
 *        Date of last commit:$Date: 2010-01-25 16:48:17 +0800 (��һ, 25 һ�� 2010) 
 *        $<br> 
 *        <p> 
 */  
@SuppressWarnings("rawtypes")
public class GenericsUtils {  
    /** 
     * ͨ������,���ָ����ĸ���ķ��Ͳ�����ʵ������. ��BuyerServiceBean extends DaoSupport<Buyer> 
     *  
     * @param clazz 
     *            clazz ��Ҫ�������,�������̳з��͸��� 
     * @param index 
     *            ���Ͳ�����������,��0��ʼ. 
     * @return ���Ͳ�����ʵ������, ���û��ʵ��ParameterizedType�ӿڣ�����֧�ַ��ͣ�����ֱ�ӷ��� 
     *         <code>Object.class</code> 
     */  
    public static Class getSuperClassGenricType(Class clazz, int index) {  
        Type genType = clazz.getGenericSuperclass();// �õ����͸���  
        // ���û��ʵ��ParameterizedType�ӿڣ�����֧�ַ��ͣ�ֱ�ӷ���Object.class  
        if (!(genType instanceof ParameterizedType)) {  
            return Object.class;  
        }  
        // ���ر�ʾ������ʵ�����Ͳ�����Type���������,������ŵĶ��Ƕ�Ӧ���͵�Class, ��BuyerServiceBean extends  
        // DaoSupport<Buyer,Contact>�ͷ���Buyer��Contact����  
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
        if (index >= params.length || index < 0) {  
            throw new RuntimeException("�����������" + (index < 0 ? "����С��0" : "�����˲���������"));  
        }  
        if (!(params[index] instanceof Class)) {  
            return Object.class;  
        }  
        return (Class) params[index];  
    } 
    
    public static Object getSuperClassGenricInstance(Class clazz, int index) {  
    	Class c = getSuperClassGenricType(clazz,index);
        try {
			return c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
        
        return null;
    } 
  
    /** 
     * ͨ������,���ָ����ĸ���ĵ�һ�����Ͳ�����ʵ������. ��BuyerServiceBean extends DaoSupport<Buyer> 
     *  
     * @param clazz 
     *            clazz ��Ҫ�������,�������̳з��͸��� 
     * @return ���Ͳ�����ʵ������, ���û��ʵ��ParameterizedType�ӿڣ�����֧�ַ��ͣ�����ֱ�ӷ��� 
     *         <code>Object.class</code> 
     */  
    public static Class getSuperClassGenricType(Class clazz) {  
        return getSuperClassGenricType(clazz, 0);  
    }  
  
    /** 
     * ͨ������,��÷�������ֵ���Ͳ�����ʵ������. ��: public Map<String, Buyer> getNames(){} 
     *  
     * @param Method 
     *            method ���� 
     * @param int index ���Ͳ�����������,��0��ʼ. 
     * @return ���Ͳ�����ʵ������, ���û��ʵ��ParameterizedType�ӿڣ�����֧�ַ��ͣ�����ֱ�ӷ��� 
     *         <code>Object.class</code> 
     */  
    public static Class getMethodGenericReturnType(Method method, int index) {  
        Type returnType = method.getGenericReturnType();  
        if (returnType instanceof ParameterizedType) {  
            ParameterizedType type = (ParameterizedType) returnType;  
            Type[] typeArguments = type.getActualTypeArguments();  
            if (index >= typeArguments.length || index < 0) {  
                throw new RuntimeException("�����������" + (index < 0 ? "����С��0" : "�����˲���������"));  
            }  
            return (Class) typeArguments[index];  
        }  
        return Object.class;  
    }  
  
    /** 
     * ͨ������,��÷�������ֵ��һ�����Ͳ�����ʵ������. ��: public Map<String, Buyer> getNames(){} 
     *  
     * @param Method 
     *            method ���� 
     * @return ���Ͳ�����ʵ������, ���û��ʵ��ParameterizedType�ӿڣ�����֧�ַ��ͣ�����ֱ�ӷ��� 
     *         <code>Object.class</code> 
     */  
    public static Class getMethodGenericReturnType(Method method) {  
        return getMethodGenericReturnType(method, 0);  
    }  
  
    /** 
     * ͨ������,��÷������������index��������������з��Ͳ�����ʵ������. ��: public void add(Map<String, 
     * Buyer> maps, List<String> names){} 
     *  
     * @param Method 
     *            method ���� 
     * @param int index �ڼ���������� 
     * @return ��������ķ��Ͳ�����ʵ�����ͼ���, ���û��ʵ��ParameterizedType�ӿڣ�����֧�ַ��ͣ�����ֱ�ӷ��ؿռ��� 
     */  
    public static List<Class> getMethodGenericParameterTypes(Method method, int index) {  
        List<Class> results = new ArrayList<Class>();  
        Type[] genericParameterTypes = method.getGenericParameterTypes();  
        if (index >= genericParameterTypes.length || index < 0) {  
            throw new RuntimeException("�����������" + (index < 0 ? "����С��0" : "�����˲���������"));  
        }  
        Type genericParameterType = genericParameterTypes[index];  
        if (genericParameterType instanceof ParameterizedType) {  
            ParameterizedType aType = (ParameterizedType) genericParameterType;  
            Type[] parameterArgTypes = aType.getActualTypeArguments();  
            for (Type parameterArgType : parameterArgTypes) {  
                Class parameterArgClass = (Class) parameterArgType;  
                results.add(parameterArgClass);  
            }  
            return results;  
        }  
        return results;  
    }  
  
    /** 
     * ͨ������,��÷������������һ��������������з��Ͳ�����ʵ������. ��: public void add(Map<String, Buyer> 
     * maps, List<String> names){} 
     *  
     * @param Method 
     *            method ���� 
     * @return ��������ķ��Ͳ�����ʵ�����ͼ���, ���û��ʵ��ParameterizedType�ӿڣ�����֧�ַ��ͣ�����ֱ�ӷ��ؿռ��� 
     */  
    public static List<Class> getMethodGenericParameterTypes(Method method) {  
        return getMethodGenericParameterTypes(method, 0);  
    }  
  
    /** 
     * ͨ������,���Field���Ͳ�����ʵ������. ��: public Map<String, Buyer> names; 
     *  
     * @param Field 
     *            field �ֶ� 
     * @param int index ���Ͳ�����������,��0��ʼ. 
     * @return ���Ͳ�����ʵ������, ���û��ʵ��ParameterizedType�ӿڣ�����֧�ַ��ͣ�����ֱ�ӷ��� 
     *         <code>Object.class</code> 
     */  
    public static Class getFieldGenericType(Field field, int index) {  
        Type genericFieldType = field.getGenericType();  
  
        if (genericFieldType instanceof ParameterizedType) {  
            ParameterizedType aType = (ParameterizedType) genericFieldType;  
            Type[] fieldArgTypes = aType.getActualTypeArguments();  
            if (index >= fieldArgTypes.length || index < 0) {  
                throw new RuntimeException("�����������" + (index < 0 ? "����С��0" : "�����˲���������"));  
            }  
            return (Class) fieldArgTypes[index];  
        }  
        return Object.class;  
    }  
  
    /** 
     * ͨ������,���Field���Ͳ�����ʵ������. ��: public Map<String, Buyer> names; 
     *  
     * @param Field 
     *            field �ֶ� 
     * @param int index ���Ͳ�����������,��0��ʼ. 
     * @return ���Ͳ�����ʵ������, ���û��ʵ��ParameterizedType�ӿڣ�����֧�ַ��ͣ�����ֱ�ӷ��� 
     *         <code>Object.class</code> 
     */  
    public static Class getFieldGenericType(Field field) {  
        return getFieldGenericType(field, 0);  
    } 
    
	/** 
	 * ����ʵ��õ�ʵ����������� 
	 * @param objClass 
	 * @return 
	 * @throws ClassNotFoundException 
	 */  
    public static String[] getColumnNames(String objClass) throws ClassNotFoundException {  
        String[] wageStrArray = null;  
        if (objClass != null) {  
            Class class1 = Class.forName(objClass);  
            Field[] field = class1.getDeclaredFields();// ������ǻ��ʵ��Bean���������Եķ���  
            StringBuffer sb = new StringBuffer();  
            for (int i = 0; i < field.length; i++) {// ���ﲻ��˵��  
  
                sb.append(field[i].getName());  
  
                // ���Ƿָ�� ��Ϊ��ȥ������Ǹ�����  
  
                // ���� �����ȥ����Ǹ����� ����ӡ�����Ľ���� "id,name,"  
  
                // ȥ���Ժ��ӡ�������� "id,name"  
                if (i < field.length - 1) {  
                    sb.append(",");  
  
                }  
            }  
  
            // split(",");���Ǹ��ݶ������и��ַ���ʹ�ַ������һ������  
  
            wageStrArray = sb.toString().split(",");  
            return wageStrArray;  
        } else {  
            return wageStrArray;  
        }  
    }  
    public static Object[] field2Value(Field[] f, Object o) throws Exception {  
        Object[] value = new Object[f.length];  
        for (int i = 0; i < f.length; i++) {  
            value[i] = f[i].get(o);  
        }  
        return value;  
    }  
  
    
    /** 
     * �õ�ʵ���� 
     * @param objClass ʵ����������� 
     * @return 
     */  
	public static  Class getEntityClass(String objClass){  
         Class entityClass = null;  
        try {  
            entityClass = Class.forName(objClass);  
        } catch (ClassNotFoundException e) {              
            e.printStackTrace();  
        }   
         return entityClass;  
     }    
       
    
  
  
}