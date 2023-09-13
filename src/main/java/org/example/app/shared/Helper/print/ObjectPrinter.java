package org.example.app.shared.Helper.print;

import java.lang.reflect.Field;
import java.util.List;

public class ObjectPrinter extends Printer {

    private static int maxSize ;

    private static void generateMawFiledSize(String header, String s) {
        maxSize = header.length();
        if (s.length() > maxSize) {
            maxSize = s.length();
        }
    }


    private static void printVCases() {
        tempColor = "cyan";
        print("|");
        printSpace(1);
    }

    private static void printHCase(String[] headers, String[] body, String cyan) {
        tempColor = cyan;
        int realSpace;
        int add = 3;
        for (int i = 0; i < headers.length; i++) {
            generateMawFiledSize(headers[i], body[i]);
            realSpace = maxSize + add;
            for (int j = 0; j < realSpace; j++) {
                print("-");
            }
        }
        endl(1);
    }


    private static void printCase(String color) {
        tempColor = color;
        print("|");
        printSpace(1);
    }


    public static void printField(String key, String value) {
        System.out.print("  ");
        printKeyVal(key, value);
    }

    public static <T> void printClass(T object) {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        System.out.println(clazz.getSimpleName() + " : {");

        for (Field field : fields) {
            field.setAccessible(true);

            String fieldName = field.getName();
            String fieldValue;

            try {
                Object value = field.get(object);
                fieldValue = value != null ? value.toString() : "null";
            } catch (IllegalAccessException e) {
                fieldValue = "N/A";
            }

            printField(fieldName, fieldValue);
        }

        System.out.println("}");
    }

    public static <T> void printClassList(List<T> objects) {
        System.out.println("-------------------------------start list-------------------------------------");
        for (T object : objects) {
            printClass(object);
        }
        System.out.println("-------------------------------end list---------------------------------------");
    }

    private static void printTableHeader(String[] headers, String[] body) {
        printHCase(headers, body, "cyan");
        int realSize;

        for (int i = 0; i < headers.length; i++) {

            if (i >= 1) printSpace(1);
            printVCases();

            tempColor = "yellow";
            print(headers[i]);
            generateMawFiledSize(headers[i], body[i]);
            realSize = maxSize - headers[i].length();
            if (i >= 1) printSpace(realSize);

        }

        printVCases();
        endl(1);
        printHCase(headers, body, "cyan");


    }


    public static void printTableBody(String[] headers, String[] body) {
        int realSize;
        for (int i = 0; i < headers.length; i++) {

            if (i >= 1) printSpace(1);
            printVCases();

            tempColor = "green";
            print(body[i]);
            generateMawFiledSize(headers[i], body[i]);
            realSize = maxSize - body[i].length();
            if (i >= 1) printSpace(realSize);
        }

        printVCases();
        endl(1);
        printHCase(headers, body, "cyan");
    }


    public static <T> void printModelTable(T model) {
        String[] headers = ObjectHelper.getModelHeader(model);
        String[] body = ObjectHelper.getModelBody(model);
        printTableHeader(headers, body);
        printTableBody(headers, body);

    }

    public static <T> void printModelsTable(List<T> models) {
        if (models.isEmpty()) {
            return;
        }

        // Calculate the maximum field size for all objects
        int maxSize = calculateMaxFieldSize(models);

        // Print table header
        String[] headers = ObjectHelper.getModelHeader(models.get(0));
        for (int i = 0; i < headers.length; i++) {
            if (i >= 1) printSpace(1);
            printCase("cyan");
            tempColor = "yellow";
            print(headers[i]);
            printSpace(maxSize - headers[i].length());
        }
        printCase("cyan");
        endl(1);

        // Print table body
        for (T model : models) {
            String[] body = ObjectHelper.getModelBody(model);
            for (int i = 0; i < body.length; i++) {
                if (i >= 1) printSpace(1);
                printCase("cyan");
                tempColor = "green";
                print(body[i]);
                printSpace(maxSize - body[i].length());
            }
            printCase("cyan");
            endl(1);
        }
    }










    private static int calculateMaxFieldSize(List<?> objects) {
        int maxSize = 0;
        for (Object object : objects) {
            Class<?> clazz = object.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldValue;
                try {
                    Object value = field.get(object);
                    fieldValue = value != null ? value.toString() : "null";
                    int fieldSize = fieldValue.length();
                    if (fieldSize > maxSize) {
                        maxSize = fieldSize;
                    }
                } catch (IllegalAccessException e) {
                    // Handle the exception or log it as needed
                }
            }
        }
        return maxSize;
    }


}
