package efs.thesis.common.util;

import efs.thesis.common.db.model.Model;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */

public class ClassUtil {

	public static final String PACKAGE_NAME = "efs.thesis.saas.model";
	
	@SuppressWarnings("unchecked")
	public static Class<? extends Model> toClass(String type) throws ClassNotFoundException{
		return (Class<? extends Model>) Class.forName(PACKAGE_NAME + "." + WordUtil.toTitleCase(type));
	}
	
	public static boolean isFieldType(String fieldName, Class expectedType, Class source){
		boolean result = true;
		try {
			result = source.getDeclaredField(fieldName).getType().isAssignableFrom(expectedType);
		} catch (NoSuchFieldException e) {
			result = false;
		} catch (SecurityException e) {
			result = false;
		}
		return result;
	}
	
	public static boolean containsField(String field, Class<?> clazz) {
		boolean result = true;
		try{
			clazz.getDeclaredField(field);
		}catch (NoSuchFieldException e) {
			result = false;
		}catch (SecurityException e) {
			result = false;
		}
		return result;
	}
	
	public static String constructGetter(String name){
		return "get" + WordUtil.toTitleCase(name);
	}
	
	public static String constructSetter(String name){
		return "set" + WordUtil.toTitleCase(name);
	}
}
