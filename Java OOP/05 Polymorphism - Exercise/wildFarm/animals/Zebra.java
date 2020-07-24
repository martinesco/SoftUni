package wildFarm.animals;

import wildFarm.foods.Food;

public class Zebra extends Mammal {
    public Zebra(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public void makeSound() {

        System.out.println("Zs");
    }

}
