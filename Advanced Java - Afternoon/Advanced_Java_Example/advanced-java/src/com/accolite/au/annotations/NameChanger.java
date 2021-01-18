package com.accolite.au.annotations;

import java.lang.reflect.Field;

public class NameChanger {

	public static String changeNames(Object obj) throws IllegalArgumentException, IllegalAccessException {
		Class<?> objClass = obj.getClass();
		StringBuilder stringBuilder = new StringBuilder();
		for (Field field : objClass.getDeclaredFields()) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(DefaultVal.class)) {
				DefaultVal annotation = field.getAnnotation(DefaultVal.class);
				stringBuilder.append(annotation.changedName()).append(": ")
				.append(field.get(obj)).append("  ");
			}
		}
		return stringBuilder.toString();
	}
}
