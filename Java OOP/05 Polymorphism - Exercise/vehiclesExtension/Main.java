package vehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(" ");
        Vehicle car = new Car(Double.parseDouble(data[1]), Double.parseDouble(data[2]), Double.parseDouble(data[3]));

        data = scanner.nextLine().split(" ");
        Vehicle truck = new Truck(Double.parseDouble(data[1]), Double.parseDouble(data[2]), Double.parseDouble(data[3]));

        data = scanner.nextLine().split(" ");
        double asd = Double.parseDouble(data[2]);
        Vehicle bus = new Bus(Double.parseDouble(data[1]), Double.parseDouble(data[2]), Double.parseDouble(data[3]));

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            data = scanner.nextLine().split(" ");

            String command = data[0];
            String vehicle = data[1];
            double km = Double.parseDouble(data[2]);
            if (km <= 0) {
                System.out.println("Fuel must be a positive number");
                continue;
            }

            String output = null;

            if (command.equals("Drive")) {
                if (vehicle.equals("Bus")) {
                    bus.setFuelConsumption(asd + 1.4);
                }
                output = vehicles.get(vehicle).drive(km);
            } else if (command.equals("Refuel")) {
                vehicles.get(vehicle).refuel(km);

            } else {
                bus.setFuelConsumption(asd);
                output = vehicles.get(vehicle).drive(km);
            }

            if (output != null) {
                System.out.println(output);
            }

        }

        vehicles.forEach((key, value) -> System.out.println(value));


    }
}
