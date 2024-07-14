package com.javareflection.test.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Transformator {

    public <I, O> O transform(I input) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> source = input.getClass();
        Class<?> target = Class.forName(source + "DTO");

        O targetClass = (O) target.getDeclaredConstructor().newInstance();

        Field[] fieldsSource = source.getDeclaredFields();
        Field[] fieldsTarget = target.getDeclaredFields();

        Arrays.stream(fieldsSource).forEach(fieldSource ->
                Arrays.stream(fieldsTarget).forEach(fieldTarget -> {
                    validate(fieldSource, fieldTarget);
                    try {
                        fieldTarget.set(targetClass, fieldSource.get(input));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }));
        return targetClass;
    }

    private void validate(Field fieldSource, Field fieldTarget) {
        if(fieldSource.getName().equals(fieldTarget.getName())
                && fieldSource.getType().equals(fieldTarget.getType())) {
            fieldSource.setAccessible(true);
            fieldTarget.setAccessible(true);
        }
    }
}
