package org.pb.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author boge.peng
 * @create 2018-12-26 12:30
 */
public class ReflectDemo01 {
    public static void main(String[] args) {
        String path = "org.pb.reflection.bean.Employee";

        try {
            Class<?> clazz = Class.forName(path);

            /*获取所有的属性*/
            System.out.println("========反射获取属性========");
            Field[] fields = clazz.getFields();
            System.out.println(fields.length);

            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                System.out.println(declaredField +"==="+declaredField.getName());
            }

            System.out.println("========反射获取方法========");
            Method[] methods = clazz.getMethods();
            System.out.println(methods.length);
            Method[] declaredMethods = clazz.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                System.out.println(declaredMethod);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
