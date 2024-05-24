package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            Class<A> classA = A.class;

            Constructor<A> constructor = classA.getDeclaredConstructor();

            constructor.setAccessible(true);

            A instance = constructor.newInstance();

            Field idField = classA.getDeclaredField("id");
            Field nameField = classA.getDeclaredField("name");

            idField.setAccessible(true);
            nameField.setAccessible(true);

            idField.set(instance, "321");
            nameField.set(instance, "B");

            System.out.println(instance);
            
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

