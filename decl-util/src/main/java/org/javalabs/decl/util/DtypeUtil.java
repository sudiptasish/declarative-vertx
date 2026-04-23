package org.javalabs.decl.util;

/**
 * Utility class.
 *
 * @author schan280
 */
public class DtypeUtil {
    
    public static Boolean isPrimitive(Class<?> type) {
        return type == Byte.class || type == byte.class
                || type == Short.class || type == short.class
                || type == Integer.class || type == int.class
                || type == Long.class || type == long.class
                || type == Float.class || type == float.class
                || type == Double.class || type == double.class
                || type == Boolean.class || type == boolean.class
                || type == String.class
                || type == Character.class || type == char.class
                || type == byte[].class
                || type == short[].class
                || type == int[].class
                || type == long[].class
                || type == float[].class
                || type == double[].class
                || type == String[].class;
    }
}
