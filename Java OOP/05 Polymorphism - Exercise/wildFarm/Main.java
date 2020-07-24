package wildFarm;

import wildFarm.animals.*;
import wildFarm.foods.Food;
import wildFarm.foods.Meat;
import wildFarm.foods.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int counter = 0;

        List<Animal> animals = new ArrayList<>();
        List<Food> foods = new ArrayList<>();

        while (!line.equals("End")) {

            String[] data = line.split(" ");

            if (counter % 2 == 0) {
                String type = data[0];
                String name = data[1];
                double weight = Double.parseDouble(data[2]);
                String livingRegion = data[3];

                switch (type) {
                    case "Cat":
                        String breed = data[4];
                        Animal cat = new Cat(name, type, weight, livingRegion, breed);
                        animals.add(cat);
                        break;
                    case "Tiger":
                        Animal tiger = new Tiger(name, type, weight, livingRegion);
                        animals.add(tiger);
                        break;
                    case "Zebra":
                        Animal zebra = new Zebra(name, type, weight, livingRegion);
                        animals.add(zebra);
                        break;
                    case "Mouse":
                        Animal mouse = new Mouse(name, type, weight, livingRegion);
                        animals.add(mouse);
                        break;
                    default:
                        System.out.println("Bad input");
                        break;
                }
            } else {
                String foodType = data[0];
                int quantity = Integer.parseInt(data[1]);

                switch (foodType) {
                    case "Vegetable":
                        Food vegetable = new Vegetable(quantity);
                        foods.add(vegetable);
                        break;
                    case "Meat":
                        Food meat = new Meat(quantity);
                        foods.add(meat);
                        break;
                    default:
                        System.out.println("Bad input");
                        break;
                }

                animals.get(counter/2).makeSound();

                try {
                    animals.get(counter/2).eat(foods.get(counter/2));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }

            counter++;
            line = scanner.nextLine();
        }


        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }

    }
}
