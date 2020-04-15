package VehicleCatalogue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Vehicle> vehicles = new ArrayList<>();

        while (!line.equals("End")){

            String [] tokens = line.split(" ");

                vehicles.add(new Vehicle(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3])));

            line=scanner.nextLine();
        }

        line = scanner.nextLine();

        while (!line.equals("Close the Catalogue")){

           /* String finalModel = line;

            vehicles
                    .stream()
                    .filter(v->v.getModel().equals(finalModel))
                    .forEach(System.out::println);*/

            for (Vehicle car : vehicles){

                if (car.getModel().equals(line)){
                    System.out.println(car.toString());
                }
            }

            line=scanner.nextLine();
        }

        System.out.println(
                String.format("Cars have average horsepower of: %.2f.",
                average(vehicles.stream()
                .filter(v -> v.getType().equals("car"))
                .collect(Collectors.toList()))));

        System.out.println(
                String.format("Trucks have average horsepower of: %.2f.",
                        average(vehicles.stream()
                                .filter(v -> v.getType().equals("truck"))
                                .collect(Collectors.toList()))));

    }

    private static double average(List<Vehicle> vehicles){

        if (vehicles.size()==0){
            return 0.0;
        }

        double sum = 0;

        for (Vehicle vehicle : vehicles) {

            sum+=vehicle.getHorsepower();
        }

        return sum/vehicles.size();
    }
}
