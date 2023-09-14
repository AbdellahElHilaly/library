package org.example.app.shared.Helper.print;

import java.lang.reflect.Field;
import java.util.List;

public class ObjectHelper {
    public static <T> String[] getModelHeader(T model) {
        Class<?> clazz = model.getClass();
        Field[] fields = clazz.getDeclaredFields();
        String[] headers = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            headers[i] = fields[i].getName();
            if(i==0)
                headers[i] = "index";
        }
        return headers;
    }

    public static <T> String[] getModelBody(T model , int index) {
        Class<?> clazz = model.getClass();
        Field[] fields = clazz.getDeclaredFields();
        String[] body = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                Object value = fields[i].get(model);
                body[i] = value != null ? value.toString() : "null";
                if (i==0) body[i] = String.valueOf(index);
            } catch (IllegalAccessException e) {
                body[i] = "N/A";
            }
        }
        return body;
    }

    public static <T> String[][] getModelsBody(List<T> models) {
        String[][] body = new String[models.size()][];
        for (int i = 0; i < models.size(); i++) {
            body[i] = getModelBody(models.get(i) , i + 1);
        }
        return body;
    }
}
