package wildFarm.animals;

import wildFarm.foods.Food;

public class Cat extends Felime {

    private String breed;

    public Cat(String name, String type, Double weight, String livingRegion, String breed) {
        super(name, type, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");

    }

    @Override
    public String toString() {
        String baseToStr = super.toString();
        int index = baseToStr.indexOf(",");

        StringBuilder builder = new StringBuilder(baseToStr);
        builder.insert(index + 2, this.breed + ", ");

        return builder.toString();
    }
}
