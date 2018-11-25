package org.ican.two;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-23 3:50 PM
 */
public class ReflectTest {

    public void process(
            @Header("name") String name,
            @Header("age") int age,
            @Header("number") long number) {

        String format = String.format("name:%s,age:%d,number:%d", name, age, number);
        System.out.println(format);
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Method[] methods = ReflectTest.class.getMethods();
        ReflectTest obj = ReflectTest.class.newInstance();

        List<Object> invokeArgs = new ArrayList<>();


        for (Method method : methods) {
            if (method.getName().equals("process")) {
                Parameter[] parameters = method.getParameters();
                for (Parameter parameter : parameters) {
                    if (parameter.isAnnotationPresent(Header.class)) {
                        Type parameterizedType = parameter.getParameterizedType();
                        Class type = parameter.getType();
                        if (String.class instanceof Object) {
                            System.out.println(true);
                        }
                        boolean assignableFrom = String.class.isAssignableFrom(type);

                        System.out.println(assignableFrom);


                        Header annotation = parameter.getAnnotation(Header.class);
                        String value = annotation.value();
                        invokeArgs.add(value);
                    } else {
                        invokeArgs.add(null);
                    }
                }


                boolean foundCandidate = false;


                Class<?>[] parameterTypes = method.getParameterTypes();
                System.out.println(Arrays.toString(parameterTypes));

                method.invoke(obj, "大佬", "1", 2);

            }

        }

    }


}
