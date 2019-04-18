package com.geekbrains.lesson11;

import com.geekbrains.lesson11.annotations.AfterSuite;
import com.geekbrains.lesson11.annotations.BeforeSuite;
import com.geekbrains.lesson11.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Handler {
    private static Annotation annotationBS;
    private static Annotation annotationAS;

    static void start(Class aClass) {
        if (!checkAnnotations(aClass)) {
            throw new RuntimeException();
        } else {
            List<Method> list = searchMethods(aClass);
            try {
                Object object = aClass.newInstance();
                for (Method method : list) {
                    method.invoke(object);
                }
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<Method> searchMethods(Class aClass) {
        List<Method> list = new ArrayList<>();
        Method[] methods = aClass.getDeclaredMethods();
        Method beforeSuite = null;
        Method afterSuite = null;
        for (Method method : methods) {
            Annotation annotationT = method.getAnnotation(Test.class);
            annotationBS = method.getAnnotation(BeforeSuite.class);
            annotationAS = method.getAnnotation(AfterSuite.class);
            if (annotationT != null) {
                list.add(method);
            } else if (annotationAS != null) {
                afterSuite = method;
            } else if (annotationBS != null) {
                beforeSuite = method;
            }
        }
        list.sort(Comparator.comparing(obj -> obj.getAnnotation(Test.class).priority()));
        if (beforeSuite != null) {
            list.add(0, beforeSuite);
        }
        if (afterSuite != null) {
            list.add(afterSuite);
        }
        return list;
    }

    private static boolean checkAnnotations(Class aClass) {
        int countB = 0;
        int countA = 0;
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            annotationBS = method.getAnnotation(BeforeSuite.class);
            annotationAS = method.getAnnotation(AfterSuite.class);
            if (annotationBS != null) {
                countB++;
            }
            if (annotationAS != null) {
                countA++;
            }
        }
        return ((countB <= 1) && (countA <= 1));
    }
}
