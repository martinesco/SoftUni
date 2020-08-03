package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        RichSoilLand richSoilLand = new RichSoilLand();

        Class reflectionClass = richSoilLand.getClass();
        Field[] fields = reflectionClass.getDeclaredFields();

		List<String> all = new ArrayList<>();

        while (!line.equals("HARVEST")) {

            switch (line) {
                case "private":
                    Arrays.stream(fields)
                            .filter(f -> Modifier.isPrivate(f.getModifiers()))
                            .forEach(field -> System.out.println(String.format("%s %s %s",
									Modifier.toString(field.getModifiers()),
                                    field.getType().getSimpleName(),
                                    field.getName()
                            )));
                    break;
                case "protected":
                    Arrays.stream(fields)
                            .filter(f -> Modifier.isProtected(f.getModifiers()))
                            .forEach(field -> System.out.println(String.format("%s %s %s",
									Modifier.toString(field.getModifiers()),
                                    field.getType().getSimpleName(),
                                    field.getName()
                            )));
                    break;
                case "public":
                    Arrays.stream(fields)
                            .filter(f -> Modifier.isPublic(f.getModifiers()))
                            .forEach(field -> System.out.println(String.format("%s %s %s",
									Modifier.toString(field.getModifiers()),
                                    field.getType().getSimpleName(),
                                    field.getName()
                            )));
                    break;
                case "all":
                    for (Field field : fields) {
                        String format = String.format("%s %s %s",
								Modifier.toString(field.getModifiers()),
								field.getType().getSimpleName(),
								field.getName()
                        );

						all.add(format);

                    }

                    all.forEach(System.out::println);


					/*Arrays.stream(fields)
							.forEach(field -> System.out.println(String.format("%s %s %s",
									field.getModifiers(),
									field.getType(),
									field.getName()
							)));*/
                    break;
            }
            line = scanner.nextLine();
        }
        System.out.println();


    }
}
