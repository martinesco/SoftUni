package wildFarm.animals;

import wildFarm.foods.Food;

import java.text.DecimalFormat;

public abstract class Animal {

    private String name;
    private String type;
    private Double weight;
    private Integer foodEaten;

    protected Animal(String name, String type, Double weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.foodEaten = 0;
    }

    public abstract void makeSound();

    public void eat(Food food){
        this.foodEaten += food.getQuantity();
    }

    protected String getType() {
        return type;
    }


    @Override
    public String toString() {

        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        return String.format("%s[%s, %s, region, %d]",
                this.getType(),
                this.name,
                decimalFormat.format(this.weight),
                this.foodEaten
        );
    }


}
