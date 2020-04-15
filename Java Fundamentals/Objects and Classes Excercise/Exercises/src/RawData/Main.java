package RawData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        //cars should be printed in order of appearing in the input.
        List<Car> carsList = new LinkedList<>();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split(" ");

            String model = data[0];

            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            double tire1Pressure = Double.parseDouble(data[5]);
            int tire1Age = Integer.parseInt(data[6]);
            double tire2Pressure = Double.parseDouble(data[7]);
            int tire2Age = Integer.parseInt(data[8]);
            double tire3Pressure = Double.parseDouble(data[9]);
            int tire3Age = Integer.parseInt(data[10]);
            double tire4Pressure = Double.parseDouble(data[11]);
            int tire4Age = Integer.parseInt(data[12]);
            Tire tire1 = new Tire(tire1Pressure, tire1Age);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);
            List<Tire> tires = new ArrayList<>();
            tires.add(tire1);
            tires.add(tire2);
            tires.add(tire3);
            tires.add(tire4);

            carsList.add(new Car(model, engine, cargo, tires));

        }

        String command = scanner.nextLine();

        switch (command) {

            case "fragile": //print all cars whose Cargo Type is “fragile” with a tire whose pressure is  < 1

                carsList.forEach(car -> {{
                        if (car.getCargo().getType().equals("fragile") && haveLowPressure(car.getTires())) {
                            System.out.println(car.getModel());
                        }
                    }
                });

                break;

            case "flamable"://print all cars whose Cargo Type is “flamable” and have Engine Power > 250

                carsList.forEach(car -> {{

                    if (car.getCargo().getType().equals("flamable") && car.getEngine().getPower()>250){
                        System.out.println(car.getModel());
                    }
                }
                });



                break;
        }

    }

    private static boolean haveLowPressure(List<Tire> tires) {

        for (Tire tire : tires) {
            if (tire.getPressure() < 1) {
                return true;
            }
        }
        return false;
    }
}
