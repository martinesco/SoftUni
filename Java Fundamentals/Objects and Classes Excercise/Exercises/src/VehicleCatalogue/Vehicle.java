package VehicleCatalogue;

public class Vehicle {

    private String type;
    private String model;
    private String colour;
    private int horsepower;

    public Vehicle(String type, String model, String colour, int horsepower) {
        this.type = type;
        this.model = model;
        this.colour = colour;
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        return String.format("Type: " + type.toUpperCase().charAt(0) + type.substring(1)
                + "\nModel: " + model
                + "\nColor: " + colour
                + "\nHorsepower: " + horsepower);
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public int getHorsepower() {
        return horsepower;
    }
}
