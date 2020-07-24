package vehicles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(" ");

        Vehicle car = new Car(Double.parseDouble(data[1]), Double.parseDouble(data[2]));

        data = scanner.nextLine().split(" ");

        Vehicle truck = new Truck(Double.parseDouble(data[1]), Double.parseDouble(data[2]));

        Map<String, Vehicle> vehicles = new HashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            data = scanner.nextLine().split(" ");

            String command = data[0];
            String vehicle = data[1];
            double km = Double.parseDouble(data[2]);

            String output = null;

            if (command.equals("Drive")) {
                output = vehicles.get(vehicle).drive(km);
            } else {
                vehicles.get(vehicle).refuel(km);

            }

            if (output != null) {
                System.out.println(output);
            }

        }

        vehicles.forEach((key, value) -> System.out.println(value));


    }
}
