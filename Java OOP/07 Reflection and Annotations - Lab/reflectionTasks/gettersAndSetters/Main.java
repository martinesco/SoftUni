package reflectionTasks.gettersAndSetters;

import reflectionTasks.Reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Reflection reflection = new Reflection();

        Class reflectionClass = reflection.getClass();
        Method[] allDeclaredMethodsGet = reflectionClass.getDeclaredMethods();

        Method[] getters = getMethodsStartWith("get", allDeclaredMethodsGet);
        Method[] setters = getMethodsStartWith("set", allDeclaredMethodsGet);

        Arrays.stream(getters)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> {
                    {
                        System.out.println(
                                String.format("%s will return class %s"
                                , m.getName()
                                , m.getReturnType().getSimpleName()));
                    }
                });

        Arrays.stream(setters)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> {
                    {
                        System.out.println(
                                String.format("%s and will set field of class %s"
                                        , m.getName()
                                        , m.getParameterTypes()[0].getSimpleName()));
                    }
                });

    }

    public static Method[] getMethodsStartWith(String with, Method[] methods) {
        return Arrays.stream(methods)
                .filter(m -> m.getName().startsWith(with))
                .toArray(Method[]::new);
    }

}
