package org.pb.annotation;

import javafx.scene.control.Tab;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author boge.peng
 * @create 2018-12-25 0:03
 */
public class Demo01 {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("org.pb.annotation.Employee");
            /*获得类的所有有效注解*/
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }

            /*获得类的指定注解*/
            Table annotation = clazz.getAnnotation(Table.class);
            System.out.println(annotation+"----->"+annotation.value());

            System.out.println("属性注解");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                Column fieldAnnotation = field.getAnnotation(Column.class);
                System.out.println(fieldAnnotation.columnName()+"--"+fieldAnnotation.type()+"--"+fieldAnnotation.length());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
