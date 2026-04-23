package org.javalabs.decl.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Utility Class for creating object on the fly.
 *
 * @author Sudiptasish Chanda
 */
public final class ObjectCreator {
    
    /**
     * Create and return the instance of the class designated by this className.
     * It uses the no-argument constructor (default one) while instantiating
     * the object (provided the no-argument constructor is defined).
     * 
     * @param   <T>         Class type
     * @param   className   Class name
     * 
     * @return  T
     */
    @SuppressWarnings("unchecked")
    public static <T> T create(String className) {
        try {
            Class<?> clazz = Class.forName(className.trim());
            Object obj = clazz.getDeclaredConstructor().newInstance();
            return (T) obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T create(String className, Class[] paramTypes, Object[] params) {
        try {
            Class<?> clazz = Class.forName(className.trim());
            Object obj = clazz.getDeclaredConstructor(paramTypes).newInstance(params);
            return (T) obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}