import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();

        String name = scanner.nextLine();
        while (!name.equals("stop")) {

            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resources.containsKey(name)) {
                resources.put(name, quantity);
            } else {
                resources.put(name, resources.get(name) + quantity);
            }
            name = scanner.nextLine();

        }
        resources.forEach((key, value) -> {
            System.out.printf("%s -> %d\n", key, value);
        });


    }
}
