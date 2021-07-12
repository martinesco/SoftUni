package reflectionTasks.reflection;

import reflectionTasks.Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class reflection = Reflection.class;

        System.out.println(reflection);

        Class superClass = reflection.getSuperclass();
        System.out.println(superClass);

        Class[] interfaces = reflection.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Object reflectionObject = reflection.getDeclaredConstructor().newInstance();
        System.out.println(reflectionObject);
    }
}