package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("All")
public class Main {
    public static void main(String[] args) {

        BlackBoxInt blackBoxInt = null;

        Field innerValue = null;


        try {
            Constructor constructor = BlackBoxInt.class.getDeclaredConstructor();

            constructor.setAccessible(true);

            blackBoxInt = (BlackBoxInt) constructor.newInstance();


            innerValue = BlackBoxInt.class.getDeclaredField("innerValue");
            innerValue.setAccessible(true);

        } catch (NoSuchMethodException
                | InstantiationException
                | InvocationTargetException
                | IllegalAccessException
                | NoSuchFieldException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Method[] methods = BlackBoxInt.class.getDeclaredMethods();

        while (!line.equals("END")) {

            String command = line.substring(0, line.indexOf("_"));
            int value = Integer.parseInt(line.substring(line.indexOf("_") + 1));

            Method method = Arrays.stream(methods)
                    .filter(m -> m.getName().equals(command))
                    .findFirst()
                    .orElse(null);

            method.setAccessible(true);
            try {
                method.invoke(blackBoxInt, value);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }


            try {
                System.out.println(innerValue.getInt(blackBoxInt));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }


            line = scanner.nextLine();
        }
    }
}
