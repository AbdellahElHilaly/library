package org.example.app.shared.Helper.print;

import java.lang.reflect.Field;

public class ObjectHelper {
    public static <T> String[] getModelHeader(T model) {
        Class<?> clazz = model.getClass();
        Field[] fields = clazz.getDeclaredFields();
        String[] headers = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            headers[i] = fields[i].getName();
        }
        return headers;
    }

    public static <T> String[] getModelBody(T model) {
        Class<?> clazz = model.getClass();
        Field[] fields = clazz.getDeclaredFields();
        String[] body = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                Object value = fields[i].get(model);
                body[i] = value != null ? value.toString() : "null";
            } catch (IllegalAccessException e) {
                body[i] = "N/A";
            }
        }
        return body;
    }
}
