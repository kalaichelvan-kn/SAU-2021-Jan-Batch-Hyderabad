package Annotations;

import java.lang.reflect.Field;

public class CapitalizeNames {
	public static String changeNames(Object obj) throws IllegalArgumentException, IllegalAccessException {
		Class<?> objClass = obj.getClass();
		StringBuilder stringBuilder = new StringBuilder();
		for (Field field : objClass.getDeclaredFields()) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(Capitalize.class)) {
				Capitalize annotation = field.getAnnotation(Capitalize.class);
				stringBuilder.append(field.get(obj).toString().toUpperCase()).append(" ");
			}
		}
		return stringBuilder.toString();
	}
}
